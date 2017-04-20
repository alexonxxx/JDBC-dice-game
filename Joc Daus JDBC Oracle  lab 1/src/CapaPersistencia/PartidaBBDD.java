package CapaPersistencia;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import CapaDomini.Jugador;
import CapaDomini.Partida;






public class PartidaBBDD {
	private ConnectionBBDD connexio;
	public PartidaBBDD() throws Exception{
		
			connexio=LoginBBDD.getConnection();
		
	}
	private PreparedStatement createPKValuesQuery() throws SQLException{
		String sql = "SELECT S_IDPARTIDA.nextval pk_PARTIDA from sys.dual";
		return connexio.prepareStatement(sql);
	}
	
	private int createPartidaId() throws Exception{
		ResultSet generatedKey=createPKValuesQuery().executeQuery();
		if(generatedKey.next()) return generatedKey.getInt(1); //si hi ha un seguent mel retornes
		throw new Exception("Invalid PK");
	}
	 public void inserirPartida(Jugador jugador,int tirada1,int tirada2) throws Exception{
			try{
			
				boolean correct=executeInsertPartida(jugador, tirada1,tirada2);
				if(!correct) throw new Exception("No s'ha afegit la partida.");		
			}catch(SQLException e){
				e.printStackTrace();
				throw new Exception("No s'ha afegit la partida");
			}
		}
	private boolean executeInsertPartida(Jugador jugador,int tirada1,int tirada2) throws Exception {
		String sql="INSERT INTO PARTIDA (NOM,DAU1,DAU2,IDPARTIDA) VALUES(?,?,?,?)";
		PreparedStatement insertPartida=connexio.prepareStatement(sql);
		insertPartida.clearParameters();
		insertPartida.setString(1, jugador.getNom());
		insertPartida.setInt(2, tirada1);
		insertPartida.setInt(3, tirada2);
		insertPartida.setInt(4,createPartidaId());
		return insertPartida.executeUpdate()==1;
	}
	public LinkedList<Partida> getPartides(String nomJugador) throws Exception{
		LinkedList<Partida> listPartides = new LinkedList<Partida>();
		try{
		ResultSet result= executeSelectPartides(nomJugador);
		while(result.next()){
			listPartides.add(new Partida(result.getInt(2),result.getInt(3)));
		}
		}
		catch(Exception e){
			throw new Exception("Error al agafar la llista de partides " + e);
		}
		return listPartides;
		
	}

	private ResultSet executeSelectPartides(String nomJugador) throws SQLException{
		String sql="SELECT * FROM PARTIDA WHERE NOM=?";
		PreparedStatement  selectPartides= connexio.prepareStatement(sql);
		selectPartides.clearParameters();
		selectPartides.setString(1, nomJugador);
		return selectPartides.executeQuery();
	}
}
