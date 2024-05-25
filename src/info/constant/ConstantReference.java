package info.constant;

import java.nio.ByteBuffer;

abstract class ConstantReference implements Constant{
    byte[] classIndex;
    byte[] nameAndTypeIndex;
    ConstantReference(byte[] classIndex, byte[] nameAndTypeIndex){
        this.classIndex = classIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
    @Override
    abstract public byte getTag();

    @Override
    public int getBytesLength() {
        return 5;
    }

    @Override
    public byte[] getBytes() {
        return ByteBuffer.allocate(getBytesLength()).put(getTag()).put(classIndex).put(nameAndTypeIndex).array();
    }
}
