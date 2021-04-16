package Chess;

public class Queen extends ChessPiece{
    Queen(String color) {
        super(color);
    }

    @Override
    public boolean move(int x, int y) {
        return false;
    }

    @Override
    public String toString() {
        if(color=="White")
            return "\u001B[37mQueen\u001B[0m";
        else if(color=="Black")
            return "\u001B[30mQueen\u001B[0m";
        else
            return "N/A";
    }
}
