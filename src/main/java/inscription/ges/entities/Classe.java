package inscription.ges.entities;

public class Classe {
    private int id;
    private String libelle;
    public Classe(String libelle) {
        this.libelle = libelle;
    }
    public Classe(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    @Override
    public String toString() {
        return "Classe [libelle=" + libelle + "]";
    }
}
