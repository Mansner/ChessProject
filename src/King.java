import java.util.List;

public class King extends Piece{

    public King(int i, int j, boolean isWhite, String name){
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

