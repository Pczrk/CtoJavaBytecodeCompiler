package descriptor;

public class FieldDescriptor {
    protected String description = "";
    protected boolean finished = false;
    public FieldDescriptor addChar() throws Exception {
        if (finished)
            throw new Exception("");

        description += "C";
        finished = true;
        return this;
    }

    public FieldDescriptor addFloat() throws Exception {
        if (finished)
            throw new Exception("");
        description += "F";
        finished = true;
        return this;
    }

    public FieldDescriptor addInt() throws Exception {
        if (finished)
            throw new Exception("");
        description += "I";
        finished = true;
        return this;
    }

    public FieldDescriptor addReference(String className) throws Exception {
        if (finished)
            throw new Exception("");
        description += "L" + className + ";";
        finished = true;
        return this;
    }

    public FieldDescriptor addBoolean() throws Exception {
        if (finished)
            throw new Exception("");
        description += "Z";
        finished = true;
        return this;
    }

    public FieldDescriptor addArray() throws Exception {
        if (finished)
            throw new Exception("");
        description += "[";
        return this;
    }

    public String build() throws Exception {
        if (!finished)
            throw new Exception();
        return description;
    }
}
