package smket.textmarkierung_pt.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import smket.textmarkierung_pt.model.AufgabeLehrend;
import smket.textmarkierung_pt.model.Kategorie;
import smket.textmarkierung_pt.model.LoesungStud;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoesungStudRepoTest {

    AufgabeLehrendRepo aufgabeRepo;
    LoesungStudRepo repo;



    @BeforeEach
    void setUp() {
        repo = new LoesungStudRepo("persistence_test");
        aufgabeRepo = new AufgabeLehrendRepo("persistence_test");
    }

    @Test
    void addloesung() {
        //Arrange
        Kategorie k1 = new Kategorie("Bez", "Tag", "Far");
        Kategorie k2 = new Kategorie("Bez", "Tag", "Far");
        List<Kategorie> kategorien = new ArrayList<>();
        kategorien.add(k1);
        kategorien.add(k2);
        AufgabeLehrend test = new AufgabeLehrend("Aufgabe", "Lösung", kategorien);
        aufgabeRepo.addAufgabe(test);

        LoesungStud loesung = new LoesungStud("Lösung", test);

        //Act
        repo.addloesung(loesung);

        //Assert
        assertEquals(1L, loesung.getlId());
        assertEquals(loesung.getAufgabeLehrend().getaId(), test.getaId());

    }

    @Test
    void findloesung() {
        //Arrange
        Kategorie k1 = new Kategorie("Bez", "Tag", "Far");
        Kategorie k2 = new Kategorie("Bez", "Tag", "Far");
        List<Kategorie> kategorien = new ArrayList<>();
        kategorien.add(k1);
        kategorien.add(k2);
        AufgabeLehrend test = new AufgabeLehrend("Aufgabe", "Lösung", kategorien);
        aufgabeRepo.addAufgabe(test);

        LoesungStud loesung = new LoesungStud("Lösung", test);
        repo.addloesung(loesung);

        //Act
        LoesungStud response = repo.findloesung(1L);

        //Assert
        assertEquals(1L, response.getlId());
        assertNotNull(response);

    }

    @Test
    void updateloesung() {
    }

    @Test
    void deleteloesung() {
    }
}