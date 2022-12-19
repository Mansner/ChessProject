import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ViewControl extends JFrame implements ActionListener {

    private Boardgame game;
    private int n;
    private Square[][] board;
    private JLabel message = new JLabel();
    private JPanel panel = new JPanel();

    public static void main(String[] u) {
        Boardgame game = new Chess();
        new ViewControl(game, 3);
        //tjohh
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
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                Square sq = new Square(i, j);
                sq.addActionListener(this);
                panel.add(sq);
                sq.setBounds(j*100+100, i*100+100, 100, 100);
                board[i][j] = sq;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
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
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            status = game.getStatus(i, j);
            board[i][j].setText(status);
        }
    }
}

    void updateMessage() {
        String mess = game.getMessage();
        message.setText(mess);
    }

}
