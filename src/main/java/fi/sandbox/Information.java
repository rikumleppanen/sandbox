package fi.sandbox;

public class Information implements matchingInterface {

    private String piece;
    private Type type;

    public Information(String piece) {
        this.piece = piece;
        this.type = Type.untyped;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    public Type getType() {
        return this.type;
    }
    public String get() {
        return this.piece;
    }

    @Override
    public String getRow() {
        return this.piece;
    }
}
