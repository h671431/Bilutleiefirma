package src;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MainTest {

    private Adresse adresse;
    private Firma firma;


    @Before
    public void setUp() throws Exception {
        adresse = new Adresse("Testveien 1", "1234", "Testby");
        firma = new Firma("TestFirma", "12345678", adresse);
    }

    @Test
    public void testAdresseInstantiering() {
        assertEquals("Testveien 1", adresse.getGateadresse());
        assertEquals("1234", adresse.getPostnummer());
        assertEquals("Testby", adresse.getPoststed());
    }

    @Test
    public void testSetGateadresse() {
        adresse.setGateadresse("Nyveien 2");
        assertEquals("Nyveien 2", adresse.getGateadresse());
    }

    @Test
    public void testSetPostnummer() {
        adresse.setPostnummer("4321");
        assertEquals("4321", adresse.getPostnummer());
    }

    @Test
    public void testSetPoststed() {
        adresse.setPoststed("Nyby");
        assertEquals("Nyby", adresse.getPoststed());
    }

    @Test
    public void testToString() {
        String expected = "Testveien 1, 1234 Testby";
        assertEquals(expected, adresse.toString());
    }
    @Test
    public void testFirmaInstantiering() {
        assertEquals("TestFirma", firma.getNavn());
        assertEquals("12345678", firma.getTelefon());
        assertEquals(adresse, firma.getAdresse());
    }

    @Test
    public void testLeggTilUtleiekontor() {
        Kontor nyttKontor = new Kontor("TestKontor", "87654321", new Adresse("Kontorveien 2", "8765", "Kontorby"));
        firma.leggTilUtleiekontor(nyttKontor);
        List<Kontor> kontorListe = firma.getKontor();

        assertTrue(kontorListe.contains(nyttKontor));
    }
    @Test
    public void testSetNavn() {
        firma.setNavn("NyttFirmaNavn");
        assertEquals("NyttFirmaNavn", firma.getNavn());
    }
    @Test
    public void testSetTelefon() {
        firma.setTelefon("99887766");
        assertEquals("99887766", firma.getTelefon());
    }

    @Test
    public void testSetAdresse() {
        Adresse nyAdresse = new Adresse("NyFirmavei 3", "4321", "NyFirmaby");
        firma.setAdresse(nyAdresse);
        assertEquals(nyAdresse, firma.getAdresse());
    }








}
