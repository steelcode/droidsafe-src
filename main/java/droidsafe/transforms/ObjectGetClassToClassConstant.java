package droidsafe.transforms;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.app.Project;
import droidsafe.transforms.objsensclone.ClassCloner;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import soot.Body;
import soot.BodyTransformer;
import soot.jimple.AssignStmt;
import soot.jimple.ClassConstant;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.jimple.toolkits.pta.IClassConstantNode;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.util.Chain;

/**
 * Tranformer called on all modeled app classes that will find all invocations of Object.getClass and replace them with
 * a class constant
 * 
 * @author dpetters
 */

public class ObjectGetClassToClassConstant extends BodyTransformer {
    private static int LOCAL_ID = 0;
    private static final String LOCAL_PREFIX = "OBJECTGETCLASS_TO_CLASSCONSTANT_LOCAL";

    /**
     * Call this pass on all modeld app classes in the project.
     */
    public static void run() {
        ObjectGetClassToClassConstant transformer = new ObjectGetClassToClassConstant();
        for (SootClass clz : Scene.v().getClasses()) {
            for (SootMethod meth : clz.getMethods()) {
                if (meth.isConcrete())
                    transformer.transform(meth.retrieveActiveBody());
            }
        }
    }
    
    protected void internalTransform(Body b, String phaseName, Map options)  {
        StmtBody stmtBody = (StmtBody)b;
        // get body's unit as a chain
        Chain units = stmtBody.getUnits();
        // get a snapshot iterator of the unit since we are going to mutate the chain when iterating over it.
        Iterator stmtIt = units.snapshotIterator();

        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();
         
            if (!stmt.containsInvokeExpr()) {
                continue;
            }
         
            replaceObjectGetClassWithClassConstant(stmtBody, units, stmt);
        }
    }

    private void replaceObjectGetClassWithClassConstant(StmtBody stmtBody, Chain units, Stmt stmt) {
        if (!(stmt instanceof AssignStmt) || !(((AssignStmt)stmt).getRightOp() instanceof InvokeExpr))
            return;

        AssignStmt assign = (AssignStmt)stmt;
        InvokeExpr invoke = (InvokeExpr)assign.getRightOp();
        try {
            Collection<SootMethod> targets = PTABridge.v().resolveInvoke(invoke);

            if (targets.size() != 1)
                return;
            
            //if we get here we have one target
            for (SootMethod target : targets) {
                //replace java.lang.Object.getClass() with a class constant if possible
                System.out.println(target.getSignature());
                if ("<java.lang.Object: java.lang.Class getClass()>".equals(target.getSignature())) {
                    InstanceInvokeExpr iie = (InstanceInvokeExpr) invoke;
                    Set<? extends IAllocNode> nodes = PTABridge.v().getPTSet(iie.getBase());
                    // add a local variable
                    Local newLocal = Jimple.v().newLocal(LOCAL_PREFIX + LOCAL_ID++, RefType.v("java.lang.Class"));
                    stmtBody.getLocals().add(newLocal);
                           
                    for (IAllocNode node : nodes) {
                        String className = ClassCloner.removeClassCloneSuffix(((RefType)node.getType()).getClassName());
                        ClassConstant classConstant = ClassConstant.v(className.replace(".", "/"));
                        AssignStmt localAssign = Jimple.v().newAssignStmt(newLocal, classConstant);
                        System.out.println("localAssign: " + localAssign);
                        units.insertBefore(localAssign, stmt);
                        assign.setRightOp(newLocal);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception!: " + e);
        }
        
        return;
    }
}
