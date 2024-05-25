package info;

import java.nio.ByteBuffer;

public class Field implements Info {
    byte[] accessFlags; // 2 bytes
    byte[] nameIndex; // 2 bytes
    byte[] descriptorIndex; // 2 bytes
    AttributeInfo attributeInfo;
    Field(byte[] accessFlags, byte[] nameIndex, byte[] descriptorIndex, AttributeInfo attributeInfo){
        this.accessFlags = accessFlags;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributeInfo = attributeInfo;
    }
    @Override
    public int getBytesLength(){
        return 6 + attributeInfo.getBytesLength();
    }
    @Override
    public byte[] getBytes(){
        ByteBuffer buffer = ByteBuffer.allocate(getBytesLength());
        buffer.put(accessFlags).put(nameIndex).put(descriptorIndex).put(attributeInfo.getBytes());
        return buffer.array();
    }
}
