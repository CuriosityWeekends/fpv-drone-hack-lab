package androidx.versionedparcelable;

import a1.i;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.versionedparcelable.VersionedParcel;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class VersionedParcelStream extends VersionedParcel {
    private static final int TYPE_BOOLEAN = 5;
    private static final int TYPE_BOOLEAN_ARRAY = 6;
    private static final int TYPE_DOUBLE = 7;
    private static final int TYPE_DOUBLE_ARRAY = 8;
    private static final int TYPE_FLOAT = 13;
    private static final int TYPE_FLOAT_ARRAY = 14;
    private static final int TYPE_INT = 9;
    private static final int TYPE_INT_ARRAY = 10;
    private static final int TYPE_LONG = 11;
    private static final int TYPE_LONG_ARRAY = 12;
    private static final int TYPE_NULL = 0;
    private static final int TYPE_STRING = 3;
    private static final int TYPE_STRING_ARRAY = 4;
    private static final int TYPE_SUB_BUNDLE = 1;
    private static final int TYPE_SUB_PERSISTABLE_BUNDLE = 2;
    private static final Charset UTF_16 = Charset.forName("UTF-16");
    int mCount;
    private DataInputStream mCurrentInput;
    private DataOutputStream mCurrentOutput;
    private FieldBuffer mFieldBuffer;
    private int mFieldId;
    int mFieldSize;
    private boolean mIgnoreParcelables;
    private final DataInputStream mMasterInput;
    private final DataOutputStream mMasterOutput;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class FieldBuffer {
        final DataOutputStream mDataStream;
        private final int mFieldId;
        final ByteArrayOutputStream mOutput;
        private final DataOutputStream mTarget;

        public FieldBuffer(int i3, DataOutputStream dataOutputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.mOutput = byteArrayOutputStream;
            this.mDataStream = new DataOutputStream(byteArrayOutputStream);
            this.mFieldId = i3;
            this.mTarget = dataOutputStream;
        }

        public void flushField() {
            int i3;
            this.mDataStream.flush();
            int size = this.mOutput.size();
            int i5 = this.mFieldId << 16;
            if (size >= 65535) {
                i3 = 65535;
            } else {
                i3 = size;
            }
            this.mTarget.writeInt(i5 | i3);
            if (size >= 65535) {
                this.mTarget.writeInt(size);
            }
            this.mOutput.writeTo(this.mTarget);
        }
    }

    public VersionedParcelStream(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    private void readObject(int i3, String str, Bundle bundle) {
        switch (i3) {
            case 0:
                bundle.putParcelable(str, null);
                return;
            case 1:
                bundle.putBundle(str, readBundle());
                return;
            case 2:
                bundle.putBundle(str, readBundle());
                return;
            case 3:
                bundle.putString(str, readString());
                return;
            case 4:
                bundle.putStringArray(str, (String[]) readArray(new String[0]));
                return;
            case 5:
                bundle.putBoolean(str, readBoolean());
                return;
            case 6:
                bundle.putBooleanArray(str, readBooleanArray());
                return;
            case 7:
                bundle.putDouble(str, readDouble());
                return;
            case 8:
                bundle.putDoubleArray(str, readDoubleArray());
                return;
            case 9:
                bundle.putInt(str, readInt());
                return;
            case 10:
                bundle.putIntArray(str, readIntArray());
                return;
            case 11:
                bundle.putLong(str, readLong());
                return;
            case 12:
                bundle.putLongArray(str, readLongArray());
                return;
            case 13:
                bundle.putFloat(str, readFloat());
                return;
            case 14:
                bundle.putFloatArray(str, readFloatArray());
                return;
            default:
                throw new RuntimeException(i.e(i3, "Unknown type "));
        }
    }

    private void writeObject(Object obj) {
        if (obj == null) {
            writeInt(0);
        } else if (obj instanceof Bundle) {
            writeInt(1);
            writeBundle((Bundle) obj);
        } else if (obj instanceof String) {
            writeInt(3);
            writeString((String) obj);
        } else if (obj instanceof String[]) {
            writeInt(4);
            writeArray((String[]) obj);
        } else if (obj instanceof Boolean) {
            writeInt(5);
            writeBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof boolean[]) {
            writeInt(6);
            writeBooleanArray((boolean[]) obj);
        } else if (obj instanceof Double) {
            writeInt(7);
            writeDouble(((Double) obj).doubleValue());
        } else if (obj instanceof double[]) {
            writeInt(8);
            writeDoubleArray((double[]) obj);
        } else if (obj instanceof Integer) {
            writeInt(9);
            writeInt(((Integer) obj).intValue());
        } else if (obj instanceof int[]) {
            writeInt(10);
            writeIntArray((int[]) obj);
        } else if (obj instanceof Long) {
            writeInt(11);
            writeLong(((Long) obj).longValue());
        } else if (obj instanceof long[]) {
            writeInt(12);
            writeLongArray((long[]) obj);
        } else if (obj instanceof Float) {
            writeInt(13);
            writeFloat(((Float) obj).floatValue());
        } else if (obj instanceof float[]) {
            writeInt(14);
            writeFloatArray((float[]) obj);
        } else {
            throw new IllegalArgumentException("Unsupported type " + obj.getClass());
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        FieldBuffer fieldBuffer = this.mFieldBuffer;
        if (fieldBuffer != null) {
            try {
                if (fieldBuffer.mOutput.size() != 0) {
                    this.mFieldBuffer.flushField();
                }
                this.mFieldBuffer = null;
            } catch (IOException e5) {
                throw new VersionedParcel.ParcelException(e5);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel createSubParcel() {
        return new VersionedParcelStream(this.mCurrentInput, this.mCurrentOutput, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean isStream() {
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        try {
            return this.mCurrentInput.readBoolean();
        } catch (IOException e5) {
            throw new VersionedParcel.ParcelException(e5);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (int i3 = 0; i3 < readInt; i3++) {
            readObject(readInt(), readString(), bundle);
        }
        return bundle;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        try {
            int readInt = this.mCurrentInput.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                this.mCurrentInput.readFully(bArr);
                return bArr;
            }
            return null;
        } catch (IOException e5) {
            throw new VersionedParcel.ParcelException(e5);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public CharSequence readCharSequence() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        try {
            return this.mCurrentInput.readDouble();
        } catch (IOException e5) {
            throw new VersionedParcel.ParcelException(e5);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int i3) {
        while (true) {
            try {
                int i5 = this.mFieldId;
                if (i5 == i3) {
                    return true;
                }
                if (String.valueOf(i5).compareTo(String.valueOf(i3)) > 0) {
                    return false;
                }
                int i6 = this.mCount;
                int i7 = this.mFieldSize;
                if (i6 < i7) {
                    this.mMasterInput.skip(i7 - i6);
                }
                this.mFieldSize = -1;
                int readInt = this.mMasterInput.readInt();
                this.mCount = 0;
                int i8 = readInt & 65535;
                if (i8 == 65535) {
                    i8 = this.mMasterInput.readInt();
                }
                this.mFieldId = (readInt >> 16) & 65535;
                this.mFieldSize = i8;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        try {
            return this.mCurrentInput.readFloat();
        } catch (IOException e5) {
            throw new VersionedParcel.ParcelException(e5);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        try {
            return this.mCurrentInput.readInt();
        } catch (IOException e5) {
            throw new VersionedParcel.ParcelException(e5);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        try {
            return this.mCurrentInput.readLong();
        } catch (IOException e5) {
            throw new VersionedParcel.ParcelException(e5);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        try {
            int readInt = this.mCurrentInput.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                this.mCurrentInput.readFully(bArr);
                return new String(bArr, UTF_16);
            }
            return null;
        } catch (IOException e5) {
            throw new VersionedParcel.ParcelException(e5);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int i3) {
        closeField();
        FieldBuffer fieldBuffer = new FieldBuffer(i3, this.mMasterOutput);
        this.mFieldBuffer = fieldBuffer;
        this.mCurrentOutput = fieldBuffer.mDataStream;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setSerializationFlags(boolean z3, boolean z5) {
        if (z3) {
            this.mIgnoreParcelables = z5;
            return;
        }
        throw new RuntimeException("Serialization of this object is not allowed");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean z3) {
        try {
            this.mCurrentOutput.writeBoolean(z3);
        } catch (IOException e5) {
            throw new VersionedParcel.ParcelException(e5);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle bundle) {
        try {
            if (bundle != null) {
                Set<String> keySet = bundle.keySet();
                this.mCurrentOutput.writeInt(keySet.size());
                for (String str : keySet) {
                    writeString(str);
                    writeObject(bundle.get(str));
                }
                return;
            }
            this.mCurrentOutput.writeInt(-1);
        } catch (IOException e5) {
            throw new VersionedParcel.ParcelException(e5);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr) {
        try {
            if (bArr != null) {
                this.mCurrentOutput.writeInt(bArr.length);
                this.mCurrentOutput.write(bArr);
                return;
            }
            this.mCurrentOutput.writeInt(-1);
        } catch (IOException e5) {
            throw new VersionedParcel.ParcelException(e5);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeCharSequence(CharSequence charSequence) {
        if (this.mIgnoreParcelables) {
            return;
        }
        throw new RuntimeException("CharSequence cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double d) {
        try {
            this.mCurrentOutput.writeDouble(d);
        } catch (IOException e5) {
            throw new VersionedParcel.ParcelException(e5);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float f4) {
        try {
            this.mCurrentOutput.writeFloat(f4);
        } catch (IOException e5) {
            throw new VersionedParcel.ParcelException(e5);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int i3) {
        try {
            this.mCurrentOutput.writeInt(i3);
        } catch (IOException e5) {
            throw new VersionedParcel.ParcelException(e5);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long j2) {
        try {
            this.mCurrentOutput.writeLong(j2);
        } catch (IOException e5) {
            throw new VersionedParcel.ParcelException(e5);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable parcelable) {
        if (this.mIgnoreParcelables) {
            return;
        }
        throw new RuntimeException("Parcelables cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String str) {
        try {
            if (str != null) {
                byte[] bytes = str.getBytes(UTF_16);
                this.mCurrentOutput.writeInt(bytes.length);
                this.mCurrentOutput.write(bytes);
                return;
            }
            this.mCurrentOutput.writeInt(-1);
        } catch (IOException e5) {
            throw new VersionedParcel.ParcelException(e5);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder iBinder) {
        if (this.mIgnoreParcelables) {
            return;
        }
        throw new RuntimeException("Binders cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface iInterface) {
        if (this.mIgnoreParcelables) {
            return;
        }
        throw new RuntimeException("Binders cannot be written to an OutputStream");
    }

    private VersionedParcelStream(InputStream inputStream, OutputStream outputStream, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        this.mCount = 0;
        this.mFieldId = -1;
        this.mFieldSize = -1;
        DataInputStream dataInputStream = inputStream != null ? new DataInputStream(new FilterInputStream(inputStream) { // from class: androidx.versionedparcelable.VersionedParcelStream.1
            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i3 = versionedParcelStream.mFieldSize;
                if (i3 != -1 && versionedParcelStream.mCount >= i3) {
                    throw new IOException();
                }
                int read = super.read();
                VersionedParcelStream.this.mCount++;
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j2) {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i3 = versionedParcelStream.mFieldSize;
                if (i3 != -1 && versionedParcelStream.mCount >= i3) {
                    throw new IOException();
                }
                long skip = super.skip(j2);
                if (skip > 0) {
                    VersionedParcelStream.this.mCount += (int) skip;
                }
                return skip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i3, int i5) {
                VersionedParcelStream versionedParcelStream = VersionedParcelStream.this;
                int i6 = versionedParcelStream.mFieldSize;
                if (i6 != -1 && versionedParcelStream.mCount >= i6) {
                    throw new IOException();
                }
                int read = super.read(bArr, i3, i5);
                if (read > 0) {
                    VersionedParcelStream.this.mCount += read;
                }
                return read;
            }
        }) : null;
        this.mMasterInput = dataInputStream;
        DataOutputStream dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : null;
        this.mMasterOutput = dataOutputStream;
        this.mCurrentInput = dataInputStream;
        this.mCurrentOutput = dataOutputStream;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr, int i3, int i5) {
        try {
            if (bArr != null) {
                this.mCurrentOutput.writeInt(i5);
                this.mCurrentOutput.write(bArr, i3, i5);
                return;
            }
            this.mCurrentOutput.writeInt(-1);
        } catch (IOException e5) {
            throw new VersionedParcel.ParcelException(e5);
        }
    }
}
