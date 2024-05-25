package info.constant;

import java.nio.ByteBuffer;

public class ConstantMethodType implements Constant{
    private final byte tag = (byte) 0x0f;
    byte[] descriptorIndex;

    public ConstantMethodType(byte[] descriptorIndex){
        this.descriptorIndex = descriptorIndex;
    }

    @Override
    public byte getTag() {
        return tag;
    }

    @Override
    public int getBytesLength() {
        return 3;
    }

    @Override
    public byte[] getBytes() {
        return ByteBuffer.allocate(getBytesLength()).put(tag).put(descriptorIndex).array();
    }
}
