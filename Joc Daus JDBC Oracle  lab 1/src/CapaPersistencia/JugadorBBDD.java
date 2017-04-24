package CapaPersistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JugadorBBDD {
	private ConnectionBBDD connexio;
	public JugadorBBDD() throws Exception{
		
			connexio=LoginBBDD.getConnection();
		
	}
	public void inserirJugador(String nomJugador)  throws Exception{
		try{
		boolean correct=executeInsertJugador(nomJugador);
		if(!correct){
			throw new Exception("No s'ha afegit el jugador");
		}
		}catch(SQLException e){
			throw new Exception("No s'ha afegit el jugador");
		}
	}
	private boolean executeInsertJugador(String nomJugador) throws SQLException {
		String sql="INSERT INTO JUGADOR (NOM) VALUES (?)";
		PreparedStatement insertJugador=this.connexio.prepareStatement(sql);
		insertJugador.clearParameters();
		insertJugador.setString(1, nomJugador);
		return insertJugador.executeUpdate()==1;
	}
	public boolean existeix(String nom) throws SQLException {
		ResultSet result= executeSelectJugador(nom);
		if(result.next()) return true;
		else
		return false;
		
	}
	private ResultSet executeSelectJugador(String nom) throws SQLException {
		String sql="SELECT * FROM JUGADOR WHERE NOM=?";
		PreparedStatement selectJugador=this.connexio.prepareStatement(sql);
		selectJugador.clearParameters();
		selectJugador.setString(1, nom);
		return selectJugador.executeQuery();
	}
}
