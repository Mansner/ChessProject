import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;


public class Square extends JButton {

    public static Icon[] icons = {
            new ImageIcon("./img/pawn.png"),
            new ImageIcon("img/bpawn.png"),
            new ImageIcon("img/rook.png"),
            new ImageIcon("img/brook.png"),
            new ImageIcon("img/knight.png"),
            new ImageIcon("img/bknight.png"),
            new ImageIcon("img/bishop.png"),
            new ImageIcon("img/bbishop.png"),
            new ImageIcon("img/queen.png"),
            new ImageIcon("img/bqueen.png"),
            new ImageIcon("img/king.png"),
            new ImageIcon("img/bking.png")
    };
    public int i;

    public int j;
    private Color color;


    public Square(int i, int j) {
        this.i = i;
        this.j = j;

        setBorderPainted(true);
        setFont(new Font("Arial", Font.PLAIN, 50));

        setVisible(true);
    }

    public void setImage(int identifier) {
        this.setIcon(icons[1]);
    }
}
