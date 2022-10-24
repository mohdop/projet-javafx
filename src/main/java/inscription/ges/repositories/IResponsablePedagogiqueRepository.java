package inscription.ges.repositories;

import java.util.List;

import inscription.ges.entities.Classe;
import inscription.ges.entities.ClasseProfesseur;
import inscription.ges.entities.Professeur;

public interface IResponsablePedagogiqueRepository {
    public Classe insertClasse(Classe classe);
    public List<Classe> findall();
    public ClasseProfesseur profClasse(ClasseProfesseur classeProfesseur);
    public Professeur insertProfesseur(Professeur professeur);
    public List<Professeur> findallProf();
    public List<ClasseProfesseur> findClasseProfesseurs(String nci);
}
