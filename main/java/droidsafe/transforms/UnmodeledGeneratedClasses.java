package droidsafe.transforms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.transforms.objsensclone.ClassCloner;
import droidsafe.utils.SootUtils;
import soot.ArrayType;
import soot.Local;
import soot.Modifier;
import soot.PrimType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.Type;
import soot.Value;
import soot.VoidType;
import soot.jimple.IntConstant;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.NullConstant;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;

public class UnmodeledGeneratedClasses {
    private final static Logger logger = LoggerFactory.getLogger(UnmodeledGeneratedClasses.class);

    private static UnmodeledGeneratedClasses v = null;

    public static final String DUMMIES_CLASS_NAME = Project.DS_GENERATED_CLASSES_PREFX + "DroidSafeDummies";

    public static final String UNKNOWN_TAINT_METHOD_PREFIX = "getUnmodeledTaint";

    public static final String DUMMY_FIELD_PREFIX = "__DUMMY_FIELD_";

    private static final String noArgConsSubSig = "void <init>()";

    private SootClass dummyClass;

    private Map<Type,SootField> typeToAddedField;

    private SootMethod dummyInit;

    private JimpleBody dummyInitBody;

    private Stmt addBefore;

    public static int localID = 0;

    public static void reset() {
        v = null;
    }

    public static UnmodeledGeneratedClasses v() {
        if (v == null) 
            v = new UnmodeledGeneratedClasses();

        return v;
    }

    public SootMethod getInitMethod() {
        return dummyInit;
    }

    private UnmodeledGeneratedClasses() {
        typeToAddedField = new HashMap<Type,SootField>();
        //create class with fields, all initialized in a method or static init
        createClass();
    }


    private void createClass() {
        //create the harness class
        dummyClass = new SootClass(DUMMIES_CLASS_NAME, Modifier.PUBLIC | Modifier.FINAL);
        dummyClass.setSuperclass(Scene.v().getSootClass("java.lang.Object"));

        API.v().addSystemClass(dummyClass);

        Scene.v().addClass(dummyClass);
        Scene.v().loadClass(dummyClass.getName(), SootClass.BODIES);
        dummyClass.setApplicationClass();    

        //create the dummy init methods called by harness
        List<Type> args = new LinkedList<Type>();
        dummyInit = new SootMethod("dummyInit", 
            args, VoidType.v(),
            Modifier.PUBLIC | Modifier.STATIC);

        dummyInit.setDeclaringClass(dummyClass);
        dummyClass.addMethod(dummyInit);

        dummyInitBody = Jimple.v().newBody(dummyInit);
        dummyInit.setActiveBody(dummyInitBody);

        addBefore = Jimple.v().newReturnVoidStmt();

        dummyInitBody.getUnits().add(addBefore);

        API.v().addSafeMethod(dummyInit);
    }

    private void addStmt(Stmt stmt) {
        dummyInitBody.getUnits().insertBefore(stmt, addBefore);
    }

    private void addPrimitiveOrString(Type type) {
        String suffix = "";
        if (SootUtils.isStringType(type)) {
            suffix = "String";

        } else if (type instanceof PrimType) {
            suffix = Character.toUpperCase(type.toString().charAt(0)) + type.toString().substring(1);
        }

        SootField field = new SootField(DUMMY_FIELD_PREFIX + suffix, type, Modifier.PUBLIC | Modifier.STATIC);

        dummyClass.addField(field);

        typeToAddedField.put(type, field);

        //create call in dummy init to initialize value
        SootMethod getTaintMethod = Scene.v().getMethod("<" + Harness.RUNTIME_MODELING_CLASS + ": " + 
                type.toString() + " " + 
                UNKNOWN_TAINT_METHOD_PREFIX + suffix + "()>");

        //add initialization code to dummy init method
        Local local = Jimple.v().newLocal("UG" + localID++, type);
        dummyInitBody.getLocals().add(local);

        //local = getTaint()
        //field = local

        addStmt(Jimple.v().newAssignStmt(
            local,
            Jimple.v().newStaticInvokeExpr(getTaintMethod.makeRef())
                ));

        addStmt(Jimple.v().newAssignStmt(Jimple.v().newStaticFieldRef(field.makeRef()), local));
    }

    private void addArrayType(ArrayType type) {
        Type baseType = type.getArrayElementType();
        JimpleBody body = dummyInitBody;

        Value baseValue = getSootFieldForType(baseType);

        if (baseValue == null)
            return;

        //create a local for the field reference
        Local dummyLocal = Jimple.v().newLocal("TU" + localID++, baseValue.getType());
        body.getLocals().add(dummyLocal);

        //create new array to local     
        Local arrayLocal = Jimple.v().newLocal("TU" + localID++, type);
        body.getLocals().add(arrayLocal);

        if (type.numDimensions > 1) {
            //multiple dimensions, have to do some crap...
            List<Value> ones = new LinkedList<Value>();
            for (int i = 0; i < type.numDimensions; i++)
                ones.add(IntConstant.v(1));

            addStmt(Jimple.v().newAssignStmt(arrayLocal,
                Jimple.v().newNewMultiArrayExpr(type, ones)));
        } else {
            //single dimension, add new expression
            addStmt(Jimple.v().newAssignStmt(arrayLocal, 
                Jimple.v().newNewArrayExpr(baseType, IntConstant.v(1))));
        }

        //get down to an element through the dimensions
        Local elementPtr = arrayLocal;
        while (((ArrayType)elementPtr.getType()).getElementType() instanceof ArrayType) {
            Local currentLocal = Jimple.v().newLocal("MULTIARRAY" + localID++, ((ArrayType)elementPtr).getElementType());
            addStmt(Jimple.v().newAssignStmt(
                currentLocal, 
                Jimple.v().newArrayRef(elementPtr, IntConstant.v(0))));
            elementPtr = currentLocal;
        }

        //assign only element of array to the field of the base type we got above
        addStmt(Jimple.v().newAssignStmt(dummyLocal, baseValue));

        //assign the new local to the array access
        addStmt(Jimple.v().newAssignStmt(
            Jimple.v().newArrayRef(elementPtr, IntConstant.v(0)), 
            dummyLocal)); 

    }

    private void addRefType(RefType type) {
        //see if any current type can replace it
        SootClass clz = type.getSootClass();
        //if an interface, find a direct implementor of and instantiate that...
        if (!clz.isConcrete()) {
            clz = SootUtils.getCloseConcrete(clz);
        }

        if (clz ==  null) {
            //if clz is null, then we have an interface with no known implementors, 
            //so just pass null
            logger.warn("Cannot find any known implementors of {} when adding dummy object", 
                type.getSootClass());
            return;
        }

        //clone clz
        ClassCloner cloner = ClassCloner.cloneClass(clz, true);
        SootClass clone = cloner.getClonedClass();
        
        logger.info("Creating cloned class for fallback modeling: {}", clone);

        //make all methods of unmodeled type
        for (SootMethod method : clone.getMethods()) {
            API.v().addSourceInfoKind(method, "UNMODELED");
        }

        //field and add creation of object
        if (!clone.declaresMethod(noArgConsSubSig)) {
            logger.error("Error during fallback modeling. Class {} does not have a no arg constructor.", clone);
            return;
        }

        SootField field = new SootField(DUMMY_FIELD_PREFIX + type.toString().replace(".", "_"), 
            type, Modifier.PUBLIC | Modifier.STATIC);
        dummyClass.addField(field);
        typeToAddedField.put(type, field);

        //add initialization code to dummy init method
        Local local = Jimple.v().newLocal("UG" + localID++, type);
        dummyInitBody.getLocals().add(local);

        //local = new Clone()
        //local.init();
        //field = local
        addStmt(Jimple.v().newAssignStmt(local, Jimple.v().newNewExpr(clone.getType())));
        addStmt(Jimple.v().newInvokeStmt(Jimple.v().newSpecialInvokeExpr(local, clone.getMethod(noArgConsSubSig).makeRef())));
        addStmt(Jimple.v().newAssignStmt(Jimple.v().newStaticFieldRef(field.makeRef()), local));
    }

    public Value getSootFieldForType(Type type) {
        if (!typeToAddedField.containsKey(type)) {
            //not a type we have seen before

            //if a reference, create dummy object
            if (type instanceof RefType) {
                //class type
                if (SootUtils.isStringType(type))
                    addPrimitiveOrString(type);
                else
                    addRefType((RefType)type);
            } else if (type instanceof ArrayType) {
                //array type
                addArrayType((ArrayType)type);
            } else {
                addPrimitiveOrString(type);
            } 
        }

        SootField field = typeToAddedField.get(type);

        if (field == null)
            return NullConstant.v();

        return Jimple.v().newStaticFieldRef(field.makeRef());
    }

}
