package info.constant;

import java.nio.ByteBuffer;

public class ConstantString implements Constant{
    private final byte tag = (byte) 0x08; // 1 byte
    byte[] stringIndex; // 2 bytes

    public ConstantString(byte[] stringIndex){
        this.stringIndex = stringIndex;
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
        return ByteBuffer.allocate(getBytesLength()).put(tag).put(stringIndex).array();
    }
}
