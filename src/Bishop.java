import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece{
    List<Integer> list=new ArrayList<Integer>();

    public Bishop(boolean isWhite, String name){
        super(isWhite, name);}

    public ArrayList<ArrayList<Integer>> getLegalMoves(Piece[][] board, int i, int j){
        if (i>0 && j>0){generateMoves(board,i,j,-1,-1);}
        if (i>0 && j<7){generateMoves(board,i,j,-1,1);}
        if (i<7 && j>0){generateMoves(board,i,j,1,-1);}
        if (i<7 && j<7) {generateMoves(board,i,j,1,1);}
        return legalMoves;}}