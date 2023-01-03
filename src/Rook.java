import java.util.ArrayList;
import java.util.Arrays;
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
        rookRules(board,i,j);
//        int yf=0;
//        int yb=0;
//        int xleft=0;
//        int xright=0;
//        int y=i;
//        int x=j;
//
//        boolean b=true;
//        System.out.println(i);
//        if (i<7){
//            while (b){
//                System.out.println("fram");
//                if (board[y+1][x]==null){
//                    y+=1;
//                    yf+=1;
//                    this.addMove(yf,0);
//                    if (y==7){
//                        y=i;
//                        x=j;
//                        break;
//                    }
//                }
//                else if (board[y+1][x].isWhite!=this.isWhite) {
//                    yf += 1;
//                    this.addMove(yf, 0);
//                    y = i;
//                    x = j;
//                break;}
//                else {
//                    b=false;
//                    y=i;
//                    x=j;
//                }
//            }}
//            b=true;
//            if (i>1){
//            while (b){
//                System.out.println(y);
//                if (board[y-1][x]==null){
//                    System.out.println("bak");
//                    y-=1;
//                    yb-=1;
//                    this.addMove(yb,0);
//                    if (y==0){
//                        b=false;
//                        y=i;
//                        x=j;
//                    }
//                }
//                else if (board[y-1][x].isWhite!=this.isWhite) {
//                    y-=1;
//                    yb -= 1;
//                    this.addMove(yb, 0);
//                    y = i;
//                    x = j;
//                    break;}
//                else {
//                    b=false;
//                    y=i;
//                    x=j;
//                }
//            }}
//            b=true;
//            if (j>0){
//            while (b){
//                if (board[y][x-1]==null) {
//                    System.out.println("vänster");
//                    x -= 1;
//                    xleft -= 1;
//                    this.addMove(0, xleft);
//                    if (x == 0) {
//                        b = false;
//                        x = j;
//                    }
//                } else if (board[y][x-1].isWhite!=this.isWhite) {
//                    xleft -= 1;
//                    this.addMove(0, xleft);
//                    x = j;
//                    break;
//
//                } else {
//                    b=false;
//                    x=j;
//                }
//            }}
//
//            b=true;
//        if (j<7){
//            while (b){
//                System.out.println("höger");
//                if (board[y][x+1]==null){
//                    x+=1;
//                    xright+=1;
//                    this.addMove(0,xright);
//                    if (x==7){
//                        b=false;
//                        x=j;
//                    }
//                }
//                else if (board[y][x+1].isWhite!=this.isWhite) {
//                    xright += 1;
//                    this.addMove(0, xright);
//                    break;}
//                else {
//                    b=false;
//                    x=j;
//                }
//            }}
//            System.out.println("update");
       return legalMoves;
    }
}

