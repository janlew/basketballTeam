import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Parser parser = new Parser("src/main/resources/team.xml");
            parser.read("//druzyna/zawodnicy");

            Scanner scanner = new Scanner(System.in);
            boolean q = false;
            int a;
            menu();
            String imie, nazwisko, poz, wzrost, nr, pochodzenie, oldNum, newNum, sciezka;

            while (q != true) {
                a = scanner.nextInt();
                scanner.nextLine();
                switch (a) {
                    case 1:
                        System.out.println("Podaj imie: ");
                        imie = scanner.next();
                        System.out.println("Podaj nazwisko: ");
                        nazwisko = scanner.next();
                        System.out.println("Podaj pozycje");
                        poz = scanner.next();
                        System.out.println("Podaj wzrost");
                        wzrost = scanner.next();
                        System.out.println("Podaj nr");
                        nr = scanner.next();
                        System.out.println("Podaj pochodzenie");
                        pochodzenie = scanner.next();
                        parser.createPlayer(imie, nazwisko, poz, wzrost, nr, pochodzenie);
                        break;
                    case 2:
                        System.out.println("Podaj stary nr: ");
                        oldNum = scanner.next();
                        System.out.println("Podaj nowy nr: ");
                        newNum = scanner.next();
                        parser.updatePlayer(oldNum, newNum);
                        break;
                    case 3:
                        System.out.println("Podaj sciezke elementu do usuniecia: ( //druzyna/zawodnicy/zawodnik[numer='8'] )");
                        sciezka = scanner.next();
                        parser.delete(sciezka);
                        break;
                    case 4:
                        parser.sort("//druzyna/zawodnicy/zawodnik");
                        break;
                    case 5:
                        System.out.println("Podaj sciezke do elementow do wyswietlenia: ( //druzyna/wlasciciel )");
                        sciezka = scanner.next();
                        parser.read(sciezka);
                        break;
                    case 6:
                        menu();
                        break;
                    case 7:
                        q = true;
                        break;
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void menu() {
        System.out.println("Menu:\n" +
                "1 - dodaj zawodnika\n" +
                "2 - edytuj numer zawodnika\n" +
                "3 - usun\n" +
                "4 - wyswietl posortowanych zawodnikow\n" +
                "5 - wyswietl XML\n" +
                "6 - wyswietl menu\n" +
                "7 - wyjdz");
    }
}