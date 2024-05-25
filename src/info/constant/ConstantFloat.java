package info.constant;

import java.nio.ByteBuffer;

public class ConstantFloat implements Constant{
    private final byte tag = (byte) 0x04;
    byte[] bytes; // 4 bytes

    //TODO CHECK IF THIS WORKS IF NOT HAVE SOME FUN WITH LINK BELOW
    //https://docs.oracle.com/javase/specs/jvms/se17/html/jvms-2.html#jvms-2.3.2
    public ConstantFloat(float value){
        bytes = ByteBuffer.allocate(4).putFloat(value).array();
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
