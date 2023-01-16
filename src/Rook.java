import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rook extends Piece{

    public Rook(boolean isWhite, String name){
        super( isWhite, name);}

    public ArrayList<ArrayList<Integer>> getLegalMoves(Piece[][] board, int i, int j) {
        if (i<7){generateMoves(board,i,j,1,0);}
        if (i>1){generateMoves(board,i,j,-1,0);}
        if (j>0){generateMoves(board,i,j,0,-1);}
        if (j<7){generateMoves(board,i,j,0,1);}
        return legalMoves;
    }

}

