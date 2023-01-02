import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{

    public Knight(int i, int j, boolean isWhite, String name){
        super(i, j, isWhite, name);
        if (isWhite) {
            this.value = 6;
        } else {
            this.value = 7;
        }

    }
    public ArrayList<ArrayList<Integer>> getLegalMoves(Piece[][] board, int i, int j) {
        System.out.println("update");
        int x;
        int y;
        if(i<7){
            if (j<6){
                if (board[i + 1][j + 2]!=null)
                {if (board[i + 1][j + 2].isWhite){
                }
                else{System.out.println("update");
                    this.addMove(1,2);}
                }
                else{
                System.out.println("update");
                this.addMove(1,2);}

            if (j>1){
                if (board[i + 1][j - 2]!=null)
                {if (board[i + 1][j - 2].isWhite){
                }
                else{System.out.println("update");
                    this.addMove(1,-2);}
                }
                else{
                    System.out.println("update");
                    this.addMove(1,-2);}
            }
            if (i<6){
                if (j<7){
                    if (board[i + 2][j + 1]!=null)
                    {if (board[i + 2][j + 1].isWhite){
                    }
                    else{System.out.println("update");
                        this.addMove(2,1);}
                    }
                    else{
                        System.out.println("update");
                        this.addMove(2,1);}
                    }

                if (j>0){
                    if (board[i + 2][j - 1]!=null)
                    {if (board[i + 2][j - 1].isWhite){
                    }
                    else{System.out.println("update");
                        this.addMove(2,-1);}
                    }
                    else{
                        System.out.println("update");
                        this.addMove(2,-1);}
        }}}}

            if (i>0){
                if (j<7){
                    if (board[i - 1][j + 2]!=null)
                    {if (board[i - 1][j + 2].isWhite){
                    }
                    else{System.out.println("update");
                        this.addMove(-1,2);}
                    }
                    else{
                        System.out.println("update");
                        this.addMove(-1,2);}

                if (j>0) {
                    if (board[i -1][j -2]!=null)
                    {if (board[i-1][j-2].isWhite){
                    }
                    else{System.out.println("update");
                        this.addMove(-1,-2);}
                    }
                    else{
                        System.out.println("update");
                        this.addMove(-1,-2);}
                }
            }
            if (i>1){
                if (j<7){
                    if (board[i-2][j + 1]!=null)
                    {if (board[i-2][j + 1].isWhite){
                    }
                    else{System.out.println("update");
                        this.addMove(-2,1);}
                    }
                    else{
                        System.out.println("update");
                        this.addMove(-2,1);}
                if (j>0) {
                    if (board[i-2][j - 1]!=null)
                    {if (board[i - 2][j - 1].isWhite){
                    }
                    else{System.out.println("update");
                        this.addMove(-2,-1);}
                    }
                    else{
                        System.out.println("update");
                        this.addMove(-2,-1);}
                }
                }}}
        return legalMoves;


}}


