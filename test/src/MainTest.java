package src;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

    private Adresse adresse;

    @Before
    public void setUp() throws Exception {
        adresse = new Adresse("Testveien 1", "1234", "Testby");
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
}
