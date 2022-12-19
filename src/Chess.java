public class Chess implements Boardgame {
    private final String[][] board = new String[8][8];

    @Override
    public boolean move(int x, int y) {
        return false;
    }

    @Override
    public boolean drop(int x, int y) {
        return false;
    }

    @Override
    public String getStatus(int x, int y) {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }


}
