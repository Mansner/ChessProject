import java.util.ArrayList;

public class Queen extends Piece{

    public Queen(boolean isWhite, String name){
        super(isWhite, name);}

    public ArrayList<ArrayList<Integer>> getLegalMoves(Piece[][] board, int i, int j) { //tweaks the moves that are unique to the given piece
        //rook
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
                            break;
                        }
                    }
                    else if (board[y+1][x].isWhite!=this.isWhite) {
                        yf += 1;
                        this.addMove(yf, 0);
                        y = i;
                        break;}
                    else {
                        b = false;
                        y = i;
                    }}}
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
                        }}
                    else if (board[y-1][x].isWhite!=this.isWhite) {
                        y-=1;
                        yb -= 1;
                        this.addMove(yb, 0);
                        y = i;
                        break;}
                    else {
                        b=false;
                        y=i;
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
                    }}}

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

        int up=0;
        int right=0;
        int left=0;
        int down=0;
        y=i;
        x=j;

        b=true;
        if (i>0 && j>0){
            while (b){
                if (board[y-1][x-1]==null){
                    y-=1;
                    x-=1;
                    up-=1;
                    left-=1;
                    this.addMove(up,left);
                    if (y==0|| x==0){
                        y=i;
                        x=j;
                        break;
                    }
                }
                else if (board[y-1][x-1].isWhite!=this.isWhite) {
                    up -= 1;
                    left-=1;
                    this.addMove(up, left);
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
        up=0;
        if (i>0 && j<7){
            while (b){
                if (board[y-1][x+1]==null){
                    y-=1;
                    x+=1;
                    up-=1;
                    right+=1;
                    this.addMove(up,right);
                    if (y==0 || x==7){
                        b=false;
                        y=i;
                        x=j;
                    }
                }
                else if (board[y-1][x+1].isWhite!=this.isWhite) {
                    up -= 1;
                    right+=1;
                    this.addMove(up, right);
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
        left=0;
        if (i<7 && j>0){
            while (b){
                if (board[y+1][x-1]==null){
                    y+=1;
                    x-=1;
                    down+=1;
                    left-=1;
                    this.addMove(down,left);
                    if (y==7|| x==0){
                        y=i;
                        x=j;
                        break;
                    }
                }
                else if (board[y+1][x-1].isWhite!=this.isWhite) {
                    down += 1;
                    left-=1;
                    this.addMove(down, left);
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
        down=0;
        right=0;
        if (i<7 && j<7) {
            while (b) {
                if (board[y + 1][x + 1] == null) {
                    y += 1;
                    x += 1;
                    down += 1;
                    right += 1;
                    this.addMove(down, right);
                    if (y == 7 ) {
                        b = false;
                    } else if (x==7) {
                        break;
                    }
                } else if (board[y + 1][x + 1].isWhite != this.isWhite) {
                    down += 1;
                    right += 1;
                    this.addMove(down, right);
                    break;
                } else {
                    b = false;

                }
            }

        }
        return legalMoves;
        }
    }

