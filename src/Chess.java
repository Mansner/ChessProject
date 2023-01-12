import java.util.ArrayList;
import java.util.Objects;

public class Chess implements Boardgame {
    private final Piece[][] board = new Piece[8][8];

    int xMove = -1;
    int yMove = -1;
    Piece piceMove;
    boolean isWhiteTurn = true;
    ArrayList<ArrayList<Integer>> legalMoves;

    public boolean move(int x, int y) { //redan här genereras alla legal moves från Piece
        System.out.println(this.board[x][y]);

        if (this.board[x][y]!=null) {
            if (checkTurn(x,y)){
                ArrayList<ArrayList<Integer>> legal = this.board[x][y].getLegalMoves(board, x, y);
                legalMoves = legal;
                xMove = x;
                yMove = y;
                piceMove=this.board[x][y];
                return true;
            }
        }
        return false;
    }


    public boolean drop(int x, int y) { // ska kolla så man fakktiskt lägger på en plats som e tillåten

        if(!checkDrop(x,y)){
            return false;
        }
        if(checkTurn(xMove,yMove)){
            this.board[x][y]=piceMove;
            this.board[xMove][yMove].removeAllMoves();
            this.board[xMove][yMove]=null;
            xMove = -1;
            yMove = -1;
            this.board[x][y].getLegalMoves(board, x, y);
            checkKing(x, y);
            checkPromovera(x,y);
            this.board[x][y].removeAllMoves();
            piceMove=null;
            isWhiteTurn= !isWhiteTurn;
            return true;
        }
        return false;
    }

    private void checkPromovera(int x, int y){
        if(Objects.equals(piceMove.name, "pawn")){
            if(x==7){
                this.board[x][y] = new Queen(0, 3, true, "queen");
            }
        }
        if(Objects.equals(piceMove.name, "bpawn")){
            if(x==0){
                this.board[x][y] = new Queen(0, 3, false, "bqueen");
            }
        }
    }

    private void checkKing(int x, int y){
        System.out.println(legalMoves);
        for (ArrayList<Integer> list : legalMoves) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Piece pice = board[i][j];
                    if(pice!=null){
                        if(Objects.equals(pice.name, "king") || Objects.equals(pice.name, "bking")){
                            if(list.get(0) + x == i & list.get(1) + y == j){
                                if(pice.isWhite != isWhiteTurn){
                                    System.out.println("Kingen är i fara");
                                }
                    }
                        }
                    }
                }
            }
            }
    }

    private boolean checkTurn(int i, int j){
        if(this.board[i][j].isWhite == isWhiteTurn){
            return true;
        }
        return false;
    }

    private boolean checkDrop(int x, int y){
        System.out.println(legalMoves);
        for (ArrayList<Integer> list : legalMoves) {
            if(list.get(0) + xMove == x & list.get(1) + yMove == y){
                return true;
            }
        }
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