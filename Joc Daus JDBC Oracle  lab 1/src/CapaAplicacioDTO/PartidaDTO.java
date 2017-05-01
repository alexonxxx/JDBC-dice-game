package CapaAplicacioDTO;

import CapaDomini.Partida;

public class PartidaDTO {
private int dau1, dau2;

private boolean guanyada;
public PartidaDTO(Partida partida){
	this.dau1= partida.getDau1();
	this.dau2= partida.getDau2();
	this.guanyada= partida.getGuanyada();

}
public String getDau1(){
	return Integer.toString(this.dau1);
}
public String getDau2(){
	return Integer.toString(this.dau1);
}
public String getResultat(){
	 String resultat;
	 if (this.guanyada) {
	        resultat = "guanyada";
	    } else {
	        resultat = "perduda";
	    }
	 return resultat;
}
public String getInfoResultat() {
    String resultat=getResultat();

    if (this.guanyada) {
        resultat = "guanyada";
    } else {
        resultat = "perduda";
    }
    return "Dau1: " + dau1 + ", Dau2: " + dau2 + ", Resultat: " + resultat;
}
}
