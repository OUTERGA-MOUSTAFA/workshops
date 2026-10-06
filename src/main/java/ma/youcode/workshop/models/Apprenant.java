package ma.youcode.workshop.models;

public class Apprenant {

    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String filiere;
    public Apprenant(Integer id, String nom, String prenom, String email, String filiere) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.filiere = filiere;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFiliere() {
        return filiere;
    }
    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    

    
    
}
