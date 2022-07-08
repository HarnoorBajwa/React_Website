package ca.dal.Group2.User.Entity;

import javax.persistence.*;

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String emailId;
    private String password;

    private String secQ;

    private String ans;

    public Model(String name, String emailId, String password, String secQ, String ans) {
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.secQ = secQ;
        this.ans = ans;
    }

   public Model(){}


    private void setId(Long id) {
        this.id = id;
    }

    @Id

    private Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getSecurity(){ return secQ; }
    public void setSecurity(String secQ){this.secQ = secQ;}

    public String getAns(){return ans;}
    public void setAns(String ans){this.ans =  ans;}


}