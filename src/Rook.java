public class Rook extends Piece{

    public Rook(int i, int j, boolean isWhite, String name){
        super(i, j, isWhite, name);
        if (isWhite) {
            this.value = 6;
        } else {
            this.value = 7;
        }
    }

    @Override
    public void updateLegalMoves(Piece[][] board) {

    }
}

