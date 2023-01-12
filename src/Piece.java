import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

    public int i;
    public int j;

    public String name;
    public int value = -1;
    public boolean isWhite;
    public boolean firstMove = true;
    int up = 0;
    int right = 0;
    int left = 0;
    int down = 0;
    int y = i;
    int x = j;
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
}


