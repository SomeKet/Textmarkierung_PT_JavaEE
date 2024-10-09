package smket.textmarkierung_pt.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import smket.textmarkierung_pt.model.AufgabeLehrend;
import smket.textmarkierung_pt.model.Kategorie;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AufgabeLehrendRepoTest {

    private static AufgabeLehrendRepo repo;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        repo = new AufgabeLehrendRepo("persistence_test");
    }

    @Test
    void addAufgabe() {
        //Arrange
        AufgabeLehrend aufgabe = new AufgabeLehrend();
        aufgabe.setAufgabe("Markiere das Substantiv im folgenden Satz. 'Die Sonne strahlt.'");
        aufgabe.setLoesung("Die []Sonne] strahlt.");

        //Act
        repo.addAufgabe(aufgabe);

        //Assert
        assertNotNull(aufgabe);
        assertEquals(1L, aufgabe.getaId());
    }

    @Test
    void addAufgabeMitKategorie(){
        //Arrange
        AufgabeLehrend aufgabe = new AufgabeLehrend();
        aufgabe.setAufgabe("Markiere das Substantiv im folgenden Satz. 'Die Sonne strahlt.'");
        aufgabe.setLoesung("Die []Sonne] strahlt.");
        Kategorie kategorie = new Kategorie("Name", "na", "red");
        List<Kategorie> kategorien = new ArrayList<Kategorie>();
        kategorien.add(kategorie);
        aufgabe.setKategorie(kategorien);

        //Act
        repo.addAufgabe(aufgabe);

        //Assert
        assertNotNull(aufgabe);
        assertEquals(1, aufgabe.getKategorien().size());
        assertEquals("Name", aufgabe.getKategorien().get(0).getBezeichnung());
    }

    @Test
    void findAufgabe() {
        //Arrange
        AufgabeLehrend aufgabe = new AufgabeLehrend();
        aufgabe.setAufgabe("Markiere das Substantiv im folgenden Satz. 'Die Sonne strahlt.'");
        aufgabe.setLoesung("Die []Sonne] strahlt.");
        repo.addAufgabe(aufgabe);

        //Act
        AufgabeLehrend test = repo.findAufgabe(aufgabe.getaId());

        //Assert
        assertNotNull(test);
        assertEquals(1L, test.getaId());

    }

    @Test
    void updateAufgabe() {
        //Arrange
        String updateAufgabe = "Test updateAufgabe";
        String updateLoesung = "Test updateLoesung";
        AufgabeLehrend aufgabe = new AufgabeLehrend();
        aufgabe.setAufgabe("Markiere das Substantiv im folgenden Satz. 'Die Sonne strahlt.'");
        aufgabe.setLoesung("Die []Sonne] strahlt.");
        repo.addAufgabe(aufgabe);

        //Act
        aufgabe.setLoesung(updateLoesung);
        aufgabe.setAufgabe(updateAufgabe);
        repo.updateAufgabe(aufgabe);

        //Assert
        assertNotNull(aufgabe);
        assertEquals(updateLoesung, aufgabe.getLoesung());
        assertEquals(updateAufgabe, aufgabe.getAufgabe());


    }

    @Test
    void deleteAufgabe() {
        //Arrange
        AufgabeLehrend aufgabe = new AufgabeLehrend();
        aufgabe.setAufgabe("Markiere das Substantiv im folgenden Satz. 'Die Sonne strahlt.'");
        aufgabe.setLoesung("Die []Sonne] strahlt.");
        repo.addAufgabe(aufgabe);

        //Act
        repo.deleteAufgabe(aufgabe.getaId());

        //Assert
        assertNull(repo.findAufgabe(aufgabe.getaId()));

    }
}