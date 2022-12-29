public class Chess implements Boardgame {
    private final Piece[][] board = new Piece[8][8];

    public boolean move(int x, int y) {
        this.board[x][y] = new Bishop(0, 2, true, "bishop");
        this.board[x][y] = new Bishop(0, 5, true, "bishop");
        this.board[x][y] = new Bishop(7, 2, false, "bbishop");
        this.board[x][y] = new Bishop(7, 5, false, "bbishop");
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

        for (int j=0; j<8; j++){
            this.board[1][j] = new Pawn(1, j, true, "pawn");
        }
        for (int j=0; j<8; j++){
            this.board[6][j] = new Pawn(7, j, false, "bpawn");
        }

        this.board[0][2] = new Bishop(0, 2, true, "bishop");
        this.board[0][5] = new Bishop(0, 5, true, "bishop");
        this.board[7][2] = new Bishop(7, 2, false, "bbishop");
        this.board[7][5] = new Bishop(7, 5, false, "bbishop");

        this.board[0][0] = new Rook(0, 0, true, "rook");
        this.board[0][7] = new Rook(0, 7, true, "rook");
        this.board[7][0] = new Rook(0, 0, false, "brook");
        this.board[7][7] = new Rook(0, 7, false, "brook");

        this.board[0][1] = new Knight(0, 1, true, "knight");
        this.board[0][6] = new Knight(0, 6, true, "knight");
        this.board[7][1] = new Knight(0, 1, false, "bknight");
        this.board[7][6] = new Knight(0, 6, false, "bknight");

        this.board[0][4] = new King(0, 4, true, "king");
        this.board[7][4] = new King(0, 4, false, "bking");

        this.board[0][3] = new Queen(0, 3, true, "queen");
        this.board[7][3] = new Queen(0, 3, false, "bqueen");






    }


    public Chess(){
        initBoard();
    }
}
