package smket.textmarkierung_pt.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AufgabeLehrend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long aId;

    @Column(name="aufgabe")
    private String aufgabe;

    @Column(name="loesung")
    private String loesung;

    @OneToMany (mappedBy = "lId", cascade = CascadeType.ALL)
    private List<LoesungStud> loesungStud;

    @ElementCollection
    private List<Kategorie> kategorien = new ArrayList<Kategorie>();

    public AufgabeLehrend() {}

    public AufgabeLehrend(String aufgabe, String loesung, List<Kategorie> kategorien) {
        this.aufgabe = aufgabe;
        this.loesung = loesung;
        this.kategorien = kategorien;
    }

    public long getaId(){
        return this.aId;
    }

    public String getAufgabe() {
        return aufgabe;
    }

    public void setAufgabe(String aufgabe) {
        this.aufgabe = aufgabe;
    }

    public String getLoesung() {
        return loesung;
    }

    public void setLoesung(String loesung) {
        this.loesung = loesung;
    }

    public List<LoesungStud> getLoesungStud() {
        return loesungStud;
    }

    public void setLoesungStud(List<LoesungStud> loesungStud) {
        this.loesungStud = loesungStud;
    }

    public List<Kategorie> getKategorien() {
        return kategorien;
    }

    public void setKategorie(List<Kategorie> kategorien) {
        this.kategorien = kategorien;
    }
}
