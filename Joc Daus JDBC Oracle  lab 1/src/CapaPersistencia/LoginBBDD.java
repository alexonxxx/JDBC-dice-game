package CapaPersistencia;

public class LoginBBDD {

	private static ConnectionBBDD connection;

	public static void login(String user, String password) throws Exception {
		if (connection == null)
			connection = new ConnectionBBDD(user, password);
	}	

	static ConnectionBBDD getConnection() throws Exception{
		if(connection==null) throw new Exception("No s'ha iniciat sessio");
		return connection;
	}
	public static void closeConnection() throws Exception{
		try{
			connection.close();
			connection=null;
		}catch(Exception e){
			throw new Exception("No s'ha tancat la connexio");
		}
}
}
