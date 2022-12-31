import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    public Pawn(int i, int j, boolean isWhite, String name){
        super(i, j, isWhite, name);
        if (isWhite) {
            this.value = 6;
        } else {
            this.value = 7;
        }
    }
    public ArrayList<ArrayList<Integer>> getLegalMoves() {
        this.addMove(1,1); // SouthEast
        this.addMove(1,-1); // SouthEast
        System.out.println(legalMoves);
        return legalMoves;
    }

}
