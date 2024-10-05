package smket.textmarkierung_pt.model;

import jakarta.persistence.*;

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

    @OneToMany (mappedBy = "aufgabeLehr", cascade = CascadeType.ALL)
    private List<LoesungStud> loesungStud;
}
