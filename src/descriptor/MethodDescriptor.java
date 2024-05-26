package descriptor;

import java.util.ArrayList;
import java.util.List;
import info.Method2;

public class MethodDescriptor {
    private List<FieldDescriptor> parameterDescriptor = new ArrayList<>();
    private ReturnDescriptor returnTypeDescriptor = new ReturnDescriptor();
    public List<FieldDescriptor> getParamDescriptor(){
        return parameterDescriptor;
    }
    public ReturnDescriptor getReturnDesc(){
        return returnTypeDescriptor;
    }
    public String build() throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for(var fd : parameterDescriptor){
            builder.append(fd.build());
        }
        builder.append(")");
        builder.append(returnTypeDescriptor.build());
        return builder.toString();
    }

    public static MethodDescriptor fromMethod2(Method2 m) throws Exception {
        MethodDescriptor md = new MethodDescriptor();
        md.returnTypeDescriptor = m.returnType.getReturnDescriptor();
        for(var t : m.arguments){
            md.parameterDescriptor.add(t.getDescriptor());
        }
        return md;
    }

}
