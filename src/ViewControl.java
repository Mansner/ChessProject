import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.Icon;


class ViewControl extends JFrame implements ActionListener {

    private Boardgame game;
    private int n;
    private Square[][] board;
    private JLabel message = new JLabel();
    private JPanel panel = new JPanel();
    int xMove =-1;
    int yMove=-1;
    private AbstractButton chessPanel;
    private boolean[][] checkImg;

    public static void main(String[] u) {
        Boardgame game = new Chess();
        new ViewControl(game, 8);
        //tjo
    }
    ViewControl (Boardgame gm, int n) {
        this.game = gm;
        this.n = n;

        setSize(800, 800);

        panel.setLayout(null);
        add(panel);

        createButtons();
        updateStatus();


        message.setBounds(100, 50, 1000, 60);
        message.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(message);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void createButtons() {
        board = new Square[n][n];
        checkImg = new boolean[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                Square sq = new Square(i, j);
                sq.setBorderPainted(false);
                sq.setOpaque(true);

                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        sq.setBackground(Color.LIGHT_GRAY);
                    } else {
                        sq.setBackground(Color.DARK_GRAY);

                    }
                } else if (i % 2 == 1) {
                    if (j % 2 == 0) {
                        sq.setBackground(Color.DARK_GRAY);
                    } else {
                        sq.setBackground(Color.LIGHT_GRAY);
                    }
                }

                sq.addActionListener(this);
                panel.add(sq);
                sq.setBounds(j*100+100, i*100+100, 100, 100);
                board[i][j] = sq;
                checkImg[i][j]=false;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (e.getSource() == board[i][j]) {
                    Square sq = board[i][j];

                    if(game.move(sq.i, sq.j)) {
                        xMove = sq.i;
                        yMove = sq.i;
                        continue;
                    }
                    if(game.drop(sq.i, sq.j)){
                        updateStatus();
                    }






                }

                }
        }
    }

    void updateStatus() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                Piece status = game.getStatus(i, j);
                if (status == null) {
                    if (checkImg[i][j]) {
                        board[i][j].removeImage();
                        checkImg[i][j] = false;
                    }
                    continue;
                }
                board[i][j].setImage(status.name);
                checkImg[i][j] = true;
            }
        }
}

    void updateMessage() {
        String mess = game.getMessage();
        message.setText(mess);
    }

    public void initBoard() {
        System.out.println("initboard");
    }



}