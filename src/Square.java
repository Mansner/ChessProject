import java.awt.*;
import javax.swing.*;

public class Square extends JButton {

    public int i;
    public int j;

    public Square(int i, int j) {
        this.i = i;
        this.j = j;

        setFont(new Font("Arial", Font.PLAIN, 50));

        setVisible(true);
    }

}
