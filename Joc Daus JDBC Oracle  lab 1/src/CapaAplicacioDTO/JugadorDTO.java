package CapaAplicacioDTO;

import CapaDomini.Jugador;

public class JugadorDTO {
	 private String nom;
	 public JugadorDTO(Jugador jugador){
		 this.nom= jugador.getNom();
	 }
	
	 public String getNomJugador(){
		 return this.nom;
	 }
}
