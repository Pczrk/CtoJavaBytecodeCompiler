package info;

import info.constant.*;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstantPoolInfo implements Info {
    private final List<Constant> constantList = new ArrayList<>();
    int bytesLength = 2; // length of info.constant pool
    private final Map<String, byte[]> utf8Constants = new HashMap<>();

    public byte[] addOrGetUtf8Constant(String text){
        if (utf8Constants.containsKey(text))
            return utf8Constants.get(text);

        Constant constant = new ConstantUtf8(text);
        constantList.add(constant);
        var index = ByteBuffer.allocate(2).putShort((short)constantList.size()).array();
        utf8Constants.put(text,index);
        bytesLength += constant.getBytesLength();
        return index;
    }

    public byte[] addIntegerConstant(int value){
        Constant constant = new ConstantInteger(value);
        constantList.add(constant);
        bytesLength += constant.getBytesLength();
        return ByteBuffer.allocate(2).putShort((short)constantList.size()).array();
    }

    public byte[] addFloatConstant(float value){
        Constant constant = new ConstantFloat(value);
        constantList.add(constant);
        bytesLength += constant.getBytesLength();
        return ByteBuffer.allocate(2).putShort((short)constantList.size()).array();
    }

    public byte[] addClassConstant(byte[] index){
        Constant constant = new ConstantClass(index);
        constantList.add(constant);
        bytesLength += constant.getBytesLength();
        return ByteBuffer.allocate(2).putShort((short)constantList.size()).array();
    }

    public byte[] addStringConstant(byte[] index){
        Constant constant = new ConstantString(index);
        constantList.add(constant);
        bytesLength += constant.getBytesLength();
        return ByteBuffer.allocate(2).putShort((short)constantList.size()).array();
    }

    public byte[] addFieldReferenceConstant(byte[] classIndex, byte[] nameAndTypeIndex){
        Constant constant = new ConstantFieldReference(classIndex,nameAndTypeIndex);
        constantList.add(constant);
        bytesLength += constant.getBytesLength();
        return ByteBuffer.allocate(2).putShort((short)constantList.size()).array();
    }

    public byte[] addMethodReferenceConstant(byte[] classIndex, byte[] nameAndTypeIndex){
        Constant constant = new ConstantMethodReference(classIndex,nameAndTypeIndex);
        constantList.add(constant);
        bytesLength += constant.getBytesLength();
        return ByteBuffer.allocate(2).putShort((short)constantList.size()).array();
    }

    public byte[] addNameAndTypeConstant(byte[] nameIndex, byte[] descriptorIndex){
        Constant constant = new ConstantNameAndType(nameIndex,descriptorIndex);
        constantList.add(constant);
        bytesLength += constant.getBytesLength();
        return ByteBuffer.allocate(2).putShort((short)constantList.size()).array();
    }

    public byte[] addMethodTypeConstant(byte[] descriptorIndex){
        Constant constant = new ConstantMethodType(descriptorIndex);
        constantList.add(constant);
        bytesLength += constant.getBytesLength();
        return ByteBuffer.allocate(2).putShort((short)constantList.size()).array();
    }

    @Override
    public int getBytesLength() {
        return bytesLength;
    }

    @Override
    public byte[] getBytes(){
        ByteBuffer buffer = ByteBuffer.allocate(bytesLength);
        buffer.putShort((short)(constantList.size() + 1));
        for (var constant : constantList) {
            buffer.put(constant.getBytes());
        }
        return buffer.array();
    }
}
