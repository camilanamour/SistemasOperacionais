package view;

/* Arquitetura de Software --- separando as classes em pacotes <camadas>.
 * Importantes para n�o sobrecarregar a mem�ria, apenas chamando aquilo se for necess�rio
 * pelos m�dulos, n�o sobrecarregando a main
 * 
 * MVC- MODEL VIEW CONTROLLER
 * MODEL 	(modelo)	 <classes para transporte de dados> -- criar tipos de dados
 * CONTROLLER (Controle) <classes que cont�m opera��es>
 * VIEW (vis�o)			 <classes de comunica��o com usu�rio -- main, telas 
 * 
 * As classes da VIEW apenas recebe os valores, colocando-os nas classes do pacote MODEL
 * Sendo as opera��es realizadas nas classes de CONTROLLER que retorna ou n�o valor. 
 * Chamando para mem�ria apenas do que precisa.
 */

import controller.OperacoesController; 
//apenas a classe que ser� usada para n�o sobrecarregar a mem�ria (n�o colocar o *)


public class Principal {

	public static void main(String[] args) { 
		/* <digita main> <ctrl + espa�o> abre caixa
		 * <ctrl + s> salva a classe atual
		 * <ctrl + shift + s> salva todas as classes abertas
		 * <ctrl + /> ou //
		 * <ctrl + d> apaga linha toda 
		 * <ctrl + 1> cria uma v�riavel
		 * sysout <ctrl + espa�o>
		 * <ctrl + f11> roda a aplica��o (run)*/
		
		OperacoesController c = new OperacoesController(); //Inst�ncia classe
		String frase = "Aula 01 aprendi muuiito";
		
		c.ConcatenaString();
		c.ConcatenaBuffer();
		c.DivideFrase(frase);
		System.out.println("");
		c.Exercicio(); //Procedimento que manda param�tro.
		
				
	}

}
