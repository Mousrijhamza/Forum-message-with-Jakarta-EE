package Metier;

import java.io.Serializable;


public class User implements Serializable{

    private String nomPr;
    private String email;
    private String passWord;
    private boolean statut=true;// true for stu

    public User() {	}

    public User(String nomPr, String email, String passWord, boolean statut) {
        this.nomPr = nomPr;
        this.email = email;
        this.passWord = passWord;
        this.statut = statut;
    }

    public String getNomPr() {return nomPr;}
    public void setNomPr(String nomPr) {this.nomPr = nomPr;	}
    public String getEmail() {	return email;}
    public void setEmail(String email) {this.email = email;	}
    public String getPassWord() {return passWord;}
    public void setPassWord(String passWord) {this.passWord = passWord;}
    public boolean getStatut() {return statut;}
    public void setStatut(Boolean statut) {	this.statut = statut;}
    public void setStatut(String statut) {
        if (statut.equals("Etudiant"))this.statut=true;
        else this.statut=false;
    }
    public boolean estProf() {
        return !statut;
    }
    public boolean estEtudiant() {
        return statut;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [nomPr=" + nomPr + ", email=" + email + ", passWord=" + passWord + ", statut=" + statut + "]";
    }



}