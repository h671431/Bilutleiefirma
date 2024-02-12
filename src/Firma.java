package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Firma {

        private String navn;
        private String telefon;
        private Adresse adresse;
        private List<Kontor> kontor;

        /**
         *
         * @param navn
         * @param telefon
         * @param adresse
         */
        public Firma(String navn, String telefon, Adresse adresse) {
            this.navn = navn;
            this.telefon = telefon;
            this.adresse = adresse;
            this.kontor = new ArrayList<Kontor>();
        }


        public void leggTilUtleiekontor(Kontor kontorNy) {
            this.kontor.add(kontorNy);
        }

        /**
         * Opprettelse av kontor
         */
        public Kontor leggTilNyttKontor() {
            Scanner scanner = new Scanner(System.in);

            // Implementer logikken for å legge til et nytt kontor
            System.out.println("Skriv navn på kontor (eksempel 'Bergen' for kontor i Bergen):");
            String navn = scanner.nextLine();
            System.out.println("Skriv inn kontorets telefonnummer:");
            String telefon = scanner.nextLine();
            System.out.println("Skriv inn kontorets gateadresse:");
            String gateadresse = scanner.nextLine();
            System.out.println("Skriv inn kontorets postnummer:");
            String postnummer = scanner.nextLine();
            System.out.println("Skriv inn kontorets poststed:");
            String poststed = scanner.nextLine();

            scanner.close();
            Kontor kontorNy = new Kontor(navn, telefon, new Adresse(gateadresse, postnummer, poststed));
            leggTilUtleiekontor(kontorNy);

            System.out.println(kontor + "\nOpprettet!");
            return kontorNy;
        }

        public Firma getFirma() {
            return this;
        }

        @Override
        public String toString() {
            return "Firma: " + navn + ", Telefon: " + telefon + ", Adresse: " + adresse;
        }

        public String getNavn() {
            return navn;
        }

        public void setNavn(String navn) {
            this.navn = navn;
        }

        public String getTelefon() {
            return telefon;
        }

        public void setTelefon(String telefon) {
            this.telefon = telefon;
        }

        public Adresse getAdresse() {
            return adresse;
        }

        public void setAdresse(Adresse adresse) {
            this.adresse = adresse;
        }

        public List<Kontor> getKontor() {
            return kontor;
        }

        public void setKontor(List<Kontor> kontor) {
            this.kontor = kontor;
        }


    }

