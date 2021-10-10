package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Dane {

    public String imie;
    public String nazwisko;
    public String numer;

    public Dane(String imie, String nazwisko, String numer) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numer = numer;
    }

    public Dane() {

    }

    public void informacje(){
        System.out.println("Imię: " + this.imie);
        System.out.println("Nazwisko: " + this.nazwisko);
        System.out.println("Numer: " + this.numer);
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }
}

    public class BiblNr {

        public static void edytowanie(int i, ArrayList<Dane> k) throws FileNotFoundException {
            int wybor = 0;
            int id = i;
            ArrayList<Dane> kontakty = k;
            Scanner sc = new Scanner(System.in);
            while(wybor != 4) {
                kontakty.get(id).informacje();
                System.out.println();
                System.out.println("Co chcesz zmienic?");
                System.out.println("1. Imie");
                System.out.println("2. Nazwisko");
                System.out.println("3. Numer");
                System.out.println("4. Wyjscie");
                wybor = sc.nextInt();
                sc.nextLine();

                switch(wybor) {
                    case 1:
                        System.out.print("Podaj nowe imie: ");
                        kontakty.get(id).setImie(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Podaj nowe nazwisko: ");
                        kontakty.get(id).setNazwisko(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Podaj nowy numer: ");
                        kontakty.get(id).setNumer(sc.nextLine());
                        break;
                    case 4:
                        break;
                }

                if(wybor != 4) {
                    PrintWriter out = new PrintWriter("Kontakty.txt");
                    for (Dane d: kontakty) {
                        out.println(d.getImie() + "\n" + d.getNazwisko() + "\n" + d.getNumer());
                    }
                    out.close();
                }

                if(wybor != 4) {
                    System.out.println("Dane zostały zaktualizowane");
                }
                System.out.println();

            }

        }

        public static void main(String[] args) throws IOException {
            ArrayList<Dane> kontakty = new ArrayList<>();
            File file = new File("Kontakty.txt");
            Scanner in = new Scanner(file);

            while(in.hasNext()){
                Dane tmp = new Dane();
                tmp.setImie(in.nextLine());
                tmp.setNazwisko(in.nextLine());
                tmp.setNumer(in.nextLine());
                kontakty.add(tmp);
            }

            edytowanie(1, kontakty);
            
        }
    }
