import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    public Pawn(int i, int j, boolean isWhite, String name){
        super(i, j, isWhite, name);
        if (isWhite) {
            this.value = 6;
        } else {
            this.value = 7;
        }
    }
    public ArrayList<ArrayList<Integer>> getLegalMoves(Piece[][] board, int i, int j) {
        System.out.println("update");
        int x;
        int y;
        if(this.isWhite){
            if(board[i + 1][j] == null){
                this.addMove(1,0); // one step forward
                if(i == 1) { // not in the secound row, pawn cant move back so this soloution works
                    System.out.println("update");
                    this.addMove(2,0); // two step forward
                }
            }
            if(j<7){
                if(board[i + 1][j + 1]!=null) {
                    if(board[i + 1][j + 1].isWhite != this.isWhite) {
                        System.out.println("update");
                        this.addMove(1,1); // to the diag
                    }
                }
            }
            if(j>0){
                if(board[i + 1][j - 1]!=null) {
                    if(board[i + 1][j - 1].isWhite != this.isWhite) {
                        this.addMove(1,-1); // to the diag
                    }
                }
            }
        }

        if(!this.isWhite){
            if(board[i - 1][j] == null){
                this.addMove(-1,0); // one step forward
                if(i == 6) { // not in the secound row, pawn cant move back so this soloution works
                    System.out.println("update");
                    this.addMove(-2,0); // two step forward
                }
            }
            if(j<7){
                if(board[i - 1][j + 1]!=null) {
                    if(board[i - 1][j + 1].isWhite != this.isWhite) {
                        System.out.println("update");
                        this.addMove(-1,1); // to the diag
                    }
                }
            }
            if(j>0){
                if(board[i - 1][j - 1]!=null) {
                    if(board[i - 1][j - 1].isWhite != this.isWhite) {
                        this.addMove(-1,-1); // to the diag
                    }
                }
            }
        }

        return legalMoves;
    }

}
