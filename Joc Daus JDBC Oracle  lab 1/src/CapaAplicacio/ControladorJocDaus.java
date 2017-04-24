package CapaAplicacio;



import java.util.List;
import CapaDomini.Dau;
import CapaDomini.Jugador;
import CapaDomini.Partida;

public class ControladorJocDaus {

    private Dau dau1, dau2;
    private final int CARES_DAUS = 6;
    private Jugador jugador;
    private ControladorBBDD controladorBBDD;
 
    public ControladorJocDaus() throws Exception {
        dau1 = new Dau(CARES_DAUS);
        dau2 = new Dau(CARES_DAUS);
        jugador = new Jugador("Anonim");   
        controladorBBDD= new ControladorBBDD();
        
       
    }

    public void jugar() throws Exception {
        int tirada1 = this.tirarDau(dau1);
        int tirada2 = this.tirarDau(dau2);
        jugador.addPartida(tirada1, tirada2);
        controladorBBDD.afegirPartidaBBDD(jugador, tirada1, tirada2);
      
      
        
    }

    private int tirarDau(Dau dau) {
        dau.llenca();
        return dau.valorCara();
    }

    public String getNomJugador() {
        return jugador.getNom();
    }

    public String resultatPartidaEnCurs() {
        return jugador.resultatPartidaEnCurs();
    }

    public double guanyadesPercent() {
        return jugador.nombreGuanyades() / (float) jugador.nombrePartides() * 100;
    }

    public void nouJugador(String nom) throws Exception{
        //Si el nom és "Anonim" no cal fer res
        if (!nom.equalsIgnoreCase("Anonim")) {          
               jugador = new Jugador(nom);   
               if(controladorBBDD.existeixJugador(nom)){
               List<Partida> partidesBBDD= controladorBBDD.obtenirPartides(nom);
               
               jugador.addPartides(partidesBBDD);
               }
               else{
            	   controladorBBDD.afegirJugadorBBDD(nom);
               }
        }
       
    }
    

    public String resultatPartides() {
    	
        return jugador.resultatPartides();
    }   	
}
