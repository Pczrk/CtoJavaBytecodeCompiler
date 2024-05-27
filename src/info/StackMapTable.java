package info;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class StackMapTable extends Attribute{

    byte[] numOfEntries = new byte[]{(byte)0x00, (byte)0x00};
    public StackMapTable(byte[] attributeName) {
        super(attributeName);
        //info = new byte[]{(byte)0x00};
    }

    public void add251(short s){
        int l = info.length + 3;
        info = ByteBuffer.allocate(l).put(info).put((byte)0xfb).putShort(s).array();
        numOfEntries = ByteBuffer.allocate(2).putShort((short) ((numOfEntries[0] << 8 | numOfEntries[1]) + 1)).array();
    }

    @Override
    public int getBytesLength() {
        return 8 + info.length;
    }

    @Override
    public byte[] getBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(getBytesLength()).
                put(attributeNameIndex).putInt(getBytesLength()-6).put(numOfEntries).put(info);
        System.out.println(Arrays.toString(buffer.array()));
        return buffer.array();
    }
}
