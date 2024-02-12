package src;
import src.biler.Bil;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Reservasjon {

        private int id;
        private Kontor utleiekontor;
        private Bil bil;
        private Kunde kunde;
        private LocalDate leieStartDato;
        private LocalDate leieSluttDato;
        private int antallDager;
        private int antallDagerLaant;
        private boolean aktiv;

        // Teller for ID
        private static int teller = 1;

        /**
         * Constructor to create a reservation.
         *
         * @param utleiekontor The rental office for the reservation.
         * @param bil          The car being reserved.
         * @param kunde        The customer making the reservation.
         * @param leieDato     The rental date for the reservation.
         * @param antallDager  The number of rental days for the reservation.
         */
        public Reservasjon(Kontor utleiekontor, Bil bil, Kunde kunde, LocalDate leieStartDato, int antallDager) {
            this.id = teller++;
            this.utleiekontor = utleiekontor;
            this.bil = bil;
            this.kunde = kunde;
            this.leieStartDato = leieStartDato;
            this.leieSluttDato = leieStartDato.plusDays(antallDager);
            this.aktiv = true;
            this.antallDagerLaant = 0;
        }

        /*
         * Regner ut antall km kjørt, setter bilen ledig
         */
        public void avsluttReservasjon(LocalDate returDato) {
            this.leieSluttDato = returDato;
            this.bil.setLedig();
            this.antallDagerLaant = (int)ChronoUnit.DAYS.between(leieSluttDato, returDato);
            if(antallDagerLaant > antallDager) System.out.println("Lån av bil overskred opprinnelig avtalt dager");
            this.aktiv = false;
            utleiekontor.avsluttUtleie(this);
        }


        // Getters and setters...
        public Reservasjon getReservasjon() {
            return this;
        }

        public boolean getStatus() {
            return this.aktiv;
        }


        public Kontor getUtleiekontor() {
            return utleiekontor;
        }

        public Bil getBil() {
            return bil;
        }

        public Kunde getKunde() {
            return kunde;
        }

        public LocalDate getLeieStartDato() {
            return leieStartDato;
        }

        public LocalDate getLeieSluttDato() {
            return leieSluttDato;
        }

        public int getAntallDager() {
            return antallDager;
        }


        public int getID() {
            return this.id;
        }

    }
