package smket.textmarkierung_pt.logik;

import smket.textmarkierung_pt.model.AufgabeLehrend;
import smket.textmarkierung_pt.model.LoesungStud;
import smket.textmarkierung_pt.repository.AufgabeLehrendRepo;
import smket.textmarkierung_pt.repository.LoesungStudRepo;

public class LoesungStudLogik {

    LoesungStudRepo loesungStudRepo;
    AufgabeLehrendRepo aufgabeLehrendRepo;


    public LoesungStud erstelleLoesungStud(long aufgabeLehrendID, String loesung) {
        AufgabeLehrend aufgabe = aufgabeLehrendRepo.findAufgabe(aufgabeLehrendID);

        LoesungStud loesungStud = new LoesungStud();
        loesungStud.setAufgabeLehrend(aufgabe);
        loesungStud.setLoesung(loesung);

        loesungStudRepo.addloesung(loesungStud);

        return loesungStud;
    }

    public boolean ergebnis(long aufgabeId, long loesungId){
        AufgabeLehrend aufgabe = aufgabeLehrendRepo.findAufgabe(aufgabeId);
        LoesungStud loesung = loesungStudRepo.findloesung(loesungId);

        return aufgabe.getLoesung().equals(loesung.getLoesung());
    }

}
