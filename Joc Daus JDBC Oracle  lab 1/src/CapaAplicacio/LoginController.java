package CapaAplicacio;

import CapaPersistencia.LoginBBDD;

public class LoginController {
	
	public void login(String user, String password) throws Exception{
		LoginBBDD.login(user, password);
		
	}
	public void finalitzarJoc() throws Exception{
		LoginBBDD.closeConnection();
	}

}
