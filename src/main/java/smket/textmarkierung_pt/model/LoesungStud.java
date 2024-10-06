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


    public LoesungStud(String loesung){
        this.loesung = loesung;
    }

    public LoesungStud() {
    }

    public long getId(){
        return this.lId;
    }

    public String getLoesung(){
        return this.loesung;
    }

    public void setLoesung(String loesung){
        this.loesung = loesung;
    }

    public AufgabeLehrend getAufgabeLehrend(){
        return this.aufgabeLehrend;
    }
}
