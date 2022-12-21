public class Chess {
    Square[][] board = new Square[8][8];



    public boolean move(int x, int y) {
        return false;
    }


    public boolean drop(int x, int y) {
        return false;
    }

    public String getStatus(int x, int y) {
        return null;
    }

    public String getMessage() {
        return null;
    }

    public void initBoard() {
        this.board[0][2] = new Bishop(0, 2, false);
    } /// den här som jag inte fattar varför den är röd


    public Chess(){
        initBoard();
    }
}
