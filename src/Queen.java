import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece{

    public Queen(int i, int j, boolean isWhite, String name){
        super(i, j, isWhite, name);
        if (isWhite) {
            this.value = 6;
        } else {
            this.value = 7;
        }
    }
    public ArrayList<ArrayList<Integer>> getLegalMoves(Piece[][] board, int i, int j) { //tweaks the moves that are unique to the given piece
        bishopRules(board, i, j);
        rookRules(board,i,j);
        return legalMoves;
    }
}

