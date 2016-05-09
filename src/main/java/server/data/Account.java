package server.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name="ACCOUNT")

public class Account {

    @Id
    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private String password;

    ArrayList<Budget> listBudgets;

    public Account() {
        super();
    }

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

}
