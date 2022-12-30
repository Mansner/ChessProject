import java.awt.event.MouseEvent;

public interface Boardgame {

    public boolean move(int x, int y);

    public boolean drop(int x, int y);

    public Piece getStatus(int x, int y);

    public String getMessage();

}
