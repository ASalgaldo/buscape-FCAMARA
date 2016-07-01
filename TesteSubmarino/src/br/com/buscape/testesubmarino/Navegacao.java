package br.com.buscape.testesubmarino;

import br.com.buscape.testesubmarino.util.Constantes.TpComando;
import br.com.buscape.testesubmarino.util.Constantes.Orientacao;

/**
 * Classe responsavel por representar os comandos basicos de navegacao e direcionamento da bussola
 * @author André Salgado
 */
public class Navegacao {
	//Eixos de saida (X, Y, Z, ORIENTACAO) 
	private int x;
	private int y;
	private int z;
	private String direcao;
	
	/*
	 * Inicializa a navegação do submarino em (0, 0, 0, NORTE)
	 */
	public Navegacao(){
		x = 0;
		y = 0;
		z = 0;
		direcao = "NORTE";
	}
	
	/*
	 * Metodo para controlar as acoes  do submarino
	 * #################################################
	 * ## Vale lembrar que temos as seguites posicoes:##
	 * #################################################
	 * ## NORTE = 0, LESTE = 1, SUL = 2, OESTE = 3	  ##
	 * #################################################
	 * ## Possiveis comandos						  ##
	 * #################################################
	 * ## ESQUERDA = L, 							  ##
	 * ## DIREITA = R,  							  ##
	 * ## MOVER = M, 								  ##
	 * ## SUBIR = U, 								  ##	
	 * ## DESCER = D; 								  ## 
	 * ## Qualquer valor diferente dos itens acima    ##
	 * ## imprime o resultado final					  ##
	 * #################################################
	 * @param comando - Comando / Acao a ser realizada no submarino
	 */
	public void acao(String comando){
		//recupera a posicao atual do submarino
		int posicaoAtual = getOrientacao(direcao);
		int aux = 0;
		
		//Verifica qual o tipo de comando / acao executado
		if(comando.equals(TpComando.ESQUERDA.getComando())){
			/*
			 * caso seja p/ mover pa/ a esquerda temos q considerar uma posicao a menos na bussola
			 * Exemplo:
			 * se o submarino estiver na direcao NORTE e executar o comando vamos move-lo para a direcao OESTE
			 */			
			aux = (posicaoAtual - 1);
			
			//caso a posicao fique negativa  alteramos para a posicao anterior
			if(Integer.valueOf(aux) < Integer.valueOf(0)){
				aux = 3;
			}
			
			//atualiza a posicao atual do submarino
			direcao = getOrientacao(aux);
				
	    } else if( comando.equals(TpComando.DIREITA.getComando())){	
			/*
			 * caso seja p/ mover pa/ a direita temos q considerar uma posicao a mais na bussola
			 * Exemplo:
			 * se o submarino estiver na direcao OESTE e executar o comando vamos move-lo para a direcao NORTE
			 */		    	
			aux = (posicaoAtual + 1);
			//caso a posicao fique maior que a posicao 3 alteramos para a proxima posicao
			if(aux == 4){
				aux = 0;
			}

			//atualiza a posicao atual do submarino
			direcao = getOrientacao(aux);
			
		} else if(comando.equals(TpComando.DESCER.getComando())){ // se o comando for para submergir acrescentamos -1 ao valor atual do eixo Z
			z = z-1;
		} else if(comando.equals(TpComando.SUBIR.getComando())){// se o comando for para emergir acrescentamos +1 ao valor atual do eixo Z ## esta funcao de calculo não foi descrita porem entendo que deva adicionar ## 
			z = z+1;			
		} else if(comando.equals(TpComando.MOVER.getComando())){ // movimenta o submarino na posicao em que ele se encontra apontado
			// se estiver apontando para LESTE adicionamos +1 no eixo x
			if(direcao.equals(Orientacao.LESTE.getOrientacao())){
				x = x + 1;				
			} else if(direcao.equals(Orientacao.NORTE.getOrientacao())){// se estiver apontando para NORTE adicionamos +1 no eixo y
				y = y + 1;
			}
		} else {
			System.out.println("Saída = " + x + " " + y + " " + z + " " + direcao );
		}
	}	
		
	/*
	 * Varre o enum de orientacao para localizar a posicao do array  que esta sendo a posicao atual do submarino  
	 * @param x - Direcao atual para a busca na bussola
	 * @return  retorna a posicao do array (bussola) equivalente a direcao passada 
	 */
	private int getOrientacao(String x){
		//converte em array
		Orientacao[] array = Orientacao.values();
		// Varre o array comparando a posicao passada no parametro 
		for(int i = 0; i < array.length; i++){
    		if(array[i].name().equals(x)){
    			return i;
    		}
    	}
		return 0;
    }
	
	/*
	 * Varre o enum de orientacao para localizar a descricao da posicao atual no array (bussola)  
	 * @param n - indica a posicao em que a bussola deve ser apontada  p/ recuperar a descricao
	 * @return  retorna descricao (NORTE, SUL, LESTE e OESTE) utilizando a posicao do array (bussola) equivalente passada como parametro 
	 */
    private String getOrientacao(int n) {
    	return Orientacao.values()[n].name();
    }
}