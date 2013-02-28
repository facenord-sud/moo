package shapes;

public abstract class AShape implements Shape {

    private int id;
    
    public AShape() {
    }
    
    public int getID() {
        return id;
    }
    
    public void setID(int newid) {
        id = newid;
    }
}
