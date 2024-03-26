import javax.swing.SwingUtilities;

public class driver {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new app();
            }
        });
    }
}