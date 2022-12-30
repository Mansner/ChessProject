import java.awt.*;
import java.util.Objects;
import javax.swing.*;
import javax.swing.ImageIcon;


public class Square extends JButton {



    private JLabel icon;
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

    public void setImage(String name) {
        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("img/"+ name +".png")));
        this.icon = new JLabel(img);
        this.add(this.icon);
    }

    public void removeImage() {
        this.remove(icon);



    }
}
