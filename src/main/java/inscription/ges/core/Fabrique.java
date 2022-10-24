package inscription.ges.core;

import inscription.ges.repositories.IAttacheRepository;
import inscription.ges.repositories.IResponsablePedagogiqueRepository;
import inscription.ges.repositories.IUserRepository;
import inscription.ges.repositories.bd.AttacheRepository;
import inscription.ges.repositories.bd.ResponsablePedagogiqueRepository;
import inscription.ges.repositories.bd.UserRepository;
import inscription.ges.services.GestionServices;
import inscription.ges.services.IGestionServices;

public class Fabrique {
    public static IGestionServices getService(){
        IAttacheRepository attacheRepository = new AttacheRepository();
        IResponsablePedagogiqueRepository responsablePedagogiqueRepository = new ResponsablePedagogiqueRepository();
        IUserRepository userRepository = new UserRepository();
        return new GestionServices(attacheRepository,responsablePedagogiqueRepository,userRepository);
    }
}
