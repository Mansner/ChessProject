import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{
    List<Integer> list=new ArrayList<Integer>();

    public Bishop(int i, int j, boolean isWhite, String name){
        super(i, j, isWhite, name);
        if (isWhite) {
            this.value = 6;
        } else {
            this.value = 7;
        }
    }

    public ArrayList<ArrayList<Integer>> getLegalMoves(Piece[][] board, int i, int j) { //tweaks the moves that are unique to the given piece
        bishopRules(board,i,j);
//        int up=0;
//        int right=0;
//        int left=0;
//        int down=0;
//        int y=i;
//        int x=j;
//
//        boolean b=true;
//        if (i>0 && j>0){
//            while (b){
//                System.out.println("uppVänster");
//                if (board[y-1][x-1]==null){
//                    y-=1;
//                    x-=1;
//                    up-=1;
//                    left-=1;
//                    this.addMove(up,left);
//                    if (y==0|| x==0){
//                        y=i;
//                        x=j;
//                        break;
//                    }
//                }
//                else if (board[y-1][x-1].isWhite!=this.isWhite) {
//                    up -= 1;
//                    left-=1;
//                    this.addMove(up, left);
//                    y = i;
//                    x = j;
//                    break;}
//                else {
//                    b=false;
//                    y=i;
//                    x=j;
//                }
//            }}
//        b=true;
//        up=0;
//        if (i>0 && j<7){
//            while (b){
//                if (board[y-1][x+1]==null){
//                    System.out.println("upHöger");
//                    y-=1;
//                    x+=1;
//                    up-=1;
//                    right+=1;
//                    this.addMove(up,right);
//                    if (y==0 || x==7){
//                        b=false;
//                        y=i;
//                        x=j;
//                    }
//                }
//                else if (board[y-1][x+1].isWhite!=this.isWhite) {
//                    up -= 1;
//                    right+=1;
//                    this.addMove(up, right);
//                    y = i;
//                    x = j;
//                    break;}
//                else {
//                    b=false;
//                    y=i;
//                    x=j;
//                }
//            }}
//        b=true;
//        left=0;
//        if (i<7 && j>0){
//            while (b){
//                System.out.println("nerVänster");
//                if (board[y+1][x-1]==null){
//                    y+=1;
//                    x-=1;
//                    down+=1;
//                    left-=1;
//                    this.addMove(down,left);
//                    if (y==7|| x==0){
//                        y=i;
//                        x=j;
//                        break;
//                    }
//                }
//                else if (board[y+1][x-1].isWhite!=this.isWhite) {
//                    down += 1;
//                    left-=1;
//                    this.addMove(down, left);
//                    y = i;
//                    x = j;
//                    break;}
//                else {
//                    b=false;
//                    y=i;
//                    x=j;
//                }
//            }}
//        b=true;
//        down=0;
//        right=0;
//        if (i<7 && j<7) {
//            while (b) {
//                System.out.println("nerHöger");
//                if (board[y + 1][x + 1] == null) {
//                    y += 1;
//                    x += 1;
//                    down += 1;
//                    right += 1;
//                    this.addMove(down, right);
//                    if (y == 7 ) {
//                        b = false;
//                    } else if (x==7) {
//                        break;
//                    }
//                } else if (board[y + 1][x + 1].isWhite != this.isWhite) {
//                    down += 1;
//                    right += 1;
//                    this.addMove(down, right);
//                    break;
//                } else {
//                    b = false;
//
//
//
//                }
//
//            }
//
//
//        }
//        return legalMoves;
//    }
return legalMoves;}}