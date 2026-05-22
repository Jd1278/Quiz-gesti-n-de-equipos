package com.quiz.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String apellido;
    private int numero;
    private String posicion;

    // --- AQUÍ ESTÁ EL CAMBIO ---
    @ManyToOne
    @JoinColumn(name = "id_club") // Este nombre debe ser EXACTAMENTE el de tu columna en la BD
    private Club club;
    // ---------------------------

    // Getters y Setters existentes...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getPosicion() { return posicion; }
    public void setPosicion(String posicion) { this.posicion = posicion; }

    // --- NO OLVIDES LOS GETTERS Y SETTERS DEL CLUB ---
    public Club getClub() { return club; }
    public void setClub(Club club) { this.club = club; }
}