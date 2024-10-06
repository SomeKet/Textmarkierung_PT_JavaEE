package smket.textmarkierung_pt.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class AufgabeLehrend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long aId;

    @Column(name="aufgabe", nullable=false)
    private String aufgabe;

    @Column(name="loesung", nullable=false)
    private String loesung;

    @OneToMany (mappedBy = "aufgabeLehr", cascade = CascadeType.ALL)
    private List<LoesungStud> loesungStud;

    public AufgabeLehrend() {}

    public AufgabeLehrend(String aufgabe, String loesung) {
        this.aufgabe = aufgabe;
        this.loesung = loesung;
    }

    public long getaId(){
        return aId;
    }
    public String getAufgabe(){
        return aufgabe;
    }

    public String getLoesung(){
        return loesung;
    }
    public List<LoesungStud> getLoesungStud(){
        return loesungStud;
    }
    public void setAufgabe(String aufgabe){
        this.aufgabe = aufgabe;
    }
    public void setLoesung(String loesung){
        this.loesung = loesung;
    }
    public void setLoesungStud(List<LoesungStud> loesungStud){
        this.loesungStud = loesungStud;
    }

}
