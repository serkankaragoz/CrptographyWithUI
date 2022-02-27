import javax.swing.*;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//çalışılan işletim sisteminin arayüzünü kullanmamızı sağlayan komut

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                form f = new form();
                f.setVisible(true);
            }
        });
    }
}
