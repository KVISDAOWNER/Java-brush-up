package Chess;

public class King extends ChessPiece{
    King(String color) {
        super(color);
    }

    @Override
    public String toString() {
        if(color=="White")
            return "\u001B[37mKing\u001B[0m";
        else if(color=="Black")
            return "\u001B[30mKing\u001B[0m";
        else
            return "N/A";
    }

    @Override
    public boolean canMove(int x1, int y1, int x2, int y2, ChessPiece enemyPiece) {
        return false;
    }
}
