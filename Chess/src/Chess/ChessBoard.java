package Chess;


/*
    7    W  B  W  B  W  B  W  B
    6    B  W  B  W  B  W  B  W
    5    W  B  W  B  W  B  W  B
    4    B  W  B  W  B  W  B  W
    3    W  B  W  B  W  B  W  B
    2    B  W  B  W  B  W  B  W
    1    W  B  W  B  W  B  W  B
    0    B  W  B  W  B  W  B  W

         0  1  2  3  4  5  6  7
 */

public class ChessBoard {
    private final int width = 8;
    private final int height = 8;
    
    private ChessPiece[][] board = new ChessPiece[width][height];

    public ChessBoard(){
        Setup();
    }

    private void Setup(){
        //First row
        board[0]=CreateBackRow("White");
        board[1]=CreateFrontRow("White");
        board[6]=CreateFrontRow("Black");
        board[7]=CreateBackRow("Black");
    }

    private ChessPiece[] CreateFrontRow(String color){
        ChessPiece[] row = new ChessPiece[width];
        for (int i = 0; i < width; i++){
            row[i] = new Pawn(color);
        }
        return row;
    }
    
    private ChessPiece[] CreateBackRow(String color){
        ChessPiece[] row = new ChessPiece[width];
        row[0] = new Rook(color);
        row[1]= new Knight(color);
        row[2] = new Bishop(color);
        row[3] = new Queen(color);
        row[4] = new King(color);
        row[5] = new Bishop(color);
        row[6] = new Knight(color);
        row[7] = new Rook(color);
        return row;
    }

    public void PrintBoard(){
        for (var row: board) {
            for (var square: row) {
                if(square != null)
                    System.out.printf(square.toString() + "\t");
            }
            System.out.printf("\n");
        }
    }

}
