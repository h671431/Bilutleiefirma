package src;

public class Kunde {

        private String fornavn;
        private String etternavn;
        private String adresse;
        private String telefon;

        /**
         * Constructor to create a customer.
         *
         * @param fornavn   The first name of the customer.
         * @param etternavn The last name of the customer.
         * @param adresse   The address of the customer.
         * @param telefon   The phone number of the customer.
         */
        public Kunde(String fornavn, String etternavn, String adresse, String telefon) {
            this.fornavn = fornavn;
            this.etternavn = etternavn;
            this.adresse = adresse;
            this.telefon = telefon;
        }

        // Getters and setters...

        @Override
        public String toString() {
            return "Kunde: " + fornavn + " " + etternavn + ", Adresse: " + adresse + ", Telefon: " + telefon;
        }

        public String getFornavn() {
            return fornavn;
        }

        public void setFornavn(String fornavn) {
            this.fornavn = fornavn;
        }

        public String getEtternavn() {
            return etternavn;
        }

        public void setEtternavn(String etternavn) {
            this.etternavn = etternavn;
        }

        public String getTelefon() {
            return telefon;
        }

        public void setTelefon(String telefon) {
            this.telefon = telefon;
        }

        //ikke riktig, men for testing.
        public String getAlleKunder() {
            return fornavn + " " + etternavn + ", tlf: " + telefon;
        }
    }
