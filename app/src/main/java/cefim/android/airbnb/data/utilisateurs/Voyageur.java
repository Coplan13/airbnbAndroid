package cefim.android.airbnb.data.utilisateurs;

/**
 * Created by Coplan on 10/04/2019.
 */



public final class Voyageur extends Personne {

    private String email;
    private String mdp;
    private String notes;



    public Voyageur(String pNom, String pPrenom, int pAge, String email, String mdp, String notes) {
        super(pNom, pPrenom, pAge);
        this.email = email;
        this.mdp = mdp;
        this.notes = notes;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}

