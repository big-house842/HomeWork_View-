package Models;

import Libs.Input; 

public class Ghost {

    private String nameGhost;
    private int id, strength, size;
    
    public void ReadGhost(String a, int s1, int s2){

        this.nameGhost = a;
        this.strength = s1;
        this.size = s2;

    }

    public void ReadGhostWithID(int i, String a, int s1, int s2){

        this.id = i;
        this.nameGhost = a;
        this.strength = s1;
        this.size = s2;

    }

    public void ReadGhostUser(){
        System.out.println("------------------------------------------------");
        System.out.println("             ....::: Ghost :::....              ");
        System.out.println("------------------------------------------------");

        System.out.print("      Name: ");
        this.nameGhost = Input.LerString();
        System.out.print("      Strength: ");
        this.strength = Input.LerNumero();
        System.out.print("      Size: ");
        this.size = Input.LerNumero();
        System.out.println("------------------------------------------------");
        System.out.println();
    }

    public String ReadName(String a){
        return this.nameGhost = a;
    }

    public int ReadStrengh(int s1){
        return this.strength = s1;
    }

    public int ReadSize(int s2){
        return this.size = s2;
    }


    public String ReturnNameGhost(){
        return this.nameGhost;
    }

    public int ReturnStrength(){
        return this.strength;
    }

    public int ReturnSize(){
        return this.size;
    }

    public void PrintGhost(){

        System.out.print("   Name _ " + this.nameGhost + "   Strengh _ " + this.strength + "   Size _ " + this.size);
        System.out.println();

    }

    public void PrintGhostWithID(){

        System.out.println("------------------------------------------------");
        System.out.print( " |  Id _ " + this.id + "\n" + " |  Name _ " + this.nameGhost + "\n" + " |  Strengh _ " + this.strength + "\n" + " |  Size _ " + this.size + "\n");
        System.out.println("------------------------------------------------");
        System.out.println();

    }

}