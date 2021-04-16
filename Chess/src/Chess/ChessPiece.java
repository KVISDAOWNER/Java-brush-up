package Chess;

abstract class ChessPiece {
    protected String color;

    ChessPiece(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    };

    public abstract String toString();

    public abstract boolean canMove(int x1, int y1, int x2, int y2, ChessPiece enemyPiece);
}
