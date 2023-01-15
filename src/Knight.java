import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{

    public Knight(boolean isWhite, String name){
        super(isWhite, name);}

    public ArrayList<ArrayList<Integer>> getLegalMoves(Piece[][] board, int i, int j) {
        if(i<7){
            if (j<6){
                if (board[i + 1][j + 2]!=null)
                {if (board[i + 1][j + 2].isWhite==this.isWhite){
                }
                else{;
                    this.addMove(1,2);}
                }
                else{
                ;
                this.addMove(1,2);}

            if (j>1){
                if (board[i + 1][j - 2]!=null)
                {if (board[i + 1][j - 2].isWhite==this.isWhite){
                }
                else{;
                    this.addMove(1,-2);}
                }
                else{

                    this.addMove(1,-2);}
            }}
            if (i<6){
                if (j<7){
                    if (board[i + 2][j + 1]!=null)
                    {if (board[i + 2][j + 1].isWhite==this.isWhite){
                    }
                    else{
                        this.addMove(2,1);}
                    }
                    else{

                        this.addMove(2,1);}
                    }

                if (j>0){
                    if (board[i + 2][j - 1]!=null)
                    {if (board[i + 2][j - 1].isWhite==this.isWhite){
                    }
                    else{
                        this.addMove(2,-1);}
                    }
                    else{

                        this.addMove(2,-1);}
        }}}

            if (i>0){
                if (j<6){
                    if (board[i - 1][j + 2]!=null)
                    {if (board[i - 1][j + 2].isWhite==this.isWhite){
                    }
                    else{
                        this.addMove(-1,2);}
                    }
                    else{

                        this.addMove(-1,2);}

                if (j>1) {
                    if (board[i -1][j -2]!=null)
                    {if (board[i-1][j-2].isWhite==this.isWhite){
                    }
                    else{
                        this.addMove(-1,-2);}
                    }
                    else{

                        this.addMove(-1,-2);}
                }
            }
            if (i>1){
                if (j<7){
                    if (board[i-2][j + 1]!=null)
                    {if (board[i-2][j + 1].isWhite== this.isWhite){
                    }
                    else{
                        this.addMove(-2,1);}
                    }
                    else{

                        this.addMove(-2,1);}
                if (j>0) {
                    if (board[i-2][j - 1]!=null)
                    {if (board[i - 2][j - 1].isWhite== this.isWhite){
                    }
                    else{
                        this.addMove(-2,-1);}
                    }
                    else{
                        this.addMove(-2,-1);}
                }
                }}}
        return legalMoves;


}}


