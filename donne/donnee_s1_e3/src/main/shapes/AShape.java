package shapes;

public abstract class AShape implements Shape {

    private int id;
    
    public AShape() {
    }
    
    @Override
    public int getID() {
        return id;
    }
    
    @Override
    public void setID(int newid) {
        id = newid;
    }
}
