package inscription.ges.entities;

public class Professeur  {
    private int id;
    private String nomComplet;
    private String grade;
    private String nci;
    public Professeur(String nomComplet, String grade, String nci) {
        this.nomComplet = nomComplet;
        this.grade = grade;
        this.nci = nci;
    }
    public Professeur(int id, String nomComplet, String grade, String nci) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.grade = grade;
        this.nci = nci;
    }
    public Professeur(int int1, String string, String string2) {
    }
    public Professeur(int id, String nci) {
        this.id = id;
        this.nci = nci;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getNci() {
        return nci;
    }
    public void setNci(String nci) {
        this.nci = nci;
    }
    @Override
    public String toString() {
        return "Professeur [nomComplet=" + nomComplet + ", grade=" + grade + ", nci=" + nci + "]";
    }
    
}
