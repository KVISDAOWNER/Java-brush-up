package Chess;

public class Bishop extends ChessPiece{
    Bishop(String color) {
        super(color);
    }

    @Override
    public String toString() {
        if(color=="White")
            return "\u001B[37mBishop\u001B[0m";
        else if(color=="Black")
            return "\u001B[30mBishop\u001B[0m";
        else
            return "N/A";
    }

    @Override
    //Bishop moves diagonally
    public boolean canMove(int x1, int y1, int x2, int y2, ChessPiece enemyPiece) {
        return true;
    }


}
