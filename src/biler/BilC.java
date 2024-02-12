package src.biler;

public class BilC extends Bil{


        private double pris;

        public BilC(String registreringsnummer, String merke, String modell, String farge) {
            super(registreringsnummer, merke, modell, farge);
            this.pris = 10_000;

        }

        @Override
        public double hentPris() {

            return this.pris;
        }
    }
