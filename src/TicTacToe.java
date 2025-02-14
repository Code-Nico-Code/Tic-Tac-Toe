import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();

    // JPanel tp = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();

    JLabel tf = new JLabel();
    JButton[] buttons = new JButton[9];

    JButton reset = new JButton();
    boolean player1_turn;



    TicTacToe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);
        frame.getContentPane().setBackground(new Color(200, 200, 200));
        //frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Tic-Tac-Toe");
        frame.setLayout(new BorderLayout());

        textfield.setBackground(new Color(70, 70, 70));
        textfield.setForeground(new Color(255, 255, 255));
        textfield.setFont(new Font("MV Boli",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setVerticalAlignment(JLabel.CENTER);
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //title_panel.setBounds(0,100,1000,100);
        title_panel.add(tf, BorderLayout.NORTH);
        title_panel.add(textfield, BorderLayout.SOUTH);

        //tp.setLayout(new BorderLayout());
        //button_panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        //tp.setBounds(0,0,1000,100);


        tf.setBackground(new Color(70, 70, 70));
        tf.setForeground(new Color(255, 255, 255));
        tf.setFont(new Font("MV Boli",Font.BOLD,75));
        tf.setHorizontalAlignment(JLabel.CENTER);
        tf.setVerticalAlignment(JLabel.CENTER);
        tf.setOpaque(true);
        tf.setText("Tic-Tac-Toe");

        button_panel.setLayout(new GridLayout(3,3,10,10));
        button_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button_panel.setBackground(new Color(100, 100, 100));
        //button_panel.setBounds(0,200 ,1000, 300);

        reset.setFont(new Font("MV Boli",Font.BOLD,75));
        reset.setFocusable(false);
        reset.addActionListener(this);
        reset.setBackground(new Color(70,70,70));
        reset.setForeground(new Color(255, 255, 255));
        reset.setText("RESET");
        //reset.setBounds(0, 500, 1000,100 );
        reset.setVerticalTextPosition(JButton.CENTER);



        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(new Color(150,150,150));

        }

        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel,BorderLayout.CENTER);
        frame.add(reset,BorderLayout.SOUTH);
        // tp.add(tf);
        //title_panel.add(textfield);
        // frame.add(title_panel);
        //frame.add(button_panel);
        //frame.add(reset);
        //frame.add(tp);

        firstturn();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==reset){
            resetboard();

        }

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn)
                {
                    if (buttons[i].getText().equals(""))
                    {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        check();
                    }

                }
                else
                {
                    if (buttons[i].getText() == "")
                    {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();

                    }
                }
            }
        }
    }


    public void firstturn(){

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");

        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }

    }
    public void check(){
        if ((buttons[0].getText() == "X") &&
                (buttons[1].getText() == "X") &&
                (buttons[2].getText() == "X")
        ) {
            xwins(0, 1, 2);
        }
        if ((buttons[3].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[5].getText() == "X")
        ) {
            xwins(3, 4, 5);
        }
        if ((buttons[6].getText() == "X") &&
                (buttons[7].getText() == "X") &&
                (buttons[8].getText() == "X")
        ) {
            xwins(6, 7, 8);
        }
        if ((buttons[0].getText() == "X") &&
                (buttons[3].getText() == "X") &&
                (buttons[6].getText() == "X")
        ) {
            xwins(0, 3, 6);
        }
        if ((buttons[1].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[7].getText() == "X")
        ) {
            xwins(1, 4, 7);

        }
        if ((buttons[2].getText() == "X") &&
                (buttons[5].getText() == "X") &&
                (buttons[8].getText() == "X")
        ) {
            xwins(2, 5, 8);
        }
        if ((buttons[0].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[8].getText() == "X")
        ) {
            xwins(0, 4, 8);
        }
        if ((buttons[2].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[6].getText() == "X")
        ) {
            xwins(2, 4, 6);
        }
        if ((buttons[0].getText() == "O") &&
                (buttons[1].getText() == "O") &&
                (buttons[2].getText() == "O")
        ) {
            owins(0, 1, 2);
        }
        if ((buttons[3].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[5].getText() == "O")
        ) {
            owins(3, 4, 5);
        }
        if ((buttons[6].getText() == "O") &&
                (buttons[7].getText() == "O") &&
                (buttons[8].getText() == "O")
        ) {
            owins(6, 7, 8);
        }
        if ((buttons[0].getText() == "O") &&
                (buttons[3].getText() == "O") &&
                (buttons[6].getText() == "O")
        ) {
            owins(0, 3, 6);
        }
        if ((buttons[1].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[7].getText() == "O")
        ) {
            owins(1, 4, 7);

        }
        if ((buttons[2].getText() == "O") &&
                (buttons[5].getText() == "O") &&
                (buttons[8].getText() == "O")
        ) {
            owins(2, 5, 8);
        }
        if ((buttons[0].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[8].getText() == "O")
        ) {
            owins(0, 4, 8);
        }
        if ((buttons[2].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[6].getText() == "O")
        ) {
            owins(2, 4, 6);
        }

        //Checking for tie
        if(checkxwins()==true || checkowins()==true){

        }else {
            //check for draw condition
            boolean draw=true;
            for (int i=0;i<9;i++){
                if (buttons[i].getText()==""){
                    draw = false;
                    break;
                }
            }
            if(draw){
                tie();
            }
        }


    }


    public void xwins(int a,int b, int c ){


        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");



    }
    public void owins(int a,int b, int c ){

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");

    }



    public void resetboard() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
            buttons[i].setBackground(new Color(205, 180, 219));
        }
        firstturn();
    }
        public boolean checkxwins() {
            if ((buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")) ||
                    (buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")) ||
                    (buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")) ||
                    (buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")) ||
                    (buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")) ||
                    (buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")) ||
                    (buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")) ||
                    (buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X"))) {
                return true;
            }
            return false;
        }

    public boolean checkowins() {
        if ((buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")) ||
                (buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")) ||
                (buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")) ||
                (buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")) ||
                (buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")) ||
                (buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")) ||
                (buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")) ||
                (buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O"))) {
            return true;
        }
        return false;
    }

    public void tie(){

        for (int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("Tie");
    }
    }


