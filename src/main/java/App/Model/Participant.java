package App.Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "participant")
public class Participant {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long idParticipant;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "prenom", nullable = false)
    private String prenom;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "date_naiss", nullable = false)
    private String date_naiss;
    @Column(name = "organisation")
    private String organisation;
    @Column(name = "observations")
    private String observations;


    @ManyToOne @JoinColumn(name="idEvenement", nullable=false)
    private Evenement evenement;


    //contractures
    public Participant(){

    }

    public Participant(String nom, String prenom, String email, String date_naiss,String organisation,String observations){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.date_naiss = date_naiss;
        this.organisation = organisation;
        this.observations = observations;
    }

    //Getters and setters


    public Long getId() {
        return idParticipant;
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

    public String getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(String date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    //equals hashCode toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant participant = (Participant) o;
        return Objects.equals(evenement,participant.evenement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(evenement);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + idParticipant +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", date_naiss='" + date_naiss + '\'' +
                ", organisation='" + organisation + '\'' +
                ", observations='" + observations + '\'' +
                this.evenement+
                '}';
    }
}
