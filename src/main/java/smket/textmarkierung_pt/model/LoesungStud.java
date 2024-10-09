package smket.textmarkierung_pt.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class LoesungStud {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long lId;

    @Column(name="loesung")
    private String loesung;

    @ManyToOne
    @JoinColumn(name ="aufgabe_lehr_id", nullable = false)
    private AufgabeLehrend aufgabeLehrend;

    public LoesungStud(String loesung, AufgabeLehrend aufgabeLehrend) {
        this.loesung = loesung;
        this.aufgabeLehrend = aufgabeLehrend;
    }
    public LoesungStud() {}


    public AufgabeLehrend getAufgabeLehrend() {
        return aufgabeLehrend;
    }

    public void setAufgabeLehrend(AufgabeLehrend aufgabeLehrend){
        this.aufgabeLehrend = aufgabeLehrend;
    }

    public String getLoesung() {
        return loesung;
    }

    public void setLoesung(String loesung) {
        this.loesung = loesung;
    }

    public long getlId() {
        return lId;
    }


}
