import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;



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
            if(list.size()==1){
                Onlyoption(i,j,x,y);
            }
        }
    }

    public void Onlyoption(int i, int j, int x, int y) {
        Piece status = game.getStatus(i, j);
        Piece statusTwo = game.getStatus(i+x, j+y);

        if(statusTwo!=null){
            board[i+x][j+y].removeImage();
        }

        board[i][j].removeImage();
        board[i+x][j+y].setImage(status.name);
        panel.revalidate();
        panel.repaint();


        String message = "Do you want to do the automove?";
        int answer = JOptionPane.showConfirmDialog(panel, message);
        if (answer == JOptionPane.YES_OPTION) {
            board[i+x][j+y].removeImage();
            if(statusTwo!=null){
                board[i+x][j+y].setImage(statusTwo.name);
            }
            board[i][j].setImage(status.name);
            panel.revalidate();
            panel.repaint();

            game.drop(i+x, j+y);
            updateStatus();
            // User clicked YES.
        } else {
            board[i+x][j+y].removeImage();
            if(statusTwo!=null){
                board[i+x][j+y].setImage(statusTwo.name);
            }
            board[i][j].setImage(status.name);
            status=game.getStatus(i,j);
            status.removeAllMoves(); ////// NY, gör så att man kan trycka på samma pjäs flera ggr o få upp frågan yes no.
            colourBoard();
            panel.revalidate();
            panel.repaint();
            // User clicked NO.
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
                status.removeAllMoves();
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