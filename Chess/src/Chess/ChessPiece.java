package Chess;

abstract class ChessPiece {
    protected String color;

    ChessPiece(String color){
        if(color.equals("Black") || color.equals("White"))
            this.color = color;
        else
            throw new IllegalArgumentException(color);
    }

    public String getColor(){
        return color;
    };

    public abstract String toString();

    public abstract boolean canMove(int x1, int y1, int x2, int y2, ChessPiece enemyPiece);
}
