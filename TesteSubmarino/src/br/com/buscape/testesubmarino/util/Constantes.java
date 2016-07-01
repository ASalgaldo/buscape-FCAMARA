package br.com.buscape.testesubmarino.util;

/**
 * Classe generica para variaveis contantes p/ a identificacao de movimento / direcao
 * @author André Salgado
 */
public class Constantes {

	//enum p/ comparacao dos valores de entrada ref a movimentacao
	public enum TpComando {
		ESQUERDA("L"),
		DIREITA("R"),
		MOVER("M"),
		SUBIR("U"),	
		DESCER("D");

		private String comando;

		TpComando(String comando) {
			this.comando = comando;
		}

		public String getComando() {
			return comando;
		}
	}
	
	//enum p/ comparacao dos valores de entrada ref a orientacao da bussola
	public enum Orientacao {
		NORTE, LESTE, SUL, OESTE;
		
		private String comando;

		Orientacao() {
			this.comando = name();
		}
		
	    public String getOrientacao() {
	    	return comando;
	    }
	}
}