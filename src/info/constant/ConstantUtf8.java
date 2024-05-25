package info.constant;

import java.nio.ByteBuffer;

public class ConstantUtf8 implements Constant {
    private final byte tag = (byte) 0x01; // 1 byte
    byte[] length; // 2 bytes
    byte[] bytes;  // length bytes

    public ConstantUtf8(String text){
        bytes = text.getBytes();
        length = ByteBuffer.allocate(2).putShort((short)bytes.length).array();
    }

    @Override
    public byte getTag() {
        return tag;
    }

    @Override
    public int getBytesLength() {
        return 3 + bytes.length;
    }

    @Override
    public byte[] getBytes() {
        return ByteBuffer.allocate(getBytesLength()).put(tag).put(length).put(bytes).array();
    }
}
