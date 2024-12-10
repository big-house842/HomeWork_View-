package View;

import javax.swing.JOptionPane;
import Models.*;

public class LerGhost {
    
    String name = JOptionPane.showInputDialog(null, "Name: ", "Data Ghost", JOptionPane.QUESTION_MESSAGE);
    int strength = Integer.parseInt(JOptionPane.showInputDialog(null, "Strength: ", "Data Ghost", JOptionPane.QUESTION_MESSAGE));

}
