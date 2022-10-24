package inscription.ges.repositories;

import java.util.List;

import inscription.ges.entities.Etudiant;

public interface IAttacheRepository {

    public Etudiant insertEtudiant(Etudiant etudiant);
    public Etudiant ReInsertEtudiant(Etudiant etudiant);
    public List<Etudiant> findByAnnee(String annee);
    public List<Etudiant> findByAnneeClasse(String annee,String libelle);

    
}
