package Chess;

public class Knight extends ChessPiece{
    Knight(String color) {
        super(color);
    }

    @Override
    public boolean move(int x, int y) {
        return false;
    }

    @Override
    public String toString() {
        if(color=="White")
            return "\u001B[37mKnight\u001B[0m";
        else if(color=="Black")
            return "\u001B[30mKnight\u001B[0m";
        else
            return "N/A";
    }
}
