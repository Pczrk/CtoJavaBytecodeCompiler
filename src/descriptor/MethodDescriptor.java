package descriptor;

public class MethodDescriptor {
    private final FieldDescriptor parameterDescriptor = new FieldDescriptor();
    private final ReturnDescriptor returnTypeDescriptor = new ReturnDescriptor();
    public FieldDescriptor getParamDescriptor(){
        return parameterDescriptor;
    }
    public ReturnDescriptor getReturnDesc(){
        return returnTypeDescriptor;
    }
    public String build() throws Exception {
        return "(" + parameterDescriptor.build() + ")" + returnTypeDescriptor.build();
    }

}
