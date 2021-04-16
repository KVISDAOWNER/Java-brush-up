package Chess;

public class Rook extends ChessPiece{
    Rook(String color) {
        super(color);
    }

    @Override
    public String toString() {
        if(color=="White")
            return "\u001B[37mRook\u001B[0m";
        else if(color=="Black")
            return "\u001B[30mRook\u001B[0m";
        else
            return "N/A";
    }

    @Override
    public boolean canMove(int x1, int y1, int x2, int y2, ChessPiece enemyPiece) {
        return false;
    }
}
