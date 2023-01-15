import java.util.ArrayList;
import java.util.Objects;

public class Chess implements Boardgame {
    private final Piece[][] board = new Piece[8][8];
    int xMove = -1;
    int yMove = -1;
    Piece piceMove;
    boolean isWhiteTurn = true;
    ArrayList<ArrayList<Integer>> legalMoves;
    String showMessage;

    public boolean move(int x, int y) {

        if (this.board[x][y]!=null) { // bara om det finns ett objekt på platsen.
            if (checkTurn(x,y)){// kollar om det är den valda pjäsens spelares tur.
                legalMoves = this.board[x][y].getLegalMoves(board, x, y); //tar fram alla moves som är tillåtna.
                xMove = x; //sparar platsen där pjäsen står, används senare i funktionen drop.
                yMove = y;
                piceMove=this.board[x][y]; //sparar objektet (Piece)
                showMessage=" ";
                return true;
            }
        }
        return false;
    }


    public boolean drop(int x, int y) { // ska kolla så man fakktiskt lägger på en plats som e tillåten
        if(!checkDrop(x,y)){ //kollar så man lägger pjäsen på ett move som finns i legalmoves listan
            return false;
        }

        if(checkTurn(xMove,yMove)){//kanske inte behövs?
            this.board[x][y]=piceMove;
            this.board[xMove][yMove]=null;
            xMove = -1;
            yMove = -1;
            checkPromovera(x,y); //kollar om det draget ska göra om en bonde till en drottning
            legalMoves = this.board[x][y].getLegalMoves(board, x, y); //tar fram alla moves som är tillåtna.
            checkKing(x, y); //kollar om det draget sätter motståndaren i chack
            piceMove=null;
            isWhiteTurn= !isWhiteTurn;
            return true;
        }
        return false;
    }

    private void checkPromovera(int x, int y){
        if(Objects.equals(piceMove.name, "pawn")){
            if(x==7){
                this.board[x][y] = new Queen( true, "queen");
            }
        }
        if(Objects.equals(piceMove.name, "bpawn")){
            if(x==0){
                this.board[x][y] = new Queen( false, "bqueen");
            }
        }
    }

    private void checkKing(int x, int y){
        for (ArrayList<Integer> list : legalMoves) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Piece pice = board[i][j];
                    if(pice!=null){
                        if(Objects.equals(pice.name, "king") || Objects.equals(pice.name, "bking")){//tar fram platsen för kungarna
                            if(list.get(0) + x == i & list.get(1) + y == j){ //kollar om kungarnas plats är ett move för den flyttarde pjäsen
                                if(pice.isWhite != isWhiteTurn){ //om det är den motsatta färgen
                                    showMessage="Schack"; // visas meddelandet
                                }
                    }
                        }
                    }
                }
            }
            }
    }

    private boolean checkTurn(int i, int j){ // kollar om det är rätt persons tur
        if(this.board[i][j].isWhite == isWhiteTurn){
            return true;
        }
        showMessage="Vald pjäs är fel färg, välj igen";
        return false;
    }

    private boolean checkDrop(int x, int y){
        if (legalMoves==null){
            showMessage="Felaktigt val! Vit färg börjar alltid i Schack";
            return false;
        }
        for (ArrayList<Integer> list : legalMoves) {
            if(list.get(0) + xMove == x & list.get(1) + yMove == y){
                showMessage=" ";
                return true;
            }
            showMessage="Felaktigt drag. Pjäsen kan inte gå till vald plats, välj igen";
        }
        return false;
    }

    public Piece getStatus(int i, int j) {
        return this.board[i][j];
    }

    public String getMessage() {

        return showMessage;
    }

    public void initBoard() {

        for (int j=0; j<8; j++){
            this.board[1][j] = new Pawn(true, "pawn");}
        for (int j=0; j<8; j++){
            this.board[6][j] = new Pawn(false, "bpawn");}

        this.board[0][2] = new Bishop(true, "bishop");
        this.board[0][5] = new Bishop( true, "bishop");
        this.board[7][2] = new Bishop( false, "bbishop");
        this.board[7][5] = new Bishop( false, "bbishop");

        this.board[0][0] = new Rook( true, "rook");
        this.board[0][7] = new Rook( true, "rook");
        this.board[7][0] = new Rook( false, "brook");
        this.board[7][7] = new Rook( false, "brook");

        this.board[0][1] = new Knight( true, "knight");
        this.board[0][6] = new Knight( true, "knight");
        this.board[7][1] = new Knight( false, "bknight");
        this.board[7][6] = new Knight( false, "bknight");

        this.board[0][4] = new King( true, "king");
        this.board[7][4] = new King( false, "bking");

        this.board[0][3] = new Queen( true, "queen");
        this.board[7][3] = new Queen( false, "bqueen");


    }


    public Chess(){
        initBoard();
    }
}