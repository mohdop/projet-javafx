package inscription.ges.entities;

public class Etudiant {
    private static int nbr;
    private int id;
    private String matricule,nomComplet,tuteur,libelle,annee;


    public Etudiant(String libelle, String annee) {
        this.libelle = libelle;
        this.annee = annee;
    }

    public Etudiant(String annee) {
        this.annee = annee;
    }

    public Etudiant(String matricule, String libelle, String annee) {
        this.matricule = matricule;
        this.libelle = libelle;
        this.annee = annee;
    }
   
    public Etudiant(String matricule, String nomComplet, String tuteur, String libelle,String annee) {
        this.matricule = matricule;
        this.nomComplet = nomComplet;
        this.tuteur = tuteur;
        this.libelle = libelle;
        this.annee=annee;
    }
    public Etudiant(String matricule,int nbr) {
        nbr++;
        this.matricule = "Etud"+nbr;
    }
    public Etudiant(int id, String matricule, String nomComplet, String tuteur) {
        this.id = id;
        this.matricule = matricule;
        this.nomComplet = nomComplet;
        this.tuteur = tuteur;
    }
    
    public static int getNbr() {
        return nbr;
    }
    public static void setNbr(int nbr) {
        Etudiant.nbr = nbr;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getTuteur() {
        return tuteur;
    }
    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }
    public String getAnnee() {
        return annee;
    }
    public void setAnnee(String annee) {
        this.annee = annee;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    @Override
    public String toString() {
        return "Etudiant [matricule=" + matricule + ", nomComplet=" + nomComplet + ", tuteur=" + tuteur + "]";
    }
    
    
}
