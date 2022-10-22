package inscription.ges.services;

import java.util.List;

import inscription.ges.entities.Classe;
import inscription.ges.entities.ClasseProfesseur;
import inscription.ges.entities.Etudiant;
import inscription.ges.entities.Professeur;
import inscription.ges.entities.User;

public interface IGestionServices {
    public Classe ajouterClasse(Classe classe);
    public List<Classe> listerClasses();
    public ClasseProfesseur profClasse(ClasseProfesseur classeProfesseur);
    public User seConnecter(String login, String password);
    public Professeur ajouterProfesseur(Professeur professeur);
    public List<Professeur> listerProfesseurs();
    public List<ClasseProfesseur> rechercheClasseProfesseurs(String nci);
    public Etudiant ajouterEtudiant(Etudiant etudiant);
    public Etudiant ReAjouterEtudiant(Etudiant etudiant);
    public List<Etudiant> ListerParAnnee(String annee);
    public List<Etudiant> ListerParAnneeClasse(String annee,String libelle);
}
