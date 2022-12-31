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

    public ArrayList<ArrayList<Integer>> getLegalMoves() { //tweaks the moves that are unique to the given piece
        this.addMove(1,-2); // SouthEast
        this.addMove(1,2); // SouthEast
        System.out.println(legalMoves);
        return legalMoves;
    }

}


