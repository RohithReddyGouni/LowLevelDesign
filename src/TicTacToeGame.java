import java.util.Scanner;

public class TicTacToeGame {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    private int size;

    public TicTacToeGame(Player player1, Player player2, int size) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board(size);
        this.currentPlayer = player1;
        this.size = size;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        while(!gameWon && !board.isFull()) {
            board.printBoard();
            System.out.println(currentPlayer.getName() +"'s turn (" + currentPlayer.getSymbol() + ")");
            System.out.println("Enter row and column (0 to "+(size - 1)+"):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if(!board.makeMove(row, col, currentPlayer.getSymbol())) {
                System.out.println("Invalid Move, try again...");
                continue;
            }

            if(board.checkWin(currentPlayer.getSymbol())) {
                gameWon = true;
                board.printBoard();
                System.out.println(currentPlayer.getName() + "wins!");
            }
            else{
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }

        }

        if(!gameWon) {
            board.printBoard();
            System.out.println("The game is draw");
        }

        scanner.close();
    }



    public static void main(String[] args) {
        Player player1 = new Player("Rohith", 'X');
        Player player2 = new Player("Purna", 'O');
        TicTacToeGame game = new TicTacToeGame(player1, player2, 3);
        game.playGame();
    }

}
