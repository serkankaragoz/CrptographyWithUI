import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class form extends JFrame{
    private JPanel panel1;
    private JButton button1;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JFormattedTextField formattedTextField3;


    // removes characters that not inside of the alphabet
    public JFormattedTextField fixTitle(JFormattedTextField formattedTextField){

        String message = formattedTextField.getText();


        while(message.length() != 0){
            // iterates as long as there's non empty string on text field.
            // removes characters that alphabet doesn't contain


            formattedTextField.setText(message);


            if(message.length() != 0){
                char lastChar = message.charAt(message.length()-1);

                if(Cryptor.getAlphabet().indexOf(lastChar) != -1 || lastChar == ' '){
                    break;
                }

                else{
                    message = message.substring(0,message.length()-1);
                    formattedTextField.setText(message);
                }
            }

        }

        return formattedTextField;

    }

    public void setBoundsAtMiddle(int width, int height){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();



        int newX = (screenWidth - width)/2;
        int newY = (screenHeight - height)/2;

        setBounds(newX,newY,width,height);

    }



    public form(){


        ArrayList<Cryptor> options = new ArrayList<>();
        options.add(new Encryptor());
        options.add(new Decryptor());

        final int[] index = {0};


        add(panel1);

        setTitle("Encryptor and decryptor");
        
        setBoundsAtMiddle(600,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        button1.setText("Encryptor");


        formattedTextField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

                String message = formattedTextField1.getText();

                String key = formattedTextField2.getText();
                if(key.length() != 0){

                    String cipherText = options.get(index[0]).getCipherText(message,key);
                    formattedTextField3.setText(cipherText);
                }

            }


        });


        formattedTextField2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                char c = e.getKeyChar();

                if(Cryptor.getAlphabet().indexOf(c) == -1){
                    e.setKeyCode(0); // if a character that alphabet doesn't contain, removes it

                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

                // rempves the spaces since key can't contain space
                formattedTextField2.setText(formattedTextField2.getText().replace(" ",""));
                formattedTextField2 = fixTitle(formattedTextField2);

                String message = formattedTextField1.getText();
                String key = formattedTextField2.getText();

                // key can never be an empty string
                if(formattedTextField2.getText().length() != 0){
                    String cipherText = options.get(index[0]).getCipherText(message,key);
                    formattedTextField3.setText(cipherText);
                }

            }



        });


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index[0] +=1;
                if(index[0] >= options.size()){
                    index[0] = 0;
                    button1.setText("Encrypt");
                }
                else{
                    button1.setText("Decrypt");
                }

                String cipherText = formattedTextField3.getText();
                formattedTextField3.setText(formattedTextField1.getText());
                formattedTextField1.setText(cipherText);

            }
        });


    }

}
