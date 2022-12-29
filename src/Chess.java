public class Chess implements Boardgame {
    private final Piece[][] board = new Piece[8][8];

    int xMove = -1;
    int yMove = -1;
    int xDrop = -1;
    int yDrop = -1;
    Piece piceMove;
    Piece piceDrop;

    public boolean move(int x, int y) {

        if (this.board[x][y]!=null) {
            xMove = x;
            yMove = y;
            piceMove=this.board[x][y];
            return true;
        }
        return false;
    }


    public boolean drop(int x, int y) {
        this.board[x][y]=piceMove;
        this.board[xMove][yMove]=null;
        xMove = -1;
        yMove = -1;
        piceMove=null;
        return true;

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
