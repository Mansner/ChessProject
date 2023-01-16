import java.util.ArrayList;

public abstract class Piece {

    public String name;
    public int value = -1;
    public boolean isWhite;

    public ArrayList<ArrayList<Integer>> legalMoves = new ArrayList<ArrayList<Integer>>();

    public Piece( boolean isWhite, String name) {

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

    public void generateMoves(Piece[][] board, int i, int j, int nextY, int nextX){
        int yAdd=0;
        int xAdd=0;
        int y=i;
        int x=j;
            while (true){
                if (board[y+nextY][x+nextX]==null){
                    y+=nextY;
                    yAdd+=nextY;
                    x+=nextX;
                    xAdd+=nextX;
                    this.addMove(yAdd,xAdd);
                    if (y==7 || y==0){
                        if (nextY!=0){
                        break;}}
                    if (x==7 || x==0){
                        if (nextX!=0){
                            break;}}

                }
                else if (board[y+nextY][x+nextX].isWhite!=this.isWhite) {
                    yAdd += nextY;
                    xAdd+=nextX;
                    this.addMove(yAdd, xAdd);
                    break;}
                else {
                    break;
                }}
    }
}


