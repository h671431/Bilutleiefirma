package src;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import src.biler.Bil;
public class Kontor {

        private String navn;
        private String telefon;
        private Adresse adresse;
        private int kontorNummer;
        private List<Bil> bilerTilgjengelig; //Her ligger all biler tilgjenlig nå
        private List<Reservasjon> alleReservasjoner; //Her ligger biler som er foreløpig utleid
        private List<Utleie> utleier;

        //Teller for kontor ID
        private static int teller = 1;

        /**
         * Constructor to create an office.
         *
         * @param navn    The name of the office.
         * @param telefon The phone number of the office.
         * @param adresse The address of the office.
         */
        public Kontor(String navn, String telefon, Adresse adresse) {
            this.navn = navn;
            this.telefon = telefon;
            this.adresse = adresse;
            this.kontorNummer = teller++;
            this.bilerTilgjengelig = new ArrayList<>();
            this.alleReservasjoner = new ArrayList<>();
            this.utleier = new ArrayList<>();
        }


        public void opprettUtleie(Reservasjon reservasjon, Bil bil) {
            if (reserverBil(bil)) {
                Utleie utleie = new Utleie(reservasjon);
                utleier.add(utleie);
                alleReservasjoner.add(reservasjon);
                System.out.println("Reservasjon med ID: " + reservasjon.getID() + " er opprettet for kunde: " + reservasjon.getKunde().toString());
            }
        }

        public void avsluttUtleie(Reservasjon reservasjon) {
            bilerTilgjengelig.add(reservasjon.getBil());

            alleReservasjoner.remove(reservasjon);
            utleier.remove(finnUtleie(reservasjon.getID()));
            double regning = finnUtleie(reservasjon.getID()).sendRegning();
            System.out.println("Kunde: " + reservasjon.getKunde().getFornavn() + " " + reservasjon.getKunde().getEtternavn() + " får regnig på kr: " + regning);
        }


        public Utleie finnUtleie(int id) {
            return utleier.stream().filter(u -> u.getID() == id).findFirst().orElse(null);
        }


        public boolean reserverBil(Bil bil) {
            if (bil.erLedig()) {
                bil.setOpptatt();
                bilerTilgjengelig.remove(bil);
                return true;
            }
            return false;
        }

        public Reservasjon finnReservasjon(int reservasjonID) {
            return alleReservasjoner.stream()
                    .filter(reservasjon -> reservasjon.getID() == reservasjonID)
                    .findFirst()
                    .orElse(null);
        }


        public List<Bil> finnBilerFra(LocalDate dato) {

            List<Bil> tilgjengeligeBiler = new ArrayList<>(bilerTilgjengelig); // Starter med alle biler som grunnlag


            // Legger til biler som blir tilgjengelige etter den angitte datoen, basert på sluttdatoer for reservasjoner
            for (Reservasjon reservasjon : alleReservasjoner) {
                if (reservasjon.getLeieSluttDato().isBefore(dato) || reservasjon.getLeieSluttDato().isEqual(dato)) {
                    tilgjengeligeBiler.add(reservasjon.getBil());
                }
            }
            return tilgjengeligeBiler;
        }


        // Getters and setters...

        public void leggTilBil(Bil bil) {
            bilerTilgjengelig.add(bil);
        }

        @Override
        public String toString() {
            return "Kontor " + kontorNummer + ": " + navn + ", Telefon: " + telefon + ", Adresse: " + adresse;
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

        public int getKontorNummer() {
            return this.kontorNummer;
        }

        public List<Bil> getBilerTilgjengelig() {
            return bilerTilgjengelig;
        }


        public void visAlleBiler() {
            System.out.println("Ledige biler: ");
            for (Bil bil : bilerTilgjengelig) {
                System.out.println(bil); // bruker toString fra Bil.class
            }

            System.out.println("\nReserverte biler: ");
            for (Reservasjon reservation : alleReservasjoner) {
                System.out.println(reservation.getBil());
            }
        }

    }