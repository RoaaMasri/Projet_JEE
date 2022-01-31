/**

 * Participant class helps listens to the user request to create
   new participant with the event he is attending to go to

 * And output a table "participant" in database

 * @author Roaa Masri

 */

package App.Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "participant")
public class Participant {

    //defining Participant class variables

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
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

    /**
     * Creating the relation manyToOne between Participant class and Event class
     * One participant can go only to one event
     * This relation sent event_id into participant table when he chooses an event
     */
    @ManyToOne @JoinColumn(name="id_event", nullable=false)
    private Evenement evenement;


    //Class contractures
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

    //Getters and setters methods

    public Long getId() {
        return id;
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
                "id=" + id +
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
