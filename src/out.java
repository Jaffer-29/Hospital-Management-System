import javax.swing.*;

public class out {
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->{
            try {
              new LoginPage().setVisible(true);


 } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });    }
}
