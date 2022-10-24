package inscription.ges.entities;

public class ClasseProfesseur {
    private int id;
    private String nci,libelle;

    public ClasseProfesseur(int id, String nci, String libelle) {
        this.id = id;
        this.nci = nci;
        this.libelle = libelle;
    }

    public ClasseProfesseur(String nci, String libelle) {
        this.nci = nci;
        this.libelle = libelle;
    }

    public ClasseProfesseur(int id, String libelle) {
        this.id = id;
       
        this.libelle = libelle;
    }

    public ClasseProfesseur(String nci) {
        this.nci=nci;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNci() {
        return nci;
    }

    public void setNci(String nci) {
        this.nci = nci;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    
}
