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
        System.out.println("update");
        int yf=0;
        int yb=0;
        int xl=0;
        int xr=0;
        int y=i;
        int x=j;

        boolean b=true;
        System.out.println(i);
        if (i<7){
            while (b){
                System.out.println("fram");
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
                System.out.println(y);
                if (board[y-1][x]==null){
                    System.out.println("bak");
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
                    y-=1;
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
                System.out.println(y);
                if (board[y][x-1]==null) {
                    System.out.println("vänster");
                    x -= 1;
                    xl -= 1;
                    this.addMove(0, xl);
                    if (x == 0) {
                        b = false;
                        y = i;
                        x = j;
                    }
                } else if (board[y][x-1].isWhite!=this.isWhite) {
                    xl -= 1;
                    this.addMove(0, xl);
                    y = i;
                    x = j;
                    break;

                } else {
                    b=false;
                    y=i;
                    x=j;
                }
            }}

            b=true;
        if (j<7){
            while (b){
                System.out.println("höger");
                System.out.println(board[y][x+1]);
                System.out.println(y);
                if (board[y][x+1]==null){
                    System.out.println("h1");
                    x+=1;
                    xr+=1;
                    this.addMove(0,xr);
                    if (x==7){
                        System.out.println("h2");
                        b=false;
                        y=i;
                        x=j;
                    }
                }
                else if (board[y][x+1].isWhite!=this.isWhite) {
                    xr += 1;
                    this.addMove(0, xr);
                    System.out.println("h3");
                    break;}
                else {
                    b=false;
                    y=i;
                    x=j;
                    System.out.println("h4");
                }
            }}
            System.out.println("update");








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



        return legalMoves;
    }}

