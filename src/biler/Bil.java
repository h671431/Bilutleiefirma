package src.biler;

public abstract class Bil {

        private String registreringsnummer;
        private String merke;
        private String modell;
        private String farge;
        private boolean ledig;
        private int KM;

        /**
         *
         * @param registreringsnummer
         * @param merke
         * @param modell
         * @param farge
         * @param gruppe
         */
        public Bil(String registreringsnummer, String merke, String modell, String farge) {
            this.registreringsnummer = registreringsnummer;
            this.merke = merke;
            this.modell = modell;
            this.farge = farge;
            this.ledig = true;
            this.KM = 0;
        }

    //Denne som skiller bilgruppene
    public double hentPris() {
        return 0;
    }

    public String getRegistreringsnummer() {
            return registreringsnummer;
        }

        public void setRegistreringsnummer(String registreringsnummer) {
            this.registreringsnummer = registreringsnummer;
        }

        public String getMerke() {
            return merke;
        }

        public void setMerke(String merke) {
            this.merke = merke;
        }

        public String getModell() {
            return modell;
        }

        public void setModell(String modell) {
            this.modell = modell;
        }

        public String getFarge() {
            return farge;
        }

        public void setFarge(String farge) {
            this.farge = farge;
        }

        public boolean erLedig() {
            return ledig;
        }

        public void setLedig() {
            this.ledig = true;
        }
        public void setOpptatt() {
            this.ledig = false;
        }

        public int getKM() {
            return KM;
        }

        public void setKM(int kM) {
            KM = kM;
        }

        @Override
        public String toString() {
            return "Bil [registreringsnummer=" + registreringsnummer + ", merke=" + merke + ", modell=" + modell
                    + ", farge=" + farge + ", ledig=" + ledig + ", KM=" + KM + "]";
        }


    }
