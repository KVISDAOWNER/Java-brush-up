package Chess;

public class Pawn extends ChessPiece{
    Pawn(String color) {
        super(color);
    }

    @Override
    public String toString() {
        if(color.equals("White"))
            return "\u001B[37mPawn\u001B[0m";
        else if(color.equals("Black"))
            return "\u001B[30mPawn\u001B[0m";
        return "N/A";
    }

    @Override
    public boolean canMove(int x1, int y1, int x2, int y2, ChessPiece enemyPiece) {
        if(color.equals("White")){
            if(x1-x2 == -1 && y1 == y2)
                return true;
            else if (x1 == 1 && x2 == 3) {//first move
                return true;
            }
            else if (x1-x2 == -1 && Math.abs(y1-y2) == 1 && enemyPiece != null)
                return true;
        }
        else if(color.equals("Black")){
            if(x1-x2 == 1 && y1 == y2)
                return true;
            else if (x1 == 6 && x2 == 4) {//first move
                return true;
            }
            else if (x1-x2 == 1 && Math.abs(y1-y2) == 1 && enemyPiece != null)
                return true;
        }
        return false; //Default return false
    }
}
