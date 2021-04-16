import Chess.ChessBoard;

public class Main {
    public static void main(String args[]){
        ChessBoard cb = new ChessBoard();
        cb.PrintBoard();


        cb.tryMove(1,0, 2,0);

        cb.PrintBoard();

        cb.tryMove(2,0, 3,0);

        cb.PrintBoard();

        cb.tryMove(3,0, 4,0);

        cb.PrintBoard();

        cb.tryMove(4,0, 5,0);

        cb.PrintBoard();

        cb.tryMove(5,0, 6,1);

        cb.PrintBoard();

    }
}
