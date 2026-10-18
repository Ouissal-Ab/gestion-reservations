package com.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDateTime dateDebut;


    private LocalDateTime dateFin;

    private String motif;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "salle_id", nullable = false)
    private Salle salle;

    public Reservation() {}

    public Reservation(LocalDateTime dateDebut, LocalDateTime dateFin, String motif) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.motif = motif;
    }

    public Long getId() { return id; }
    public LocalDateTime getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDateTime dateDebut) { this.dateDebut = dateDebut; }
    public LocalDateTime getDateFin() { return dateFin; }
    public void setDateFin(LocalDateTime dateFin) { this.dateFin = dateFin; }
    public String getMotif() { return motif; }
    public void setMotif(String motif) { this.motif = motif; }
    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }
    public Salle getSalle() { return salle; }
    public void setSalle(Salle salle) { this.salle = salle; }

    @Override
    public String toString() {
        return "Reservation{id=" + id + ", debut=" + dateDebut + ", fin=" + dateFin + ", motif='" + motif + "'}";
    }
}