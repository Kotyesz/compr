import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gui extends JFrame {
    JFrame mainFrame;
    JTextArea field1,field2;
    JLabel output;
    JPanel panel;

    void compare(){
        char
                text1[]= field1.getText().toCharArray(),
                text2[]= field2.getText().toCharArray();
        String outputstr = "<html>";
        for (int i = 0; i < (text1.length > text2.length ? text1.length : text2.length); i++)
            if(text1.length > i && text2.length > i){
                if(text2[i] == ' ')
                    outputstr+=" &zwnj;";
                else if(text2[i] == '\n')
                    outputstr+="<br/>";
                else if(text2[i] == '\t')
                    for (int j = 0; j < 16; j++) outputstr+=" &zwnj;";
                else
                    outputstr += text1[i] == text2[i] ? String.format("<font color='#0cf'>%c</font>",text2[i]) : String.format("<font color='#f30'>%c</font>",text2[i]) ;
            }
        outputstr += "</html>";
        output.setText(outputstr);
    }

    Gui(){
        mainFrame = new JFrame("CompR");
        field1 = new JTextArea();
        field2 = new JTextArea();
        output = new JLabel();
        panel = new JPanel();

        panel.setLayout(new GridLayout(1,3));
        panel.setSize(1200,400);

        mainFrame.setSize(1200,500);
        field1.setSize(400,400);
        field2.setSize(400,400);
        output.setSize(400,400);

        output.setVerticalAlignment(JLabel.TOP);

        mainFrame.add(panel);

        panel.add(field1);
        panel.add(field2);
        panel.add(output);
        panel.setBackground(new Color(0,0,0));
        field2.setBackground(new Color(32,32,32));
        field2.setForeground(new Color(255,255,255));
        field1.setBackground(new Color(64,64,64));
        field1.setForeground(new Color(255,255,255));

        field1.addKeyListener(new KeyListener() {
            @Override public void keyTyped(KeyEvent e) {}
            @Override public void keyReleased(KeyEvent e) {compare();}
            @Override public void keyPressed(KeyEvent e) {}

        });

        field2.addKeyListener(new KeyListener() {
            @Override public void keyTyped(KeyEvent e) {}
            @Override public void keyReleased(KeyEvent e) {compare();}
            @Override public void keyPressed(KeyEvent e) {}

        });

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

    }
}
