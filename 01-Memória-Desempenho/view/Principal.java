package view;

/* Arquitetura de Software --- separando as classes em pacotes <camadas>.
 * Importantes para não sobrecarregar a memória, apenas chamando aquilo se for necessário
 * pelos módulos, não sobrecarregando a main
 * 
 * MVC- MODEL VIEW CONTROLLER
 * MODEL 	(modelo)	 <classes para transporte de dados> -- criar tipos de dados
 * CONTROLLER (Controle) <classes que contêm operações>
 * VIEW (visão)			 <classes de comunicação com usuário -- main, telas 
 * 
 * As classes da VIEW apenas recebe os valores, colocando-os nas classes do pacote MODEL
 * Sendo as operações realizadas nas classes de CONTROLLER que retorna ou não valor. 
 * Chamando para memória apenas do que precisa.
 */

import controller.OperacoesController; 
//apenas a classe que será usada para não sobrecarregar a memória (não colocar o *)


public class Principal {

	public static void main(String[] args) { 
		/* <digita main> <ctrl + espaço> abre caixa
		 * <ctrl + s> salva a classe atual
		 * <ctrl + shift + s> salva todas as classes abertas
		 * <ctrl + /> ou //
		 * <ctrl + d> apaga linha toda 
		 * <ctrl + 1> cria uma váriavel
		 * sysout <ctrl + espaço>
		 * <ctrl + f11> roda a aplicação (run)*/
		
		OperacoesController c = new OperacoesController(); //Instância classe
		String frase = "Aula 01 aprendi muuiito";
		
		c.ConcatenaString();
		c.ConcatenaBuffer();
		c.DivideFrase(frase);
		System.out.println("");
		c.Exercicio(); //Procedimento que manda paramêtro.
		
				
	}

}
