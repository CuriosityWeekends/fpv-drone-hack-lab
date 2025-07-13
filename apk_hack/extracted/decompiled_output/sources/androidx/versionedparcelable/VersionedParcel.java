package androidx.versionedparcelable;

import a1.i;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap<String, Class> mParcelizerCache;
    protected final ArrayMap<String, Method> mReadCache;
    protected final ArrayMap<String, Method> mWriteCache;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th) {
            super(th);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    private Exception createException(int i3, String str) {
        switch (i3) {
            case EX_PARCELABLE /* -9 */:
                return (Exception) readParcelable();
            case -8:
            default:
                return new RuntimeException("Unknown exception code: " + i3 + " msg " + str);
            case EX_UNSUPPORTED_OPERATION /* -7 */:
                return new UnsupportedOperationException(str);
            case EX_NETWORK_MAIN_THREAD /* -6 */:
                return new NetworkOnMainThreadException();
            case -5:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
        }
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> cls) {
        Class cls2 = this.mParcelizerCache.get(cls.getName());
        if (cls2 == null) {
            String name = cls.getPackage().getName();
            String simpleName = cls.getSimpleName();
            Class<?> cls3 = Class.forName(name + "." + simpleName + "Parcelizer", false, cls.getClassLoader());
            this.mParcelizerCache.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }

    private Method getReadMethod(String str) {
        Method method = this.mReadCache.get(str);
        if (method == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
            this.mReadCache.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    @NonNull
    public static Throwable getRootCause(@NonNull Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    private <T> int getType(T t4) {
        if (t4 instanceof String) {
            return 4;
        }
        if (t4 instanceof Parcelable) {
            return 2;
        }
        if (t4 instanceof VersionedParcelable) {
            return 1;
        }
        if (t4 instanceof Serializable) {
            return 3;
        }
        if (t4 instanceof IBinder) {
            return 5;
        }
        if (t4 instanceof Integer) {
            return 7;
        }
        if (t4 instanceof Float) {
            return 8;
        }
        throw new IllegalArgumentException(t4.getClass().getName().concat(" cannot be VersionedParcelled"));
    }

    private Method getWriteMethod(Class cls) {
        Method method = this.mWriteCache.get(cls.getName());
        if (method == null) {
            Class findParcelClass = findParcelClass(cls);
            System.currentTimeMillis();
            Method declaredMethod = findParcelClass.getDeclaredMethod("write", cls, VersionedParcel.class);
            this.mWriteCache.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    private <T, S extends Collection<T>> S readCollection(S s) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 != 1) {
                if (readInt2 != 2) {
                    if (readInt2 != 3) {
                        if (readInt2 != 4) {
                            if (readInt2 == 5) {
                                while (readInt > 0) {
                                    s.add(readStrongBinder());
                                    readInt--;
                                }
                            }
                        } else {
                            while (readInt > 0) {
                                s.add(readString());
                                readInt--;
                            }
                        }
                    } else {
                        while (readInt > 0) {
                            s.add(readSerializable());
                            readInt--;
                        }
                    }
                } else {
                    while (readInt > 0) {
                        s.add(readParcelable());
                        readInt--;
                    }
                }
            } else {
                while (readInt > 0) {
                    s.add(readVersionedParcelable());
                    readInt--;
                }
            }
        }
        return s;
    }

    private int readExceptionCode() {
        return readInt();
    }

    private <T> void writeCollection(Collection<T> collection, int i3) {
        setOutputField(i3);
        writeCollection(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeVersionedParcelableCreator(VersionedParcelable versionedParcelable) {
        try {
            writeString(findParcelClass(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName().concat(" does not have a Parcelizer"), e5);
        }
    }

    public abstract void closeField();

    public abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    public <T> T[] readArray(T[] tArr, int i3) {
        return !readField(i3) ? tArr : (T[]) readArray(tArr);
    }

    public abstract boolean readBoolean();

    public boolean readBoolean(boolean z3, int i3) {
        return !readField(i3) ? z3 : readBoolean();
    }

    public boolean[] readBooleanArray(boolean[] zArr, int i3) {
        return !readField(i3) ? zArr : readBooleanArray();
    }

    public abstract Bundle readBundle();

    public Bundle readBundle(Bundle bundle, int i3) {
        return !readField(i3) ? bundle : readBundle();
    }

    public byte readByte(byte b, int i3) {
        if (!readField(i3)) {
            return b;
        }
        return (byte) (readInt() & 255);
    }

    public abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] bArr, int i3) {
        return !readField(i3) ? bArr : readByteArray();
    }

    public char[] readCharArray(char[] cArr, int i3) {
        if (!readField(i3)) {
            return cArr;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        char[] cArr2 = new char[readInt];
        for (int i5 = 0; i5 < readInt; i5++) {
            cArr2[i5] = (char) readInt();
        }
        return cArr2;
    }

    public abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence charSequence, int i3) {
        return !readField(i3) ? charSequence : readCharSequence();
    }

    public abstract double readDouble();

    public double readDouble(double d, int i3) {
        return !readField(i3) ? d : readDouble();
    }

    public double[] readDoubleArray(double[] dArr, int i3) {
        return !readField(i3) ? dArr : readDoubleArray();
    }

    public Exception readException(Exception exc, int i3) {
        int readExceptionCode;
        return (readField(i3) && (readExceptionCode = readExceptionCode()) != 0) ? readException(readExceptionCode, readString()) : exc;
    }

    public abstract boolean readField(int i3);

    public abstract float readFloat();

    public float readFloat(float f4, int i3) {
        return !readField(i3) ? f4 : readFloat();
    }

    public float[] readFloatArray(float[] fArr, int i3) {
        return !readField(i3) ? fArr : readFloatArray();
    }

    public <T extends VersionedParcelable> T readFromParcel(String str, VersionedParcel versionedParcel) {
        try {
            return (T) getReadMethod(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e7);
        } catch (InvocationTargetException e8) {
            if (e8.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e8.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e8);
        }
    }

    public abstract int readInt();

    public int readInt(int i3, int i5) {
        return !readField(i5) ? i3 : readInt();
    }

    public int[] readIntArray(int[] iArr, int i3) {
        return !readField(i3) ? iArr : readIntArray();
    }

    public <T> List<T> readList(List<T> list, int i3) {
        if (!readField(i3)) {
            return list;
        }
        return (List) readCollection(new ArrayList());
    }

    public abstract long readLong();

    public long readLong(long j2, int i3) {
        return !readField(i3) ? j2 : readLong();
    }

    public long[] readLongArray(long[] jArr, int i3) {
        return !readField(i3) ? jArr : readLongArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> readMap(Map<K, V> map, int i3) {
        if (!readField(i3)) {
            return map;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap();
        if (readInt == 0) {
            return arrayMap;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        readCollection(arrayList);
        readCollection(arrayList2);
        for (int i5 = 0; i5 < readInt; i5++) {
            arrayMap.put(arrayList.get(i5), arrayList2.get(i5));
        }
        return arrayMap;
    }

    public abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T t4, int i3) {
        return !readField(i3) ? t4 : (T) readParcelable();
    }

    public Serializable readSerializable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        try {
            return (Serializable) new ObjectInputStream(new ByteArrayInputStream(readByteArray())) { // from class: androidx.versionedparcelable.VersionedParcel.1
                @Override // java.io.ObjectInputStream
                public Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
                    Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
                    if (cls != null) {
                        return cls;
                    }
                    return super.resolveClass(objectStreamClass);
                }
            }.readObject();
        } catch (IOException e5) {
            throw new RuntimeException(i.i("VersionedParcelable encountered IOException reading a Serializable object (name = ", readString, ")"), e5);
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException(i.i("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = ", readString, ")"), e6);
        }
    }

    public <T> Set<T> readSet(Set<T> set, int i3) {
        if (!readField(i3)) {
            return set;
        }
        return (Set) readCollection(new ArraySet());
    }

    @RequiresApi(api = 21)
    public Size readSize(Size size, int i3) {
        if (!readField(i3)) {
            return size;
        }
        if (readBoolean()) {
            return new Size(readInt(), readInt());
        }
        return null;
    }

    @RequiresApi(api = 21)
    public SizeF readSizeF(SizeF sizeF, int i3) {
        if (!readField(i3)) {
            return sizeF;
        }
        if (readBoolean()) {
            return new SizeF(readFloat(), readFloat());
        }
        return null;
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i3) {
        if (!readField(i3)) {
            return sparseBooleanArray;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(readInt);
        for (int i5 = 0; i5 < readInt; i5++) {
            sparseBooleanArray2.put(readInt(), readBoolean());
        }
        return sparseBooleanArray2;
    }

    public abstract String readString();

    public String readString(String str, int i3) {
        return !readField(i3) ? str : readString();
    }

    public abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder iBinder, int i3) {
        return !readField(i3) ? iBinder : readStrongBinder();
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T t4, int i3) {
        return !readField(i3) ? t4 : (T) readVersionedParcelable();
    }

    public abstract void setOutputField(int i3);

    public void setSerializationFlags(boolean z3, boolean z5) {
    }

    public <T> void writeArray(T[] tArr, int i3) {
        setOutputField(i3);
        writeArray(tArr);
    }

    public abstract void writeBoolean(boolean z3);

    public void writeBoolean(boolean z3, int i3) {
        setOutputField(i3);
        writeBoolean(z3);
    }

    public void writeBooleanArray(boolean[] zArr, int i3) {
        setOutputField(i3);
        writeBooleanArray(zArr);
    }

    public abstract void writeBundle(Bundle bundle);

    public void writeBundle(Bundle bundle, int i3) {
        setOutputField(i3);
        writeBundle(bundle);
    }

    public void writeByte(byte b, int i3) {
        setOutputField(i3);
        writeInt(b);
    }

    public abstract void writeByteArray(byte[] bArr);

    public void writeByteArray(byte[] bArr, int i3) {
        setOutputField(i3);
        writeByteArray(bArr);
    }

    public abstract void writeByteArray(byte[] bArr, int i3, int i5);

    public void writeCharArray(char[] cArr, int i3) {
        setOutputField(i3);
        if (cArr != null) {
            writeInt(cArr.length);
            for (char c : cArr) {
                writeInt(c);
            }
            return;
        }
        writeInt(-1);
    }

    public abstract void writeCharSequence(CharSequence charSequence);

    public void writeCharSequence(CharSequence charSequence, int i3) {
        setOutputField(i3);
        writeCharSequence(charSequence);
    }

    public abstract void writeDouble(double d);

    public void writeDouble(double d, int i3) {
        setOutputField(i3);
        writeDouble(d);
    }

    public void writeDoubleArray(double[] dArr, int i3) {
        setOutputField(i3);
        writeDoubleArray(dArr);
    }

    public void writeException(Exception exc, int i3) {
        int i5;
        setOutputField(i3);
        if (exc == null) {
            writeNoException();
            return;
        }
        if ((exc instanceof Parcelable) && exc.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            i5 = EX_PARCELABLE;
        } else if (exc instanceof SecurityException) {
            i5 = -1;
        } else if (exc instanceof BadParcelableException) {
            i5 = -2;
        } else if (exc instanceof IllegalArgumentException) {
            i5 = -3;
        } else if (exc instanceof NullPointerException) {
            i5 = -4;
        } else if (exc instanceof IllegalStateException) {
            i5 = -5;
        } else if (exc instanceof NetworkOnMainThreadException) {
            i5 = EX_NETWORK_MAIN_THREAD;
        } else if (exc instanceof UnsupportedOperationException) {
            i5 = EX_UNSUPPORTED_OPERATION;
        } else {
            i5 = 0;
        }
        writeInt(i5);
        if (i5 == 0) {
            if (exc instanceof RuntimeException) {
                throw ((RuntimeException) exc);
            }
            throw new RuntimeException(exc);
        }
        writeString(exc.getMessage());
        if (i5 == EX_PARCELABLE) {
            writeParcelable((Parcelable) exc);
        }
    }

    public abstract void writeFloat(float f4);

    public void writeFloat(float f4, int i3) {
        setOutputField(i3);
        writeFloat(f4);
    }

    public void writeFloatArray(float[] fArr, int i3) {
        setOutputField(i3);
        writeFloatArray(fArr);
    }

    public abstract void writeInt(int i3);

    public void writeInt(int i3, int i5) {
        setOutputField(i5);
        writeInt(i3);
    }

    public void writeIntArray(int[] iArr, int i3) {
        setOutputField(i3);
        writeIntArray(iArr);
    }

    public <T> void writeList(List<T> list, int i3) {
        writeCollection(list, i3);
    }

    public abstract void writeLong(long j2);

    public void writeLong(long j2, int i3) {
        setOutputField(i3);
        writeLong(j2);
    }

    public void writeLongArray(long[] jArr, int i3) {
        setOutputField(i3);
        writeLongArray(jArr);
    }

    public <K, V> void writeMap(Map<K, V> map, int i3) {
        setOutputField(i3);
        if (map == null) {
            writeInt(-1);
            return;
        }
        int size = map.size();
        writeInt(size);
        if (size == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        writeCollection(arrayList);
        writeCollection(arrayList2);
    }

    public void writeNoException() {
        writeInt(0);
    }

    public abstract void writeParcelable(Parcelable parcelable);

    public void writeParcelable(Parcelable parcelable, int i3) {
        setOutputField(i3);
        writeParcelable(parcelable);
    }

    public void writeSerializable(Serializable serializable, int i3) {
        setOutputField(i3);
        writeSerializable(serializable);
    }

    public <T> void writeSet(Set<T> set, int i3) {
        writeCollection(set, i3);
    }

    @RequiresApi(api = 21)
    public void writeSize(Size size, int i3) {
        boolean z3;
        setOutputField(i3);
        if (size != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        writeBoolean(z3);
        if (size != null) {
            writeInt(size.getWidth());
            writeInt(size.getHeight());
        }
    }

    @RequiresApi(api = 21)
    public void writeSizeF(SizeF sizeF, int i3) {
        boolean z3;
        setOutputField(i3);
        if (sizeF != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        writeBoolean(z3);
        if (sizeF != null) {
            writeFloat(sizeF.getWidth());
            writeFloat(sizeF.getHeight());
        }
    }

    public void writeSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i3) {
        setOutputField(i3);
        if (sparseBooleanArray == null) {
            writeInt(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            writeInt(sparseBooleanArray.keyAt(i5));
            writeBoolean(sparseBooleanArray.valueAt(i5));
        }
    }

    public abstract void writeString(String str);

    public void writeString(String str, int i3) {
        setOutputField(i3);
        writeString(str);
    }

    public abstract void writeStrongBinder(IBinder iBinder);

    public void writeStrongBinder(IBinder iBinder, int i3) {
        setOutputField(i3);
        writeStrongBinder(iBinder);
    }

    public abstract void writeStrongInterface(IInterface iInterface);

    public void writeStrongInterface(IInterface iInterface, int i3) {
        setOutputField(i3);
        writeStrongInterface(iInterface);
    }

    public <T extends VersionedParcelable> void writeToParcel(T t4, VersionedParcel versionedParcel) {
        try {
            getWriteMethod(t4.getClass()).invoke(null, t4, versionedParcel);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e7);
        } catch (InvocationTargetException e8) {
            if (e8.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e8.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e8);
        }
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable, int i3) {
        setOutputField(i3);
        writeVersionedParcelable(versionedParcelable);
    }

    private <T> void writeCollection(Collection<T> collection) {
        if (collection == null) {
            writeInt(-1);
            return;
        }
        int size = collection.size();
        writeInt(size);
        if (size > 0) {
            int type = getType(collection.iterator().next());
            writeInt(type);
            switch (type) {
                case 1:
                    for (T t4 : collection) {
                        writeVersionedParcelable(t4);
                    }
                    return;
                case 2:
                    for (T t5 : collection) {
                        writeParcelable(t5);
                    }
                    return;
                case 3:
                    for (T t6 : collection) {
                        writeSerializable(t6);
                    }
                    return;
                case 4:
                    for (T t7 : collection) {
                        writeString(t7);
                    }
                    return;
                case 5:
                    for (T t8 : collection) {
                        writeStrongBinder(t8);
                    }
                    return;
                case 6:
                default:
                    return;
                case 7:
                    for (T t9 : collection) {
                        writeInt(t9.intValue());
                    }
                    return;
                case 8:
                    for (T t10 : collection) {
                        writeFloat(t10.floatValue());
                    }
                    return;
            }
        }
    }

    private void writeSerializable(Serializable serializable) {
        if (serializable == null) {
            writeString(null);
            return;
        }
        String name = serializable.getClass().getName();
        writeString(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            writeByteArray(byteArrayOutputStream.toByteArray());
        } catch (IOException e5) {
            throw new RuntimeException(i.i("VersionedParcelable encountered IOException writing serializable object (name = ", name, ")"), e5);
        }
    }

    public <T> T[] readArray(T[] tArr) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readInt);
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    arrayList.add(readVersionedParcelable());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    arrayList.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    arrayList.add(readSerializable());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    arrayList.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    arrayList.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return (T[]) arrayList.toArray(tArr);
    }

    public boolean[] readBooleanArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        boolean[] zArr = new boolean[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            zArr[i3] = readInt() != 0;
        }
        return zArr;
    }

    public double[] readDoubleArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        double[] dArr = new double[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            dArr[i3] = readDouble();
        }
        return dArr;
    }

    public float[] readFloatArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        float[] fArr = new float[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            fArr[i3] = readFloat();
        }
        return fArr;
    }

    public int[] readIntArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        int[] iArr = new int[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            iArr[i3] = readInt();
        }
        return iArr;
    }

    public long[] readLongArray() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        long[] jArr = new long[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            jArr[i3] = readLong();
        }
        return jArr;
    }

    public <T extends VersionedParcelable> T readVersionedParcelable() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        return (T) readFromParcel(readString, createSubParcel());
    }

    public <T> void writeArray(T[] tArr) {
        if (tArr == null) {
            writeInt(-1);
            return;
        }
        int length = tArr.length;
        writeInt(length);
        if (length > 0) {
            int i3 = 0;
            int type = getType(tArr[0]);
            writeInt(type);
            if (type == 1) {
                while (i3 < length) {
                    writeVersionedParcelable((VersionedParcelable) tArr[i3]);
                    i3++;
                }
            } else if (type == 2) {
                while (i3 < length) {
                    writeParcelable((Parcelable) tArr[i3]);
                    i3++;
                }
            } else if (type == 3) {
                while (i3 < length) {
                    writeSerializable((Serializable) tArr[i3]);
                    i3++;
                }
            } else if (type == 4) {
                while (i3 < length) {
                    writeString((String) tArr[i3]);
                    i3++;
                }
            } else if (type != 5) {
            } else {
                while (i3 < length) {
                    writeStrongBinder((IBinder) tArr[i3]);
                    i3++;
                }
            }
        }
    }

    public void writeBooleanArray(boolean[] zArr) {
        if (zArr != null) {
            writeInt(zArr.length);
            for (boolean z3 : zArr) {
                writeInt(z3 ? 1 : 0);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeByteArray(byte[] bArr, int i3, int i5, int i6) {
        setOutputField(i6);
        writeByteArray(bArr, i3, i5);
    }

    public void writeDoubleArray(double[] dArr) {
        if (dArr != null) {
            writeInt(dArr.length);
            for (double d : dArr) {
                writeDouble(d);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeFloatArray(float[] fArr) {
        if (fArr != null) {
            writeInt(fArr.length);
            for (float f4 : fArr) {
                writeFloat(f4);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeIntArray(int[] iArr) {
        if (iArr != null) {
            writeInt(iArr.length);
            for (int i3 : iArr) {
                writeInt(i3);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeLongArray(long[] jArr) {
        if (jArr != null) {
            writeInt(jArr.length);
            for (long j2 : jArr) {
                writeLong(j2);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            writeString(null);
            return;
        }
        writeVersionedParcelableCreator(versionedParcelable);
        VersionedParcel createSubParcel = createSubParcel();
        writeToParcel(versionedParcelable, createSubParcel);
        createSubParcel.closeField();
    }

    private Exception readException(int i3, String str) {
        return createException(i3, str);
    }
}
