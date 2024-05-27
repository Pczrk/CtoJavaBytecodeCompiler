package info;

import java.nio.ByteBuffer;

public class Method implements Info{
    byte[] accessFlags; // 2 bytes
    byte[] nameIndex; // 2 bytes
    byte[] descriptorIndex; // 2 bytes
    public AttributeInfo attributeInfo;
    public CodeAttribute codeAttribute; // THIS IS HELPER FIELD ITS GETS WRITTEN BY AttributeInfo

    public Method(byte[] accessFlags, byte[] nameIndex, byte[] descriptorIndex, AttributeInfo attributeInfo){
        this.accessFlags = accessFlags;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributeInfo = attributeInfo;
    }
    public void addAttribute(byte[] attributeName) {
        attributeInfo.addAttribute(attributeName);
    }
    public void addCodeAttribute(byte[] attributeName) {
        codeAttribute = attributeInfo.addCodeAttribute(attributeName);
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
