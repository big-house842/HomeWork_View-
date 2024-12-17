package View;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.GhostsDAO;
import Models.*;

public class Principal {

    public static void main(String[] args) {

        GhostsDAO phantomDAO = new GhostsDAO();
        while (true) {
            String message = 
                    "=============================================\n" +
                    "           MENU OF ITERATION                 \n" +
                    "=============================================\n" +
                    "    0 - Exit                                 \n" +
                    "    1 - Insert attributes in database        \n" +
                    "    2 - Take out attributes and insert on list of object\n" +
                    "    3 - Search the Ghost through the id      \n" +
                    "    4 - Delete a value of an attribute in the database\n" +
                    "    5 - Print the attributes of the database order decreasingly\n" +
                    "    6 - Count total of phantoms in the DB    \n" +
                    "=============================================";

            // Exibe a mensagem no JOptionPane
            JOptionPane.showMessageDialog(null, message);

            // Aqui você pode capturar a opção escolhida, por exemplo, com um
            // JOptionPane.showInputDialog
            String optionS = JOptionPane.showInputDialog("Choose an option:");

            // Exibe a opção escolhida (apenas para exemplo)
            JOptionPane.showMessageDialog(null, "You chose option: " + optionS);

            int option = Integer.parseInt(optionS);

            if (option == 0) {
                break;
            }
            switch (option) {
                case 1:
                    insertBD(phantomDAO);
                    break;

                case 2:
                    takeOutAndInsertList();
                    break;

                case 3:
                    SearchDB();
                    break;

                case 4:
                    deleteGhostDB();
                    break;

                case 5:
                    printOrderDB();
                    break;

                case 6:
                    countDB();// CERTO
                    break;

                case 7:
                    phantomWithMorePower();// CERTO
                    break;

            }

        }
    }

    private static void phantomWithMorePower() {
        GhostsDAO.MostStrengthGhost().PrintGhostWithID();
    }

    private static void countDB() {
        System.out.println(GhostsDAO.CountPhantomDB());
    }

    private static void printOrderDB() {

        ArrayList<Ghost> listPhantom = new ArrayList<>();

        String message = "Write the atribute of the Ghost that you want to order the DB: ";
        JOptionPane.showMessageDialog(null, message);

        String column = JOptionPane.showInputDialog("Atributte: ");

        GhostsDAO.OrderDB(column, listPhantom);

        String message2 = "------------------------------------------------" +
                    "            The organized attributes            " +
                    "------------------------------------------------";
        JOptionPane.showMessageDialog(null, message2);

        for (Ghost ph : listPhantom) {
            ph.PrintGhostWithID();
        }

    }

    private static void deleteGhostDB() {

        String message = "Write the atribute and the value of it to delete the Ghost that you want: ";
        JOptionPane.showMessageDialog(null, message);
        
        String column = JOptionPane.showInputDialog("Atributte: ");

        int value = Integer.parseInt(JOptionPane.showInputDialog("Value: "));

        GhostsDAO.DeleteDB(column, value);

    }

    private static void SearchDB() {

        String message = "Write the atribute and the value of it to search the Ghost that you want: ";
        JOptionPane.showMessageDialog(null, message);

        String column = JOptionPane.showInputDialog("Atributte: ");

        int value = Integer.parseInt(JOptionPane.showInputDialog("Value: "));

        Ghost phantom = GhostsDAO.SearchBD(column, value);

        System.out.println();
        System.out.println("    BOOOOOOO!!    ");

        phantom.PrintGhostWithID();

    }

    private static void takeOutAndInsertList() {
        ArrayList<Ghost> listPhantom = new ArrayList<>();

        GhostsDAO.TakeOutGhostsBD(listPhantom);

        for (Ghost ph : listPhantom) {
            ph.PrintGhostWithID();
        }

    }

    private static GhostsDAO insertBD(GhostsDAO phantomDAO) {

        Ghost phantom = new Ghost();

        String message = "How many Ghost do you want to insert? ";
        JOptionPane.showMessageDialog(null, message);

        int x = Integer.parseInt(JOptionPane.showInputDialog("How many? "));

        if (x == 1) {
            String message2 ="Write the name of the Ghost, the Strenght, and the size ";
            JOptionPane.showMessageDialog(null, message2);

        } else {
            String message3 = "Write the name of the Ghosts, the Strenghts, and the sizes of the them: ";
            JOptionPane.showMessageDialog(null, message3);
        }

        for (int i = 0; i < x; i++) {

            phantom.ReadGhostUser();
            phantomDAO.InsertGhostBD(phantom);

        }

        return phantomDAO;

    }

}
