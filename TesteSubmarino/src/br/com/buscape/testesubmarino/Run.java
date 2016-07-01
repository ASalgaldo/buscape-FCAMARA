package br.com.buscape.testesubmarino;

/**
 * Classe responsavel por iniciar a execucao do projeto recebendo os comandos via parametros de entrada 
 * @author André Salgado
 */
public class Run {

	/*
	 * Metodo padrão de inicio de execução do programa lembrando que os comando devem ser passados 
	 * como parametros de entradas na chamada inicial
	 * @param args
	 */
	public static void main(String[] args) {
		Navegacao n = new Navegacao();
		for(String a : args){
			n.acao(a);
		}
	}
}
