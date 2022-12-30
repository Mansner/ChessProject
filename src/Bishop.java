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

    @Override
    public List<Integer> updateLegalMoves(Piece[][] board) {
        return null;
    }

    public List<Integer> updateLegalMoves() {
        list.add(1);
        list.add(1);
        return list;
    }
}


