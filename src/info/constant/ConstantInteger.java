package info.constant;

import java.nio.ByteBuffer;

public class ConstantInteger implements Constant{
    private final byte tag = (byte) 0x03; // 1 byte
    byte[] bytes; // 4 bytes

    public ConstantInteger(int value){
        bytes = ByteBuffer.allocate(4).putInt(value).array();
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
        return ByteBuffer.allocate(getBytesLength()).put(tag).put(bytes).array();
    }
}
