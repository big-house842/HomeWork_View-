package View;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.GhostsDAO;
import Libs.Input;
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

        System.out.println("Write the atribute of the Ghost that you want to order the DB: ");
        System.out.print("      Atribute: ");
        String column = Input.LerString();

        GhostsDAO.OrderDB(column, listPhantom);

        System.out.println("------------------------------------------------");
        System.out.println("            The organized attributes            ");

        for (Ghost ph : listPhantom) {
            ph.PrintGhostWithID();
        }

    }

    private static void deleteGhostDB() {

        System.out.println("Write the atribute and the value of it to delete the Ghost that you want: ");
        System.out.print("      Atribute: ");
        String column = Input.LerString();
        System.out.print("      Value: ");
        int value = Input.LerNumero();

        GhostsDAO.DeleteDB(column, value);

    }

    private static void SearchDB() {

        System.out.println("Write the atribute and the value of it to search the Ghost that you want: ");
        System.out.print("      Atribute: ");
        String column = Input.LerString();
        System.out.print("      Value: ");
        int value = Input.LerNumero();

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

        System.out.println("How many Ghost do you want to insert? ");

        int x = Input.LerNumero();
        System.out.println();

        if (x == 1) {
            System.out.println("Write the name of the Ghost, the Strenght, and the size ");
        } else {
            System.out.println("Write the name of the Ghosts, the Strenghts, and the sizes of the them: ");
        }

        for (int i = 0; i < x; i++) {

            phantom.ReadGhostUser();
            phantomDAO.InsertGhostBD(phantom);

        }

        return phantomDAO;

    }

}
