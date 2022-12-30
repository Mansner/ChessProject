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

    @Override
    public List<Integer> updateLegalMoves(Piece[][] board) {

        return null;
    }
}
