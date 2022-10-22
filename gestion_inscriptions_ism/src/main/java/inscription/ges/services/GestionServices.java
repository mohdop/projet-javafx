package inscription.ges.services;

import java.util.List;

import inscription.ges.entities.Classe;
import inscription.ges.entities.ClasseProfesseur;
import inscription.ges.entities.Etudiant;
import inscription.ges.entities.Professeur;
import inscription.ges.entities.User;
import inscription.ges.repositories.IAttacheRepository;
import inscription.ges.repositories.IResponsablePedagogiqueRepository;
import inscription.ges.repositories.IUserRepository;


public class GestionServices implements IGestionServices {
        
    IAttacheRepository attacheRepository;
    IResponsablePedagogiqueRepository responsablePedagogiqueRepository;
    IUserRepository userRepository;

    public GestionServices(IAttacheRepository attacheRepository,
            IResponsablePedagogiqueRepository responsablePedagogiqueRepository,IUserRepository userRepository) {
                this.attacheRepository=attacheRepository;
                this.responsablePedagogiqueRepository=responsablePedagogiqueRepository;
                this.userRepository=userRepository;
    }


    @Override
    public Classe ajouterClasse(Classe classe){
        return responsablePedagogiqueRepository.insertClasse(classe);
    }
    @Override
    public List<Classe> listerClasses(){
        return responsablePedagogiqueRepository.findall();
    }
    @Override
    public List<Professeur> listerProfesseurs(){
        return responsablePedagogiqueRepository.findallProf();
    }


    @Override
    public ClasseProfesseur profClasse(ClasseProfesseur classeProfesseur) {
        
        return responsablePedagogiqueRepository.profClasse(classeProfesseur);
    }

   @Override
    public User seConnecter(String login, String password) {
        return userRepository.findUserByLoginAndPassword(login, password);
    }

    @Override 
    public Professeur ajouterProfesseur(Professeur professeur){
        return responsablePedagogiqueRepository.insertProfesseur(professeur);
    }

   @Override
   public List<ClasseProfesseur> rechercheClasseProfesseurs(String nci){
    return responsablePedagogiqueRepository.findClasseProfesseurs(nci);
   }
   @Override 
   public Etudiant ajouterEtudiant(Etudiant etudiant){
       return attacheRepository.insertEtudiant(etudiant);
   }
    @Override 
   public Etudiant ReAjouterEtudiant(Etudiant etudiant){
       return attacheRepository.ReInsertEtudiant(etudiant);
   } 
    @Override
    public List<Etudiant> ListerParAnnee(String annee){
        return attacheRepository.findByAnnee(annee);
    }
    @Override
    public List<Etudiant> ListerParAnneeClasse(String annee,String libelle){
        return attacheRepository.findByAnneeClasse(annee,libelle);
    }
    
}
//