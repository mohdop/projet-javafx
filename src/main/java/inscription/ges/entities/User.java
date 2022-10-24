package inscription.ges.entities;

public class User {
    protected int id;
    protected String login;
    protected String password;
    protected Role role;
    public User() {
    }
    public User(int id, String login, String password, Role role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }
    public User(int id) {
        this.id = id;
    }
    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
      
    }
    public User(String login, String password) {
        this.login = login;
        this.password = password;
        
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "User [login=" + login + ", password=" + password + ", role=" + role + "]";
    }
}
