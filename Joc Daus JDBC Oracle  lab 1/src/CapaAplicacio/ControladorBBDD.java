package CapaAplicacio;

import java.sql.SQLException;
import java.util.List;

import CapaDomini.Jugador;
import CapaDomini.Partida;
import CapaPersistencia.JugadorBBDD;
import CapaPersistencia.PartidaBBDD;

public class ControladorBBDD {
	private PartidaBBDD partidaBBDD;
	private JugadorBBDD jugadorBBDD;

	public ControladorBBDD() throws Exception{
        partidaBBDD =new PartidaBBDD();
        jugadorBBDD= new JugadorBBDD();
	}
	public void afegirPartidaBBDD(Jugador jugador, int tirada1, int tirada2) throws Exception{
		  partidaBBDD.inserirPartida(jugador, tirada1, tirada2);
	}
	public boolean existeixJugador(String nomJugador) throws SQLException{
		return jugadorBBDD.existeix(nomJugador);
	}
	public List<Partida> obtenirPartides(String nomJugador) throws Exception{
		return partidaBBDD.getPartides(nomJugador);
	}
	public void afegirJugadorBBDD(String nomJugador) throws Exception{
		jugadorBBDD.inserirJugador(nomJugador);
	}
}
