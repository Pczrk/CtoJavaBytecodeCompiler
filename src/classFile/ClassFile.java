package classFile;
import info.*;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.7
public class ClassFile {
    static ClassFile classFile = null;

    public static ClassFile get(){
        if(classFile == null){
            try{
                classFile = new ClassFile();
            }
            catch(Exception ignored){}
        }
        return classFile;
    }

    // Class file structure
    byte[] magicNumber =  {(byte) 0xca, (byte) 0xfe, (byte) 0xba, (byte) 0xbe};
    byte[] minorVersion = { (byte) 0x00, (byte) 0x00};
    byte[] majorVersion = { (byte) 0x00, (byte) 0x40};
    ConstantPoolInfo constantPoolInfo = new ConstantPoolInfo();
    byte[] accessFlags = {(byte) 0x00, (byte) 0x21}; // ACC_PUBLIC, ACC_SUPER
    byte[] thisClass = new byte[2]; // Class info.constant that points Main
    byte[] superClass = new byte[2]; // Class info.constant that points java/lang/Object
    byte[] interfaceCount = { (byte) 0x00, (byte) 0x00}; // no interface in C file
    FieldInfo fieldInfo = new FieldInfo();
    MethodInfo methodInfo = new MethodInfo();
    AttributeInfo attributeInfo = new AttributeInfo();
    // helper fields
    Map<String,byte[]> methodReferencesIndex = new HashMap<>();
    Map<String,byte[]> fieldReferencesIndex = new HashMap<>();
    Map<String, Method> methods = new HashMap<>();
    public ClassFile() throws Exception {
        createThisAndSuperClass();
        createDefaultConstructor();
        createEntryPoint();
    }

    private void createThisAndSuperClass() {
        byte[] superclassName = constantPoolInfo.addOrGetUtf8Constant("java/lang/Object");
        superClass = constantPoolInfo.addClassConstant(superclassName);
        byte[] thisClassName = constantPoolInfo.addOrGetUtf8Constant("Main");
        thisClass = constantPoolInfo.addClassConstant(thisClassName);
    }

    private void createDefaultConstructor() throws Exception {
        var code = createMethod(new byte[]{(byte) 0x00, (byte) 0x01},"<init>","()V", new String[0]);
        code.makeDefaultConstructor(methodReferencesIndex.get("<init>"));
    }

    private void createEntryPoint(){
        var entryPointNameIndex = constantPoolInfo.addOrGetUtf8Constant("main");
        var argumentsIndex = constantPoolInfo.addOrGetUtf8Constant("([Ljava/lang/String;)V");
        var method = methodInfo.addMethod(new byte[]{(byte) 0x00, (byte) 0x09},entryPointNameIndex,argumentsIndex, new AttributeInfo());
        methods.put("main",method);
        method.addCodeAttribute(constantPoolInfo.addOrGetUtf8Constant("Code"));
        method.codeAttribute.entryPointInit();
    }

    public CodeAttribute createMethod(byte[] accessFlags, String name, String arguments, String[] argumentsNames) throws Exception {
        if (methods.containsKey(name))
            throw new Exception("In C there is no polymorphism, so 2 methods can't have same name");

        byte[] nameIndex = constantPoolInfo.addOrGetUtf8Constant(name);
        byte[] argumentsIndex = constantPoolInfo.addOrGetUtf8Constant(arguments);
        byte[] nameAndTypeIndex = constantPoolInfo.addNameAndTypeConstant(nameIndex,argumentsIndex);
        methodReferencesIndex.put(name,constantPoolInfo.addMethodReferenceConstant(superClass, nameAndTypeIndex));

        var method = methodInfo.addMethod(accessFlags,nameIndex,argumentsIndex,new AttributeInfo());
        methods.put(name,method);

        for (var argName : argumentsNames){
            constantPoolInfo.addOrGetUtf8Constant(argName);
        }

        method.addCodeAttribute(constantPoolInfo.addOrGetUtf8Constant("Code"));
        return method.codeAttribute;
    }

    public CodeAttribute createMethod(String name, String arguments, String[] argumentsNames) throws Exception {
        return createMethod(new byte[]{(byte) 0x00, (byte) 0x08},name,arguments,argumentsNames);
    }

    //it's true for C but for bytecode it's static field
    public void createGlobalVariable(String type, String name) throws Exception {
        if (!methods.containsKey("<clinit>")){
            createMethod(new byte[]{(byte) 0x00, (byte) 0x08},"<clinit>","()V",new String[0]);
        }
        var code = methods.get("<clinit>");
        var utf8NameIndex = constantPoolInfo.addOrGetUtf8Constant(name);
        var utf8TypeIndex = constantPoolInfo.addOrGetUtf8Constant(type);

        var nameAndTypeIndex = constantPoolInfo.addNameAndTypeConstant(utf8NameIndex,utf8TypeIndex);
        var fieldRefIndex = constantPoolInfo.addFieldReferenceConstant(thisClass,nameAndTypeIndex);
        if (fieldReferencesIndex.containsKey(name))
            throw new Exception("Variable with this name already defined"); //TODO lazy error, w C jest shadowing zmiennych, ale to na koncu jesli wogole :D :P :O
        fieldReferencesIndex.put(name, fieldRefIndex);

//        for (var arg : arguments) { TODO TUTAJ INICJOWANIE ZMIENNYCH
//            if (!utf8ConstantIndex.containsKey(arg))
//                utf8ConstantIndex.put(type, constantPoolInfo.addUtf8Constant(type));
//            var utf8ArgumentIndex = utf8ConstantIndex.get(type);
//        }
    }

    public void createGlobalVariableWithInit(String type, String name, String value) throws Exception {
        if (!methods.containsKey("<clinit>")){
            createMethod(new byte[]{(byte) 0x00, (byte) 0x08},"<clinit>","()V",new String[0]);
        }
        var staticConstCode = methods.get("<clinit>");
        var utf8NameIndex = constantPoolInfo.addOrGetUtf8Constant(name);
        var utf8TypeIndex = constantPoolInfo.addOrGetUtf8Constant(type);

        var nameAndTypeIndex = constantPoolInfo.addNameAndTypeConstant(utf8NameIndex,utf8TypeIndex);
        var fieldRefIndex = constantPoolInfo.addFieldReferenceConstant(thisClass,nameAndTypeIndex);
        if (fieldReferencesIndex.containsKey(name))
            throw new Exception("Variable with this name already defined"); //TODO lazy error, w C jest shadowing zmiennych, ale to na koncu jesli wogole :D :P :O
        fieldReferencesIndex.put(name, fieldRefIndex);

        switch (type) {
            case "I" -> {
                var valueIndex = constantPoolInfo.addIntegerConstant(Integer.parseInt(value));
                staticConstCode.codeAttribute.addCode(ByteBuffer.allocate(3).put((byte) 0x12).put(valueIndex).array());
                staticConstCode.codeAttribute.addCode(ByteBuffer.allocate(3).put((byte) 0xb3).put(fieldRefIndex).array());
                staticConstCode.codeAttribute.setStackLocalsSize(1, 0);
            }
            case "F" -> {
                var valueIndex = constantPoolInfo.addFloatConstant(Float.parseFloat(value));
                staticConstCode.codeAttribute.addCode(ByteBuffer.allocate(3).put((byte) 0x12).put(valueIndex).array());
                staticConstCode.codeAttribute.addCode(ByteBuffer.allocate(3).put((byte) 0xb3).put(fieldRefIndex).array());
                staticConstCode.codeAttribute.setStackLocalsSize(1, 0);
            }
            case "B" -> {
                var value2 = value.equals("true") ? (byte) 0x01 : (byte) 0x00;
                staticConstCode.codeAttribute.addCode(ByteBuffer.allocate(2).put((byte) 0x10).put(value2).array());
                staticConstCode.codeAttribute.addCode(ByteBuffer.allocate(3).put((byte) 0xb3).put(fieldRefIndex).array());
                staticConstCode.codeAttribute.setStackLocalsSize(1, 0);
            }
            case "C" -> {
                var value2 = (byte) value.charAt(0);
                staticConstCode.codeAttribute.addCode(ByteBuffer.allocate(2).put((byte) 0x10).put(value2).array());
                staticConstCode.codeAttribute.addCode(ByteBuffer.allocate(3).put((byte) 0xb3).put(fieldRefIndex).array());
                staticConstCode.codeAttribute.setStackLocalsSize(1, 0);
            }
        }
        staticConstCode.codeAttribute.addCode(new byte[]{(byte) 0xb1});

//        for (var arg : arguments) { TODO TUTAJ INICJOWANIE ZMIENNYCH
//            if (!utf8ConstantIndex.containsKey(arg))
//                utf8ConstantIndex.put(type, constantPoolInfo.addUtf8Constant(type));
//            var utf8ArgumentIndex = utf8ConstantIndex.get(type);
//        }
    }

    public void createGlobalArrayWithInit(String type, String name, String[] values) throws Exception {
        if (!methods.containsKey("<clinit>")){
            createMethod(new byte[]{(byte) 0x00, (byte) 0x08},"<clinit>","()V",new String[0]);
        }
        var code = methods.get("<clinit>");
        var utf8NameIndex = constantPoolInfo.addOrGetUtf8Constant(name);
        var utf8TypeIndex = constantPoolInfo.addOrGetUtf8Constant(type);

        var nameAndTypeIndex = constantPoolInfo.addNameAndTypeConstant(utf8NameIndex,utf8TypeIndex);
        var fieldRefIndex = constantPoolInfo.addFieldReferenceConstant(thisClass,nameAndTypeIndex);
        if (fieldReferencesIndex.containsKey(name))
            throw new Exception("Variable with this name already defined"); //TODO lazy error, w C jest shadowing zmiennych, ale to na koncu jesli wogole :D :P :O
        fieldReferencesIndex.put(name, fieldRefIndex);

//        for (var arg : arguments) { TODO TUTAJ INICJOWANIE ZMIENNYCH
//            if (!utf8ConstantIndex.containsKey(arg))
//                utf8ConstantIndex.put(type, constantPoolInfo.addUtf8Constant(type));
//            var utf8ArgumentIndex = utf8ConstantIndex.get(type);
//        }
    }

    //TODO Tutaj jest "krotki" import printa, musisz go gdzies wywolac
    public void addPrint(){
        if (methodReferencesIndex.containsKey("print"))
            return;
        var printStreamClassNameIndex = constantPoolInfo.addOrGetUtf8Constant("java/lang/System");
        var printStreamClassIndex = constantPoolInfo.addClassConstant(printStreamClassNameIndex);
        var printNameIndex = constantPoolInfo.addOrGetUtf8Constant("print");
        var printDescriptorIndex = constantPoolInfo.addOrGetUtf8Constant("(Ljava/lang/String;)V");
        var printNameAndTypeIndex = constantPoolInfo.addNameAndTypeConstant(printNameIndex,printDescriptorIndex);
        var printMethodRef = constantPoolInfo.addMethodReferenceConstant(printStreamClassIndex,printNameAndTypeIndex);
        methodReferencesIndex.put("print",printMethodRef);

        var outNameIndex = constantPoolInfo.addOrGetUtf8Constant("out");
        var outDescriptorIndex = constantPoolInfo.addOrGetUtf8Constant("Ljava/io/PrintStream;");
        var outNameAndType = constantPoolInfo.addNameAndTypeConstant(outNameIndex,outDescriptorIndex);

        var systemClassNameIndex = constantPoolInfo.addOrGetUtf8Constant("java/lang/System");
        var systemClassIndex = constantPoolInfo.addClassConstant(systemClassNameIndex);
        var outFieldRef = constantPoolInfo.addFieldReferenceConstant(systemClassIndex,outNameAndType);
        fieldReferencesIndex.put("print",outFieldRef);
    }

    public int getBytesLength(){
        return 16 + constantPoolInfo.getBytesLength() + fieldInfo.getBytesLength() +
                methodInfo.getBytesLength() + attributeInfo.getBytesLength();
    }

    public byte[] getBytes(){
        var buffer = ByteBuffer.allocate(getBytesLength());
        buffer.put(magicNumber).put(minorVersion).put(majorVersion).put(constantPoolInfo.getBytes())
                .put(accessFlags).put(thisClass).put(superClass).put(interfaceCount).put(fieldInfo.getBytes())
                .put(methodInfo.getBytes()).put(attributeInfo.getBytes());
        return buffer.array();
    }

    public void generateClassFile() throws Exception {
        try (FileOutputStream fos = new FileOutputStream("Main.class");
             DataOutputStream dos = new DataOutputStream(fos)) {
            dos.write(getBytes());
        }
    }
}
