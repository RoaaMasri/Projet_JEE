package App.Model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;




@Entity
@Table(name = "evenement")
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "titre", nullable = false)
    private String titre;
    @Column(name = "theme")
    private String theme;
    @Column(name = "date_debut", nullable = false)
    private String date_debut;
    @Column(name = "duree")
    private String duree;
    @Column(name = "nb_part_max", nullable = false)
    private int nb_part_max;
    @Column(name = "description")
    private String description;
    @Column(name = "organisateur")
    private String organisateur;
    @Column(name = "type_even")
    private String type_even;

    @OneToMany(mappedBy = "evenement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Participant> participants = new ArrayList<>();



    //contractures
    public Evenement(){

    }

    public Evenement(String titre, String theme, String date_debut, String duree,
                     int nb_part_max, String description, String organisateur, String type_even){
        this.titre= titre;
        this.theme = theme;
        this.date_debut = date_debut;
        this.duree = duree;
        this.nb_part_max = nb_part_max;
        this.description = description;
        this.organisateur = organisateur;
        this.type_even = type_even;
    }



//Getters and setters


    public long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public int getNb_part_max() {
        return nb_part_max;
    }

    public void setNb_part_max(int nb_part_max) {
        this.nb_part_max = nb_part_max;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(String organisateur) {
        this.organisateur = organisateur;
    }

    public String getType_even() {
        return type_even;
    }

    public void setType_even(String type_even) {
        this.type_even = type_even;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }


    //equals hashCode toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evenement evenement = (Evenement) o;
        return id == evenement.id && nb_part_max == evenement.nb_part_max
                && titre.equals(evenement.titre)
                && Objects.equals(theme, evenement.theme)
                && date_debut.equals(evenement.date_debut)
                && Objects.equals(duree,evenement.duree)
                && Objects.equals(description, evenement.description)
                && Objects.equals(organisateur, evenement.organisateur)
                && Objects.equals(type_even, evenement.type_even);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titre, theme, date_debut, duree, nb_part_max, description, organisateur, type_even);
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", theme='" + theme + '\'' +
                ", date_debut='" + date_debut + '\'' +
                ", duree='" + duree + '\'' +
                ", nb_part_max=" + nb_part_max +
                ", description='" + description + '\'' +
                ", organisateur='" + organisateur + '\'' +
                ", type_even='" + type_even + '\'' +
                this.participants+
                '}';
    }

    // add particepant to event
    public void addParticipant(Participant participant){
        participants.add(participant);
        participant.setEvenement(this);
    }

    public void removeParticipant(Participant participant){
        participants.remove(participant);
        participant.setEvenement(null);
    }
}

