package src.biler;

public class BilA extends Bil{


        private double pris;

        public BilA(String registreringsnummer, String merke, String modell, String farge) {
            super(registreringsnummer, merke, modell, farge);
            this.pris = 10_000;

        }

        @Override
        public double hentPris() {

            return this.pris;
        }


    }
