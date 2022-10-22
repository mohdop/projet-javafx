package inscription.ges.core;



public interface IMysqlDB {
    public void ouvrirConnexion();
    public void fermerConnexion();
    public void initPreparedStatement();



}
