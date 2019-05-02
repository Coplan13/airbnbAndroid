package cefim.android.airbnb;

public class MyObject {

    private String text;
    private String imageUrl;
    private Integer prix;
    private String note;
    private String pays;

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getPays() {
        return pays;
    }

    public MyObject(String text, String imageUrl, Integer prix, String note, String pays) {
        this.text = text;
        this.imageUrl = imageUrl;
        this.prix = prix;
        this.note = note;
        this.pays = pays;
    }

    //getters & setters

    public void setText(String text) {
        this.text = text;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getPrix() {
        return prix;
    }

    public String getNote() {
        return note;
    }

    public String getText() {
        return text;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}