import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTackTo implements ActionListener {
    Random random = new Random();
    JFrame Frame = new JFrame();
    JPanel Title_Panel = new JPanel();
    JPanel Button_Panel = new JPanel();
    JLabel TextField = new JLabel();
    JButton[] Buttons = new JButton[9];
    boolean Player1_Turn;

    TicTackTo() {
        // Frame
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setSize(800, 800);
        Frame.getContentPane().setBackground(new Color(50, 50, 50));
        Frame.setLayout(new BorderLayout());
        Frame.setVisible(true);

        // text field
        TextField.setBackground(new Color(25, 25, 25));
        TextField.setForeground(new Color(25, 255, 0));
        TextField.setFont(new Font("Ink Free", Font.BOLD, 75));
        TextField.setHorizontalAlignment(JLabel.CENTER);
        TextField.setText("Tic-Tac-Toe");
        TextField.setOpaque(true);

        // Bnutton Panel
        Button_Panel.setLayout(new GridLayout(3, 3));
        Button_Panel.setBackground(new Color(150, 150, 150));

        // create 9 buttons using for loop
        for (int i = 0; i < 9; i++) {
            Buttons[i] = new JButton();
            // add buttons to the button_panel
            Button_Panel.add(Buttons[i]);
            // set font to buttons
            Buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            // display hover to false
            Buttons[i].setFocusable(false);
            // set ActionLisener
            Buttons[i].addActionListener(this);
        }

        // title panel
        Title_Panel.setLayout(new BorderLayout());
        Title_Panel.setBounds(0, 0, 800, 100);

        // add Text field to the panel
        Title_Panel.add(TextField);
        // add Title panel to the Frame
        Frame.add(Title_Panel, BorderLayout.NORTH);
        // add buttons to the Frame
        Frame.add(Button_Panel);

        FirstTurn();

    }

    public void FirstTurn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (random.nextInt(2) == 0) {
            Player1_Turn = true;
            TextField.setText("X Turn");
        } else {
            Player1_Turn = false;
            TextField.setText("O Turn");
        }
    }

    public void check() {

        if ((Buttons[0].getText() == "X") &&
                (Buttons[1].getText() == "X") &&
                (Buttons[2].getText() == "X")) {
            xWins(0, 1, 2);

        }

        if ((Buttons[3].getText() == "X") &&
                (Buttons[4].getText() == "X") &&
                (Buttons[5].getText() == "X")) {
            xWins(3, 4, 5);

        }

        if ((Buttons[6].getText() == "X") &&
                (Buttons[7].getText() == "X") &&
                (Buttons[8].getText() == "X")) {
            xWins(6, 7, 8);

        }

        if ((Buttons[0].getText() == "X") &&
                (Buttons[3].getText() == "X") &&
                (Buttons[6].getText() == "X")) {
            xWins(0, 3, 6);

        }

        if ((Buttons[1].getText() == "X") &&
                (Buttons[4].getText() == "X") &&
                (Buttons[7].getText() == "X")) {
            xWins(1, 4, 7);

        }

        if ((Buttons[2].getText() == "X") &&
                (Buttons[5].getText() == "X") &&
                (Buttons[8].getText() == "X")) {
            xWins(2, 5, 8);

        }

        if ((Buttons[0].getText() == "X") &&
                (Buttons[4].getText() == "X") &&
                (Buttons[8].getText() == "X")) {
            xWins(0, 4, 8);

        }

        if ((Buttons[2].getText() == "X") &&
                (Buttons[4].getText() == "X") &&
                (Buttons[6].getText() == "X")) {
            xWins(2, 4, 6);

        }
        // O

        if ((Buttons[0].getText() == "O") &&
                (Buttons[1].getText() == "O") &&
                (Buttons[2].getText() == "O")) {
            oWins(0, 1, 2);

        }

        if ((Buttons[3].getText() == "O") &&
                (Buttons[4].getText() == "O") &&
                (Buttons[5].getText() == "O")) {
            oWins(3, 4, 5);

        }

        if ((Buttons[6].getText() == "O") &&
                (Buttons[7].getText() == "O") &&
                (Buttons[8].getText() == "O")) {
            oWins(6, 7, 8);

        }

        if ((Buttons[0].getText() == "O") &&
                (Buttons[3].getText() == "O") &&
                (Buttons[6].getText() == "O")) {
            oWins(0, 3, 6);

        }

        if ((Buttons[1].getText() == "O") &&
                (Buttons[4].getText() == "O") &&
                (Buttons[7].getText() == "O")) {
            oWins(1, 4, 7);

        }

        if ((Buttons[2].getText() == "O") &&
                (Buttons[5].getText() == "O") &&
                (Buttons[8].getText() == "O")) {
            oWins(2, 5, 8);

        }

        if ((Buttons[0].getText() == "O") &&
                (Buttons[4].getText() == "O") &&
                (Buttons[8].getText() == "O")) {
            oWins(0, 4, 8);

        }

        if ((Buttons[2].getText() == "O") &&
                (Buttons[4].getText() == "O") &&
                (Buttons[6].getText() == "O")) {
            oWins(2, 4, 6);

        }

    }

    public void xWins(int a, int b, int c) {

        Buttons[a].setBackground(new Color(0, 255, 0));
        Buttons[b].setBackground(new Color(0, 255, 0));
        Buttons[c].setBackground(new Color(0, 255, 0));

        for (int i = 0; i < 9; i++) {
            Buttons[i].setEnabled(false);
        }
        TextField.setText("X wins");
    }

    public void oWins(int a, int b, int c) {
        Buttons[a].setBackground(new Color(0, 0, 255));
        Buttons[b].setBackground(new Color(0, 0, 255));
        Buttons[c].setBackground(new Color(0, 0, 255));

        for (int i = 0; i < 9; i++) {
            Buttons[i].setEnabled(false);
        }
        TextField.setText("0 wins");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == Buttons[i]) {
                if (Player1_Turn) {
                    if (Buttons[i].getText() == "") {
                        Buttons[i].setForeground(new Color(0, 0, 255));
                        Buttons[i].setText("X");
                        Player1_Turn = false;
                        TextField.setText("O Turn");
                        check();
                    }
                } else {
                    if (Buttons[i].getText() == "") {
                        Buttons[i].setForeground(new Color(255, 0, 0));
                        Buttons[i].setText("O");
                        Player1_Turn = true;
                        TextField.setText("X Turn");
                        check();

                    }
                }

            }

        }

    }
}
