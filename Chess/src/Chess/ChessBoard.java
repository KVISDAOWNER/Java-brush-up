package Chess;


/*
    7      W    B    W    B    W    B    W    B     //Black side
    6      B    W    B    W    B    W    B    W
    5      W    B    W    B    W    B    W    B
    4      B    W    B    W    B    W    B    W
    3      W    B    W    B    W    B    W    B
    2     2,0   W    B    W    B    W    B    W
    1     1,0  0,2   W    B    W    B    W    B
    0     0,0  0,1   B    W    B    W    B    W     //White side

           0    1    2    3    4    5    6    7
 */

public class ChessBoard {
    private final int width = 8;
    private final int height = width;

    private Square[][] board = new Square[width][height];

    public ChessBoard(){
        Setup();
    }

    private void Setup(){
        //First row
        board[0]=CreateBackRow("White");
        board[1]=CreateFrontRow("White");
        for(int i = 2; i < 6; i++){
            board[i] = CreateEmptyRow();
        }
        board[6]=CreateFrontRow("Black");
        board[7]=CreateBackRow("Black");
    }

    private Square[] CreateBackRow(String color){
        Square[] row = new Square[width];
        row[0] = new Square(new Rook(color));
        row[1] = new Square(new Knight(color));
        row[2] = new Square(new Bishop(color));
        row[3] = new Square(new Queen(color));
        row[4] = new Square(new King(color));
        row[5] = new Square(new Bishop(color));
        row[6] = new Square(new Knight(color));
        row[7] = new Square(new Rook(color));
        return row;
    }

    private Square[] CreateFrontRow(String color){
        Square[] row = new Square[width];
        for (int i = 0; i < width; i++){
            row[i] = new Square(new Pawn(color));
        }
        return row;
    }

    private Square[] CreateEmptyRow(){
        Square[] row = new Square[width];
        for (int i = 0; i < width; i++){
            row[i] = new Square();
        }
        return row;
    }

    public void PrintBoard(){
        for (int i = height-1; i >= 0; i--) { //print it in reverse
            System.out.printf("|\t");
            for (var square: board[i]) {
                if(square.getPiece() != null)
                    System.out.printf(square.getPiece().toString() + "\t|\t");
                else
                    System.out.printf("\t\t|\t");
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }

    public boolean tryMove(int x1, int y1, int x2, int y2){
        Square square = board[x1][y1];
        Square newSquare = board[x2][y2];

        if(square.getPiece() == null )
            return false;
        else if(x2 < 0 || x2 > 7) //Move within board vertically?
            return false;
        else if(y2 < 0 || y2 > 7) //Move within board horizontally?
            return false;
        else if(!square.getPiece().canMove(x1, y1, x2, y2, newSquare.getPiece())) //can piece move this way?
            return false;
        else if(newSquare.getPiece() != null && square.getPiece().color.equals(newSquare.getPiece().color)) //same color pieces cannot move to each other
            return false;
        else
            newSquare.setPiece(square.getPiece());
            square.removePiece();
            return true;
    }

}
