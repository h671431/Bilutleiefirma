package src;

import src.biler.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

        static Firma firma;
        static Kontor bergenKontor;
        static Kontor OsloKontor;

        public static void main(String[] args) {

            initFirma();
            opprettStartKontor();

            Kunde kunde1 = new Kunde("Maria", "Hansen", new Adresse("Slottsgave 23", "1500", "Oslo"), "69696969");
            Kunde kunde2 = new Kunde("Herman", "Hermansen", new Adresse("Mindeveien 75C", "5000", "Bergen"), "42069420");
            List<Kunde> kunder = new ArrayList<>();
            kunder.add(kunde1);
            kunder.add(kunde2);

            initRegistrering(kunder);


        }

        public static void initFirma() {
            Adresse adresse = new Adresse("Gateveien 1", "5000", "Bergen");
            firma = new Firma("HVL Bilutleie", "+47 96840284", adresse);
        }


        public static void opprettStartKontor() {

            Adresse adresse1 = new Adresse("Kalfaret 3", "5041", "Bergen");
            Adresse adresse2 = new Adresse("Lien 83", "1540", "Oslo");

            bergenKontor = new Kontor("Bergen Kontor", "55512345", adresse1);
            OsloKontor = new Kontor("Oslo Kontor", "94274820", adresse2);

            firma.leggTilUtleiekontor(bergenKontor);
            firma.leggTilUtleiekontor(OsloKontor);


            Bil bil1 = new BilA("AA12345", "Bugatti", "Bolide", "Grønn");
            Bil bil2 = new BilB("BA98363", "Porche", "Cayman", "Svart");

            Bil bil3 = new BilC("BD12349", "Mitsubichi", "Outlander", "Svart");
            Bil bil4 = new BilD("MN12349", "Toyota", "Avensis", "Blå");

            bergenKontor.leggTilBil(bil1);
            bergenKontor.leggTilBil(bil2);

            OsloKontor.leggTilBil(bil3);
            OsloKontor.leggTilBil(bil4);

        }

        public void opprettReservasjon() {

        }

    public static void initRegistrering(List<Kunde> kunder) {
        List<Kontor> kontor = firma.getKontor();

        Scanner scanner = new Scanner(System.in);

        for (Kunde kunde : kunder) {
            System.out.println("Velkommen til " + firma.getNavn() + "!");
            System.out.println("Du kan velge mellom følgende kontorer:");

            for (int i = 0; i < kontor.size(); i++) {
                System.out.println((i + 1) + ": " + kontor.get(i).getNavn());
            }

            System.out.println("Tast nummer for hvilket kontor du velger for å fortsette");
            int kontorValg = scanner.nextInt();

            if (kontorValg < 1 || kontorValg > kontor.size()) {
                System.out.println("Ugyldig kontornummer. Vennligst velg på nytt.");
                continue; // Gå til neste iterasjon av løkken
            }

            System.out.println("Tast inn nummer på det kontoret du ønsker å returnere din bil til:");
            for (int i = 0; i < kontor.size(); i++) {
                System.out.println((i + 1) + ": " + kontor.get(i).getNavn());
            }
            int returkontor = scanner.nextInt();

            System.out.println("Vennligst oppgi en dato i formatet ÅÅÅÅ-MM-DD (for eksempel 2024-12-24) for når du ønsker å leie:");
            String datoInput = scanner.next();
            LocalDate dato = LocalDate.parse(datoInput);

            System.out.println("Hvor mange dager ønsker du å leie bilen?");
            int antallDager = scanner.nextInt();

            List<Bil> ledigBiler = finnLedigBiler(dato, kontorValg);
            String bilerOgPris = "";
            for (int i = 0; i < ledigBiler.size(); i++) {
                Bil x = ledigBiler.get(i);
                bilerOgPris += "\n" + (i + 1) + x.toString() + ". Med en dagspris på: " + x.hentPris() + ". Totaltpris: " + antallDager * x.hentPris();
            }
            System.out.println("Velg en bil du ønsker: (Tast nummer til bilen)\n" + bilerOgPris);
            int bil = scanner.nextInt();

            Reservasjon reservasjon = new Reservasjon(firma.getKontor().get(kontorValg - 1), ledigBiler.get(bil - 1), kunde, dato, antallDager);
            System.out.println("Takk for din bestilling " + kunde.getFornavn() + " " + kunde.getEtternavn());
        }


        // Lukk Scanner etter at vi har lest inn verdier fra brukeren
        scanner.close();
    }


    private static List<Bil> finnLedigBiler(LocalDate dato, int kontor) {
            return firma.getKontor().get(kontor).finnBilerFra(dato);

        }

    }