package smket.textmarkierung_pt.model;

import jakarta.persistence.*;

@Entity
public class LoesungStud {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long lId;

    private String loesung;

    @ManyToOne
    @JoinColumn(name ="aufgabe_lehr_id", nullable = false)
    private AufgabeLehrend aufgabeLehrend;

    public AufgabeLehrend getAufgabeLehrend() {
        return aufgabeLehrend;
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
