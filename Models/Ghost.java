package Models;

import javax.swing.JOptionPane;

public class Ghost {

    private String nameGhost;
    private int id, strength, size;

    public void ReadGhost(String a, int s1, int s2) {

        this.nameGhost = a;
        this.strength = s1;
        this.size = s2;

    }

    public void ReadGhostWithID(int i, String a, int s1, int s2) {

        this.id = i;
        this.nameGhost = a;
        this.strength = s1;
        this.size = s2;

    }

    public void ReadGhostUser() {

        this.nameGhost = JOptionPane.showInputDialog(null, "Name: ", " Data Ghost ", JOptionPane.QUESTION_MESSAGE);
        this.strength = Integer.parseInt(JOptionPane.showInputDialog(null, "Strength: ", " Data Ghost ", JOptionPane.QUESTION_MESSAGE));
        this.size = Integer.parseInt(JOptionPane.showInputDialog(null, "Size: ", " Data Ghost ", JOptionPane.QUESTION_MESSAGE));

    }

    public String ReadName(String a) {
        return this.nameGhost = a;
    }

    public int ReadStrengh(int s1) {
        return this.strength = s1;
    }

    public int ReadSize(int s2) {
        return this.size = s2;
    }

    public String ReturnNameGhost() {
        return this.nameGhost;
    }

    public int ReturnStrength() {
        return this.strength;
    }

    public int ReturnSize() {
        return this.size;
    }

    public void PrintGhost() {

        String message = "   Name _ " + this.nameGhost + "   Strengh _ " + this.strength + "   Size _ " + this.size;

        JOptionPane.showMessageDialog(null, message);

    }

    public void PrintGhostWithID() {

        String message =
                "------------------------------------------------\n" +
                " |  Id _ " + this.id + "\n" + " |  Name _ " + this.nameGhost + "\n" + " |  Strengh _ " + this.strength + "\n" + " |  Size _ " + this.size + "\n" +
                "------------------------------------------------";

        JOptionPane.showMessageDialog(null, message);


    }

}