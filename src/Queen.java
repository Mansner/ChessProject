import java.util.ArrayList;

public class Queen extends Piece{

    public Queen(boolean isWhite, String name){
        super(isWhite, name);}


    public ArrayList<ArrayList<Integer>> getLegalMoves(Piece[][] board, int i, int j) { //tweaks the moves that are unique to the given piece
        //rook
        if (i<7){generateMoves(board,i,j,1,0);}
        if (i>1){generateMoves(board,i,j,-1,0);}
        if (j>0){generateMoves(board,i,j,0,-1);}
        if (j<7){generateMoves(board,i,j,0,1);}
        if (i>0 && j>0){generateMoves(board,i,j,-1,-1);}
        if (i>0 && j<7){generateMoves(board,i,j,-1,1);}
        if (i<7 && j>0){generateMoves(board,i,j,1,-1);}
        if (i<7 && j<7) {generateMoves(board,i,j,1,1);}
        return legalMoves;
        }
    }

