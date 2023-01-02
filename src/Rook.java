import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{

    public Rook(int i, int j, boolean isWhite, String name){
        super(i, j, isWhite, name);
        if (isWhite) {
            this.value = 6;
        } else {
            this.value = 7;
        }
    }
    public ArrayList<ArrayList<Integer>> getLegalMoves(Piece[][] board, int i, int j) {
        System.out.println("update");
        int xf=0;
        int xb=0;
        int yl=0;
        int yr=0;

        boolean b=true;

        if(this.isWhite){
            while (b){
                if (board[i+1][j]==null){
                    i+=1;
                    xf+=1;
                    if (i==0){
                        b=false;
                    }
                }
                else {
                    b=false;
                }
            }
            this.addMove(xf,0);
            b=true;
            while (b){
                if (board[i-1][j]==null){
                    i-=1;
                    xb-=1;
                    if (i==8){
                        b=false;
                    }
                }
                else {
                    b=false;
                }
            }
            this.addMove(xb,0);
            b=true;
            while (b){
                if (board[i][j-1]==null){
                    j-=1;
                    yl-=1;
                    if (j==0){
                        b=false;
                    }
                }
                else {
                    b=false;
                }
            }
            this.addMove(0,yl);
            b=true;
            while (b){
                if (board[i][j+1]==null){
                    j+=1;
                    yr+=1;
                    if (j==8){
                        b=false;
                    }
                }
                else {
                    b=false;
                }
            }
            this.addMove(0,yr);



//            if(board[i + 1][j] == null){
//                this.addMove(x,y); // one step forward
//                if(i == 1) { // not in the secound row, pawn cant move back so this soloution works
//                    System.out.println("update");
//                    this.addMove(2,0); // two step forward
//                }
//            }
//            if(j<7){
//                if(board[i + 1][j + 1]!=null) {
//                    if(board[i + 1][j + 1].isWhite != this.isWhite) {
//                        System.out.println("update");
//                        this.addMove(1,1); // to the diag
//                    }
//                }
//            }
//            if(j>0){
//                if(board[i + 1][j - 1]!=null) {
//                    if(board[i + 1][j - 1].isWhite != this.isWhite) {
//                        this.addMove(1,-1); // to the diag
//                    }
//                }
//            }
//        }
//
//        if(!this.isWhite){
//            if(board[i - 1][j] == null){
//                this.addMove(-1,0); // one step forward
//                if(i == 6) { // not in the secound row, pawn cant move back so this soloution works
//                    System.out.println("update");
//                    this.addMove(-2,0); // two step forward
//                }
//            }
//            if(j<7){
//                if(board[i - 1][j + 1]!=null) {
//                    if(board[i - 1][j + 1].isWhite != this.isWhite) {
//                        System.out.println("update");
//                        this.addMove(-1,1); // to the diag
//                    }
//                }
//            }
//            if(j>0){
//                if(board[i - 1][j - 1]!=null) {
//                    if(board[i - 1][j - 1].isWhite != this.isWhite) {
//                        this.addMove(-1,-1); // to the diag
//                    }
//                }
//            }
//        }
//


}
        return legalMoves;
    }}

