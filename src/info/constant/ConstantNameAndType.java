package info.constant;

import java.nio.ByteBuffer;

public class ConstantNameAndType implements Constant{
    private final byte tag = (byte) 0x0c;
    byte[] nameIndex;
    byte[] descriptorIndex;

    public ConstantNameAndType(byte[] nameIndex, byte[] descriptorIndex){
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
    }


    @Override
    public byte getTag() {
        return tag;
    }

    @Override
    public int getBytesLength() {
        return 5;
    }

    @Override
    public byte[] getBytes() {
        return ByteBuffer.allocate(getBytesLength()).put(tag).put(nameIndex).put(descriptorIndex).array();
    }
}
