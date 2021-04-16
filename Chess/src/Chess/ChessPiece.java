package Chess;

abstract class ChessPiece {
    protected String color;
    protected int x;
    protected int y;

    ChessPiece(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    };
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public abstract boolean move(int x, int y);

    public abstract String toString();

}
