import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;
import javax.swing.ImageIcon;


class ViewControl extends JFrame implements ActionListener {

    private Boardgame game;
    private int n;
    private Square[][] board;
    private JLabel message = new JLabel();
    private JPanel panel = new JPanel();
    private AbstractButton chessPanel;

    public static void main(String[] u) {
        Boardgame game = new Chess();
        new ViewControl(game, 8);
        //tjo
    }
    ViewControl (Boardgame gm, int n) {
        this.game = gm;
        this.n = n;

        setSize(750, 750);

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
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                Square sq = new Square(i, j);
                sq.setBorderPainted(false);
                sq.setOpaque(true);

                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        try {
                            ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("img/bishop.png")));
                            JLabel displayField = new JLabel(img);
                            sq.add(displayField);
                            System.out.println("hej");
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
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
                sq.setBounds(j*75+75, i*75+75, 75, 75);
                board[i][j] = sq;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (e.getSource() == board[i][j]) {
                    System.out.println(i);
                    Square sq = board[i][j];
                    game.move(sq.i, sq.j);
                    updateStatus();
                    updateMessage();
                }

                }

        }

    }

    void updateStatus() {
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            Piece status = game.getStatus(i, j);
            board[i][j].setImage(0);
        }
    }
}

    void updateMessage() {
        String mess = game.getMessage();
        message.setText(mess);
    }
    void paintBoard() {
        this.chessPanel.setLayout(new GridLayout(8, 8));
        Color black = new Color(190,97,78);
        Color white = new Color(255,255,255);
        Color c = black;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        c = white;
                    } else {
                        c = black;
                    }
                } else if (i % 2 == 1) {
                    if (j % 2 == 0) {
                        c = black;
                    } else {
                        c = white;
                    }
                }

                Square square = new Square(i, j);
                this.board[i][j] = square;
                this.chessPanel.add(square);

            }
        }}}