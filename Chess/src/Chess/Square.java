package Chess;

public class Square {
    private ChessPiece piece;

    public Square(){
        this(null);
    }
    public Square(ChessPiece piece){
        this.piece = piece;
    }

    public ChessPiece getPiece() {
        return piece;
    }

    public void setPiece(ChessPiece piece) {
        this.piece = piece;
    }

    public void removePiece(){
        this.piece = null;
    }
}
