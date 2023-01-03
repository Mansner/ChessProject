import java.util.ArrayList;
import java.util.List;

public class King extends Piece{

    public King(int i, int j, boolean isWhite, String name){
        super(i, j, isWhite, name);
        if (isWhite) {
            this.value = 6;
        } else {
            this.value = 7;
        }
    }
    public ArrayList<ArrayList<Integer>> getLegalMoves(Piece[][] board, int i, int j) {
        System.out.println("update");
        int yf=0;
        int yb=0;
        int xh=0;
        int xv=0;
        if (i<7){
        if (board[i+1][j]==null) {
            yf += 1;
            addMove(yf, 0);
        }
        else if (board[i+1][j].isWhite!=this.isWhite) {
            yf += 1;
            this.addMove(yf, 0);
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
        }}}}

        if (i>0){
        if (board[i-1][j]==null) {
            yb -= 1;
            addMove(yb, 0);
        }
        else if (board[i-1][j].isWhite!=this.isWhite) {
            yb -= 1;
            this.addMove(yb, 0);
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
        if (j<7){
        if (board[i][j+1]==null) {
            xh += 1;
            addMove(0, xh);
        }
        else if (board[i][j+1].isWhite!=this.isWhite) {
            xh += 1;
            this.addMove(0, xh);
        }}
        if (j>0){
        if (board[i][j-1]==null) {
            xv -= 1;
            addMove(0, xv);
        }
        else if (board[i][j-1].isWhite!=this.isWhite) {
            xv -= 1;
            this.addMove(0, xv);
        }}

        return legalMoves;
    }
}

