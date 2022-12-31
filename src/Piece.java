import java.util.ArrayList;

public abstract class Piece {

    public int i;
    public int j;
    public String name;
    public int value = -1;
    public boolean isWhite;
    public boolean firstMove = true;
    public ArrayList<ArrayList<Integer>> legalMoves = new ArrayList<ArrayList<Integer>>();

    public Piece(int i, int j, boolean isWhite, String name) {
        this.i = i;
        this.j = j;
        this.isWhite = isWhite;
        this.name = name;
    }

    public boolean addMove(int a, int b) {
        ArrayList<Integer> move = new ArrayList<Integer>();
        move.add(a);
        move.add(b);
        this.legalMoves.add(move);
        return true;
    }

    public ArrayList<ArrayList<Integer>> getLegalMoves() {
        return legalMoves;
    }


    public ArrayList<ArrayList<Integer>> sendLegalMoves() { // tweaks the moves that is true for all pieces
        legalMoves = getLegalMoves();

        return legalMoves;
    }

}

