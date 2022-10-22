package inscription.ges.entities;

public class Attache  extends User{

    public Attache(int id, String login, String password) {
        super(id, login, password);
        role=Role.Attache;
    }



    public Attache(String login, String password) {
        super(login, password);
        role=Role.Attache;
    }

   
    
}
