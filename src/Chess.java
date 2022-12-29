public class Chess implements Boardgame {
    private final Piece[][] board = new Piece[8][8];

    public boolean move(int x, int y) {
        this.board[x][y] = new Bishop(0, 2, false, "bishop");
        return true;
    }


    public boolean drop(int x, int y) {
        return false;
    }

    public Piece getStatus(int i, int j) {
        return this.board[i][j];
    }

    public String getMessage() {
        return null;
    }

    public void initBoard() {
        this.board[0][2] = new Bishop(0, 2, false, "bishop");
    }


    public Chess(){
        initBoard();
    }
}
