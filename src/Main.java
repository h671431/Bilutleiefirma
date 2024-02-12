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
            String innput = "";
            String kontorString = "";
            String velkommen = "Velkommen til " + firma.getNavn() + "!"
                    + "\nDu kan velge mellom våres " + firma.getKontor().size() + " kontorer: ";

            for (int i = 0; i < firma.getKontor().size(); i++) {
                kontorString += "\n" + (i + 1) + "-" + kontor.get(i).getNavn();
            }
            velkommen += kontorString + "\nTast nummer for hvilket kontor du velger";

            for (Kunde kunde : kunder) {
                System.out.println(velkommen);
                int kontorValg = scanner.nextInt();

                //registrere returkontor
                System.out.println("Tast inn nummer på det kontoret du ønsker å returnere din bil til: " + kontorString);
                int returkontor = scanner.nextInt();

                //Registrer dato for utleie
                System.out.println("Vennligst oppgi en dato i formatet ÅÅÅÅ-MM-DD for når du ønsker å leie bilen: ");
                String datoInput = scanner.next();
                LocalDate dato = LocalDate.parse(datoInput);

                //registrere antall dager
                System.out.println("Hvor mange dager ønsker du å leie bilen ?");
                int antallDager = scanner.nextInt();
                System.out.println(antallDager);


                //Liste ut alle tilgjengelige biler med pris
                List<Bil> ledigBiler = finnLedigBiler(dato, kontorValg);
                String bilerOgPris = "";
                for (int i = 0; i < ledigBiler.size(); i++) {
                    Bil x = ledigBiler.get(i);
                    bilerOgPris += "\n " + (i + 1) + x.toString() + ". Med en dagspris på: " + x.hentPris() + ". Totaltpris: " + antallDager * x.hentPris();
                }
                System.out.println("Velg bilen du ønsker: (Tast nummer til bilen) \n" + bilerOgPris);
                int bil = scanner.nextInt();

                Reservasjon reservasjon = new Reservasjon(firma.getKontor().get(kontorValg), ledigBiler.get(bil), kunde, dato, antallDager);
                System.out.println("Tusen takk for din bestilling hos oss, " + kunde.getFornavn() + " " + kunde.getEtternavn());
            }


        }

        private static List<Bil> finnLedigBiler(LocalDate dato, int kontor) {
            return firma.getKontor().get(kontor).finnBilerFra(dato);

        }

    }