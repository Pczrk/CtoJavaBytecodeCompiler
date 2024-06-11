package info;

import java.nio.ByteBuffer;
import simulation.Stack;
import classFile.ClassFile;

/*
    Code_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 max_stack;
    u2 max_locals;
    u4 code_length;
    u1 code[code_length];
    u2 exception_table_length;
    {   u2 start_pc;
        u2 end_pc;
        u2 handler_pc;
        u2 catch_type;
    } exception_table[exception_table_length];
    u2 attributes_count;
    attribute_info attributes[attributes_count];
    }
 */

public class CodeAttribute extends Attribute {
    //inherited byte[] attributeNameIndex; // 2 bytes
    //useless to make field Attributelength// 4 bytes
    byte[] maxStack = new byte[]{(byte) 0x00, (byte) 0x00}; // 2 bytes
    byte[] maxLocals = new byte[]{(byte) 0x00, (byte) 0x00}; // 2 bytes

    // useless lookup getBytes function byte[] codeLength; // 4 bytes
    byte[] code = new byte[0]; // codeLength bytes

    byte[] exceptionTableLength = new byte[]{(byte) 0x00, (byte) 0x00}; // 2 bytes
    AttributeInfo attributeInfo = new AttributeInfo();

    //StackMapTable stackMapTable;

    public CodeAttribute(byte[] attributeName) {
        super(attributeName);
        //stackMapTable = new StackMapTable(ClassFile.get().constantPoolInfo.addOrGetUtf8Constant("StackMapTable"));
    }

    public void makeDefaultConstructor(byte[] constructorReference) { // 2a b7 0001 b1
        maxStack = new byte[]{(byte) 0x00, (byte) 0x01};
        maxLocals = new byte[]{(byte) 0x00, (byte) 0x01};
        code = ByteBuffer.allocate(5).put((byte) 0x2a).put((byte) 0xb7)
                .put(constructorReference).put((byte) 0xb1).array();
    }

    public void entryPointInit(){
        maxStack = new byte[]{(byte) 0x00, (byte) 0x00};
        maxLocals = new byte[]{(byte) 0x00, (byte) 0x01};
    }

    @Override
    public int getBytesLength() {
        return 16 + code.length + attributeInfo.getBytesLength();
    }

    @Override
    public byte[] getBytes() {
        var bytesLength = getBytesLength();
        ByteBuffer buffer = ByteBuffer.allocate(bytesLength);
        buffer.put(attributeNameIndex).putInt(bytesLength - 6).put(maxStack).put(maxLocals).putInt(code.length)
                .put(code).put(exceptionTableLength).put(attributeInfo.getBytes());
        return buffer.array();
    }

    public void addCode(byte[] newCode){
        var bytesLength = code.length + newCode.length;
        ByteBuffer buffer = ByteBuffer.allocate(bytesLength);
        buffer.put(code).put(newCode);
        code = buffer.array();
    }

    public void setStackLocalsSize(int stack, int locals){
        maxStack = ByteBuffer.allocate(2).putShort((short)stack).array();
        maxLocals = ByteBuffer.allocate(2).putShort((short)locals).array();

    }

    public void fillWithStack(Stack s){
        maxStack = ByteBuffer.allocate(2).putShort((short) s.getStackSize()).array();
        maxLocals = ByteBuffer.allocate(2).putShort((short) s.getLocalsSize()).array();
        addCode(s.getCode());

        if(!s.stackTypes.empty()){
            System.out.println("On the stack the were variables left. Count: ");
            System.out.println(s.stackTypes.size());
            System.out.println(s.stackTypes.peek().t());
            System.out.println(s.stackTypes.peek().array);
        }
        /*for(Short offset : s.stackMapOffsets){
            stackMapTable.add251(offset);
        }*/
    }

    public void appendStack(Stack s){
        maxStack = ByteBuffer.allocate(2).putShort(
                (short) Math.max((short)s.getStackSize(), (short)(maxStack[0]<<8|maxStack[1]))
                ).array();
        maxLocals = ByteBuffer.allocate(2).putShort(
                (short) Math.max((short)s.getLocalsSize(), (short)(maxLocals[0]<<8|maxLocals[1]))
        ).array();

        addCode(s.getCode());

        if(!s.stackTypes.empty()){
            System.out.println("On the stack the were variables left. Count: ");
            System.out.println(s.stackTypes.size());
            System.out.println(s.stackTypes.peek().t());
            System.out.println(s.stackTypes.peek().array);
        }
    }

    public void addEmptyReturn() {
        addCode(ByteBuffer.allocate(code.length + 1).put(code).put((byte) 0xb1).array());
    }

    public void appendEmptyReturn() {
        addCode(ByteBuffer.allocate(1).put((byte) 0xb1).array());
    }

    public void setMainFun() {
        if(ClassFile.get().methodRefs().get("main") == null){
            System.out.println("No main function detected");
        }
        byte[] in = ClassFile.get().methodRefs().get("main").a;
        Type r = ClassFile.get().methodRefs().get("main").b.returnType;
        if(r.ar() || r.t() > 0){
            System.out.println("Main must return void");
        }
        code = ByteBuffer.allocate(4).put((byte)0xb8).put(in).put((byte) 0xb1).array();

    }
}
