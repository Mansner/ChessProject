import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rook extends Piece{

    public Rook(boolean isWhite, String name){
        super( isWhite, name);}

    public ArrayList<ArrayList<Integer>> getLegalMoves(Piece[][] board, int i, int j) {
        int yf=0;
        int yb=0;
        int xleft=0;
        int xright=0;
        int y=i;
        int x=j;

        boolean b=true;
        if (i<7){
            while (b){
                if (board[y+1][x]==null){
                    y+=1;
                    yf+=1;
                    this.addMove(yf,0);
                    if (y==7){
                        y=i;
                        x=j;
                        break;
                    }
                }
                else if (board[y+1][x].isWhite!=this.isWhite) {
                    yf += 1;
                    this.addMove(yf, 0);
                    y = i;
                    x = j;
                    break;}
                else {
                    b=false;
                    y=i;
                    x=j;
                }
            }}
        b=true;
        if (i>1){
            while (b){
                if (board[y-1][x]==null){
                    y-=1;
                    yb-=1;
                    this.addMove(yb,0);
                    if (y==0){
                        b=false;
                        y=i;
                        x=j;
                    }
                }
                else if (board[y-1][x].isWhite!=this.isWhite) {
                    yb -= 1;
                    this.addMove(yb, 0);
                    y = i;
                    x = j;
                    break;}
                else {
                    b=false;
                    y=i;
                    x=j;
                }
            }}
        b=true;
        if (j>0){
            while (b){
                if (board[y][x-1]==null) {
                    x -= 1;
                    xleft -= 1;
                    this.addMove(0, xleft);
                    if (x == 0) {
                        b = false;
                        x = j;
                    }
                } else if (board[y][x-1].isWhite!=this.isWhite) {
                    xleft -= 1;
                    this.addMove(0, xleft);
                    x = j;
                    break;

                } else {
                    b=false;
                    x=j;
                }
            }}

        b=true;
        if (j<7){
            while (b){
                if (board[y][x+1]==null){
                    x+=1;
                    xright+=1;
                    this.addMove(0,xright);
                    if (x==7){
                        b=false;
                        x=j;
                    }
                }
                else if (board[y][x+1].isWhite!=this.isWhite) {
                    xright += 1;
                    this.addMove(0, xright);
                    break;}
                else {
                    b=false;
                    x=j;
                }
            }}
        return legalMoves;
    }

}

