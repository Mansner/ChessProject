import java.util.ArrayList;
import java.util.List;

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
}


