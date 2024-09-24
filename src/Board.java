public class Board {
    private char[][] board;
    private int size;

    public Board(int size) {
        this.size = size;
        board = new char[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                board[i][j] ='-';
            }
        }
    }

    public boolean makeMove(int row, int col, char symbol) {
        if(row < 0 || col < 0 || row >= size || col >= size || board[row][col] != '-') {
            return false;
        }
        board[row][col] = symbol;
        return true;
    }

    public boolean checkWin(char symbol) {
        for(int i = 0; i < size; i++) {
            if(checkRow(i, symbol) || checkColumn(i, symbol))
                return true;
        }
        return checkDiagonals(symbol);
    }

    private boolean checkRow(int row, char symbol) {
        for(int i = 0; i < size; i++) {
            if(board[row][i] != symbol)
                return false;
        }
        return true;
    }

    private boolean checkColumn(int col, char symbol) {
        for(int i = 0; i < size; i++) {
            if(board[i][col] != symbol)
                return false;
        }
        return true;
    }


    private boolean checkDiagonals(char symbol) {
        boolean leftToRight = true;
        for(int i = 0; i < size; i++) {
            if(board[i][i] != symbol) {
                leftToRight = false;
                break;
            }
        }

        boolean rightToLeft = true;
        for(int i =0; i < size; i++) {
            if(board[i][size -i - 1] != symbol) {
                rightToLeft = false;
                break;
            }
        }
        return leftToRight || rightToLeft;
    }

    public boolean isFull() {
        for(int i =0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
