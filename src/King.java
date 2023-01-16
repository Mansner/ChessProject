import java.util.ArrayList;
import java.util.List;

public class King extends Piece{

    public King(boolean isWhite, String name){
        super( isWhite, name);}
    public ArrayList<ArrayList<Integer>> getLegalMoves(Piece[][] board, int i, int j) {

        if (i<7){
        if (board[i+1][j]==null) {
            addMove(1, 0); //down
        }
        else if (board[i+1][j].isWhite!=this.isWhite) {
            this.addMove(1, 0);
        }
            if(j<7){
                if(board[i + 1][j + 1]==null) {
                    this.addMove(1,1);}
                else if (board[i + 1][j + 1].isWhite != this.isWhite) {
                        this.addMove(1,1); // diagonal
                         }}
            if(j>0){
                if(board[i + 1][j - 1]==null) {

                    this.addMove(1, -1);
                } else if (board[i + 1][j - 1].isWhite != this.isWhite) {
                    this.addMove(1,-1);
                }
        }}
        if (i>0){
        if (board[i-1][j]==null) {
            addMove(-1, 0);//up
        }
        else if (board[i-1][j].isWhite!=this.isWhite) {
            this.addMove(-1, 0);
        }
            if(j<7){
                if(board[i - 1][j + 1]==null) {
                    this.addMove(-1,1);}

                else if(board[i - 1][j + 1].isWhite != this.isWhite) {
                        this.addMove(-1,1); // diagonal
                    }
                }

            if(j>0){

                if(board[i - 1][j - 1]==null) {this.addMove(-1,-1);}

                else if(board[i - 1][j - 1].isWhite != this.isWhite) {
                    this.addMove(-1,-1); // diagonal
                        }}}
        if (j<7){
        if (board[i][j+1]==null) {
            addMove(0, 1);//right
        }
        else if (board[i][j+1].isWhite!=this.isWhite) {
            this.addMove(0, 1);
        }}
        if (j>0){
        if (board[i][j-1]==null) {
            addMove(0, -1); //left
        }
        else if (board[i][j-1].isWhite!=this.isWhite) {
            this.addMove(0, -1);
        }}

        return legalMoves;
    }
}

