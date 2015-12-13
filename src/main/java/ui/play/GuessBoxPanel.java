package ui.play;

import controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * Created by asusss on 12.12.2015.
 */
public class GuessBoxPanel extends WordPanel {


    private char[] chars;
    private JPanel[] letters;
    private JPanel[] guessWord;
    private String word;
    private MouseListener[] letListeners;
    private int count;
    private String guessW;
    private JButton delete;


    public GuessBoxPanel(Dimension size) {
        setSize(size);
        setBackground(Color.WHITE);
        setLayout(null);

        word = GameController.game().getSession().getChosenWord();
        chars = new char[10];
        guessW = "";
        letListeners = new MouseListener[10];

        System.out.println(word);
        for (int i = 0; i < word.length(); i++) {
            chars[i] = word.charAt(i);
        }
        randomChars(word);
        shuffle(chars);
        letters = new JPanel[10];
        int x = 10;
        count = 0;
        for (int i = 0; i < letters.length; i++) {

            JPanel letter = new JPanel();

            JLabel lab = new JLabel(Character.toString(chars[i]));
            letter.add(lab);
            letter.setBounds(x, 60, 29, 30);
            letters[i] = letter;
            LetterListener ml = new LetterListener(i) {

                @Override
                public void mouseClicked(MouseEvent e) {

                    if (count < word.length()) {
                        System.out.println("xxx");
                        int index = this.getIndex();
                        JLabel lab = new JLabel(Character.toString(chars[index]));
                        guessW += Character.toString(chars[index]);
                        guessWord[count].removeAll();
                        guessWord[count].add(lab);
                        count++;

                    }

                    if (count == word.length()) {
                        // String guessW= guess.toString();
                        System.out.println(guessW);
                        System.out.println(word);
                        if (guessW.equals(word)) {
                            setBackground(Color.GREEN);
                        } else if (!guessW.equals(word)) {
                            setBackground(Color.RED);
                        }
                    }

                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            };
            letters[i].addMouseListener(ml);
            add(letters[i]);
            x += 34;
        }

        createDynamicLetters();
        delete = new JButton();
        delete.setText("D");
        add(delete);
        delete.setBounds(320,10,20,20);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guessW="";
                count=0;
                setBackground(Color.white);
                for(int i =0; i<word.length();i++)
                {
                    guessWord[i].removeAll();
                    repaint();
                }
            }
        });

    }

    public void randomChars(String word) {
        final String alphabet = "ABCDEFGHIJKLMNOPRSTUVWYZX";
        final int N = alphabet.length();
        Random r = new Random();

        for (int i = 0; i < 10 - word.length(); i++) {
            chars[word.length() + i] = alphabet.charAt(r.nextInt(N));
        }

    }

    public static void shuffle(char arr[]) {
        Random rand = new Random();
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < arr.length; i++) {
                int index = rand.nextInt(10);
                char temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    public void createDynamicLetters() {
        guessWord = new JPanel[word.length()];

        int x = (getWidth() - (34 * word.length() - 5)) / 2;
        for (int i = 0; i < guessWord.length; i++) {
            JPanel c = new JPanel();
            JLabel lab = new JLabel("_");
            c.add(lab);
            c.setBounds(x, 5, 29, 30);
            guessWord[i] = c;
            add(guessWord[i]);
            x += 34;
        }
    }

    private void mouseClicked(java.awt.event.MouseEvent evt) {
        System.out.println("ddddd");

        JLabel l = (JLabel) evt.getSource();
        JLabel lab = new JLabel(l.getText());
        guessWord[0].removeAll();
        guessWord[0].add(lab);


    }

}
