import descriptor.FieldDescriptor;
import descriptor.MethodDescriptor;

public class Main {
    public static void main(String[] args) throws Exception {
        var emptyProgram = new ClassFile();
        emptyProgram.methods.get("main").codeAttribute.addEmptyReturn();
        //emptyProgram.generateClassFile(); // mozesz sobie wytestowac ze to dziala i to nizej tez

        var xd = new MethodDescriptor();
        xd.getParamDescriptor().addArray().addArray().addArray().addBoolean();
        xd.getReturnDesc().addArray().addChar();
        System.out.print(xd.build());

        emptyProgram.createGlobalVariable(new FieldDescriptor().addArray().addBoolean().build(),"aha",new String[0]);
        emptyProgram.generateClassFile();
    }
}