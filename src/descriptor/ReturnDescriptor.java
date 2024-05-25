package descriptor;

public class ReturnDescriptor extends FieldDescriptor{
    public ReturnDescriptor addVoid() throws Exception {
        if (finished)
            throw new Exception("");
        description = "V";
        finished = true;
        return this;
    }
}
