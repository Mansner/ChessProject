import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
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
        colourBoard();
        updateStatus();


        message.setBounds(100, 20, 1000, 60);
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
                sq.addActionListener(this);
                panel.add(sq);
                sq.setBounds(j*80+80, i*80+80, 80, 80);
                board[i][j] = sq;
                checkImg[i][j]=false;
            }
        }
    }

    void colourBoard() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        board[i][j].setBackground(Color.LIGHT_GRAY);
                    } else {
                        board[i][j].setBackground(Color.DARK_GRAY);
                    }
                } else if (i % 2 == 1) {
                    if (j % 2 == 0) {
                        board[i][j].setBackground(Color.DARK_GRAY);
                    } else {
                        board[i][j].setBackground(Color.LIGHT_GRAY);
                    }
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (e.getSource() == board[i][j]) {
                    Square sq = board[i][j];
                    if(game.move(sq.i, sq.j)) {
                        colourBoard();
                        updatePosPos(sq.i, sq.j);
                        updateMessage();
                        continue;
                    }
                    if(game.drop(sq.i, sq.j)){
                        updateStatus();
                        System.out.println("drop");
                        updateMessage();
                    }
                    updateMessage();
                }
            }
        }
    }

    void updatePosPos(int i, int j) {
        Piece status = game.getStatus(i, j);
        ArrayList<ArrayList<Integer>> list = status.sendLegalMoves();
        for (ArrayList<Integer> ele :list) { // iterate through all moves
            Integer x = ele.get(0);
            Integer y = ele.get(1);
            board[i+x][j+y].setBackground(Color.green);
        }
    }


        void updateStatus() {
        updateMessage();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                Piece status = game.getStatus(i, j);
                if (status == null) { // deletes the icon if there is no pice object there.
                    if (checkImg[i][j]) { // but only if there is an icon there.
                        board[i][j].removeImage();
                        checkImg[i][j] = false;
                    }
                    continue;
                }
                if(checkImg[i][j]){ //deletes all images (makes eating the opposite pices possible).
                    board[i][j].removeImage();
                    checkImg[i][j] = false;
                }
                if(!checkImg[i][j]){ //refresehs all the images.
                    board[i][j].setImage(status.name);
                    checkImg[i][j] = true;
                }
            }
        }
        colourBoard();
        panel.revalidate();
        panel.repaint();
    }

    void updateMessage() {
        String mess = game.getMessage();
        message.setText(mess);
    }

    public void initBoard() {
        System.out.println("initboard");
    }



}