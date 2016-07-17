package pmdm.mviel.exemplerecyclerview;

/**
 * Created by mviel on 14/7/16.
 */
public class Client {
    private String nom;
    private String cognoms;
    private String malnom;
    private String telefon;

    public Client(String nom, String cognoms, String malnom, String telefon) {
        this.nom = nom;
        this.cognoms = cognoms;
        this.malnom = malnom;
        this.telefon = telefon;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getMalnom() {
        return malnom;
    }

    public void setMalnom(String malnom) {
        this.malnom = malnom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
