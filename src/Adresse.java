package src;

public class Adresse {

        private String gateadresse;
        private String postnummer;
        private String poststed;

        /**
         * Constructor to create an address.
         *
         * @param gateadresse The street address.
         * @param postnummer  The postal code.
         * @param poststed    The city or town name.
         */
        public Adresse(String gateadresse, String postnummer, String poststed) {
            this.gateadresse = gateadresse;
            this.postnummer = postnummer;
            this.poststed = poststed;
        }

        // Getters and setters...
        public String getGateadresse() {
            return gateadresse;
        }

        public void setGateadresse(String gateadresse) {
            this.gateadresse = gateadresse;
        }

        public String getPostnummer() {
            return postnummer;
        }

        public void setPostnummer(String postnummer) {
            this.postnummer = postnummer;
        }

        public String getPoststed() {
            return poststed;
        }

        public void setPoststed(String poststed) {
            this.poststed = poststed;
        }

        //ikke skikkelig implementert, men funker for testing
        public String getAdresseListe() {
            return gateadresse + ", " + postnummer + " " + poststed;
        }

        @Override
        public String toString() {
            return gateadresse + ", " + postnummer + " " + poststed;
        }
    }