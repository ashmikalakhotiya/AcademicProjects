package Business.Utils;

import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author CUTIE
 */
public class AddressVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        String pattern = "^([0-9]+ )?([a-zA-Z ]+)?([a-zA-Z0-9 ]+) ?(\\d{5})$";
        if (text.length() > 0) {
            if (text.toLowerCase().startsWith(" ") || text.length() == 0 || text.matches(pattern) != true) {
                input.setBackground(Color.blue);
                JOptionPane.showMessageDialog(input, "Please enter valid Address. Street no./House no. followed by Street name and zip code in the last", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                input.setBackground(Color.white);
                return true;
            }
        } else {
            input.setBackground(Color.white);
            return true;
        }
    }
}
