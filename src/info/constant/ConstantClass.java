package info.constant;

import java.nio.ByteBuffer;

public class ConstantClass implements Constant{
    private final byte tag = (byte) 0x07;
    byte[] nameIndex; // 2 bytes

    public ConstantClass(byte[] nameIndex){
        this.nameIndex = nameIndex;
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
        return ByteBuffer.allocate(getBytesLength()).put(tag).put(nameIndex).array();
    }
}
