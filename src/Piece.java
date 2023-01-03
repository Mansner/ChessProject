import java.util.ArrayList;

public abstract class Piece {

    public int i;
    public int j;

    public String name;
    public int value = -1;
    public boolean isWhite;
    public boolean firstMove = true;
    int up=0;
    int right=0;
    int left=0;
    int down=0;
    int y=i;
    int x=j;
    boolean b;
    public ArrayList<ArrayList<Integer>> legalMoves = new ArrayList<ArrayList<Integer>>();


    public Piece(int i, int j, boolean isWhite, String name) {
        this.i = i;
        this.j = j;
        this.isWhite = isWhite;
        this.name = name;
    }

    public void addMove(int a, int b) {
        ArrayList<Integer> move = new ArrayList<Integer>();
        move.add(a);
        move.add(b);
        System.out.println(move);
        this.legalMoves.add(move);
    }

    public void removeAllMoves() {
        this.legalMoves.clear();
        System.out.println(legalMoves);
    }

    public ArrayList<ArrayList<Integer>> getLegalMoves(Piece[][] board, int i, int j) {
        return legalMoves;
    }


    public ArrayList<ArrayList<Integer>> sendLegalMoves() { // tweaks the moves that is true for all pieces
        return legalMoves;
    }

    public void upleft(){
        up-=1;
        left-=1;
        this.addMove(up,left);
    }
    public void resetij(){
        y = i;
        x = j;
        this.b=false;}


    public ArrayList<ArrayList<Integer>> bishopRules(Piece[][] board, int i, int j){
            int up=0;
            int right=0;
            int left=0;
            int down=0;
            int y=i;
            int x=j;

            boolean b=true;
            if (i>0 && j>0){
                while (b){
                    System.out.println("uppVänster");
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
                        System.out.println("upHöger");
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
                    System.out.println("nerVänster");
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
                    System.out.println("nerHöger");
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
    public ArrayList<ArrayList<Integer>> rookRules(Piece[][] board, int i, int j) {
        int yf=0;
        int yb=0;
        int xleft=0;
        int xright=0;
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
                if (board[y][x-1]==null) {
                    System.out.println("vänster");
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
                System.out.println("höger");
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
        System.out.println("update");
        return legalMoves;
    }
    }


