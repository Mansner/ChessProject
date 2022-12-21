import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ViewControl extends JFrame implements ActionListener {

    private int n;
    private Square[][] board;
    private JLabel message = new JLabel();
    private JPanel panel = new JPanel();
    private Chess game;



    public static void main(String[] args) {
        Chess game = new Chess();
        new ViewControl(game, 8);
        //tjo
    }

    ViewControl(Chess gm, int n) {
        this.game = gm;
        this.n = n;

        setSize(700, 700);

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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("tjockis");
                Square sq = new Square(i, j, Color.black);
                sq.setBorderPainted(false);
                sq.setOpaque(true);

                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        sq.setBackground(Color.LIGHT_GRAY);
                    } else {
                        sq.setBackground(Color.DARK_GRAY);
                        ;
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
                sq.setBounds(j * 60 + 60, i * 60 + 60, 60, 60);
                board[i][j] = sq;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (e.getSource() == board[i][j]) {
                    Square sq = board[i][j];
                    game.move(sq.i, sq.j);
                    updateStatus();
                    updateMessage();
                }

            }

        }

    }

    void updateStatus() {
        String status;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                status = game.getStatus(i, j);
                board[i][j].setText(status);
            }
        }
    }

    void updateMessage() {
        String mess = game.getMessage();
        message.setText(mess);
    }


    void setBtnListeners() {
        Square square;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                square = board[i][j];
                square.addActionListener(this);
            }
        }
    }

}