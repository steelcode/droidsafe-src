package android.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface IKeyChainAliasCallback extends android.os.IInterface
{

public static abstract class Stub extends android.os.Binder implements android.security.IKeyChainAliasCallback
{
private static final java.lang.String DESCRIPTOR = "android.security.IKeyChainAliasCallback";

public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}

public static android.security.IKeyChainAliasCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = (android.os.IInterface)obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof android.security.IKeyChainAliasCallback))) {
return ((android.security.IKeyChainAliasCallback)iin);
}
return new android.security.IKeyChainAliasCallback.Stub.Proxy(obj);
}
public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_alias:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.alias(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements android.security.IKeyChainAliasCallback
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
public void alias(java.lang.String alias) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(alias);
mRemote.transact(Stub.TRANSACTION_alias, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_alias = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void alias(java.lang.String alias) throws android.os.RemoteException;
}
