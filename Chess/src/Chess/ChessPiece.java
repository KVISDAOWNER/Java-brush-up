package Chess;

abstract class ChessPiece {
    protected String color;
    protected int x;
    protected int y;

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

}
