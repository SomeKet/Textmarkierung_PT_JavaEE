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
}
