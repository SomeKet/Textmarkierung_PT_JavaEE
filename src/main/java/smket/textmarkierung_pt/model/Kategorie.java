package smket.textmarkierung_pt.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Kategorie {

    private String bezeichnung;
    private String farbe;
    private String tag;

    public Kategorie(String bezeichnung, String farbe, String tag) {
        this.bezeichnung = bezeichnung;
        this.farbe = farbe;
        this.tag = tag;
    }

    public Kategorie() {
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }



}
