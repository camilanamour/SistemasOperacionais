package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessosController {
	
	public ProcessosController(){
		super();
	}
	
//	Retorne o Sistema Operacional que está em execução na máquina
	public String os(){
		String os = System.getProperty("os.name"); //retorna o nome do S.O (key-String-saber)
		String arch = System.getProperty("os.arch"); //retorna arquitetura (arch- 64 ou 32 bits)
		String version = System.getProperty("os.version"); //retorna versão (version)
		return "Nome: " + os + " - versão: " + version + " - Arquitetura: " + arch; //retorna tudo o que deseja
	}
	
	
//	Um processo chama outro processo
	public void chamaProcesso(String processo){		
		try {
			Runtime.getRuntime().exec(processo);
		} catch (Exception e) {
//			e.printStackTrace(); print do erro no console 
			String msgErro = e.getMessage(); //retorna apenas a primeira linha -- ERRO 740
//			System.err.println(msgErro); mensagem em vermelho
			
			if(msgErro.contains("740")){ //uma parte -- <ctrl + shift + i> mostra o resultado lógico
				StringBuffer buffer = new StringBuffer();
//				cmd /c caminho_do_processo -- para validar a solicitação de administrador
				buffer.append("cmd /c"); 
				buffer.append(" ");
				buffer.append(processo);
				try {
					Runtime.getRuntime().exec(buffer.toString()); //não aceita buffer
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			} else{
				e.printStackTrace(); //print do erro no console ou System.err.println(msgErro)
			}
		}
	}
	
	//Leitura de processos
	public void lerProcesso(String processo){
		try {
			Process p = Runtime.getRuntime().exec(processo); 	//Tipo processo - com os dados do processo filho (processo chamado)
//			todos os dados que o processo acima executar a váriavel irá armazenar uma aplicação infinita ou rápida.
			
			InputStream fluxo = p.getInputStream();		//retorna um inputStream -- fluxo de bits
			InputStreamReader leitor = new InputStreamReader(fluxo); 	//lê fluxo e converte para String -- processo saída de console
//			Bufferizar para não estourar a memória o que é convertido
			BufferedReader buffer = new BufferedReader(leitor); 	//guarda no buffer a conversão
			
			String linha = buffer.readLine(); // lê a primeira linha do buffer; próxima; descarta; sucessivamente
			while(linha != null){
				System.out.println(linha); //fazer o tratamento que quiser -- split..
				linha = buffer.readLine();
			} // até terminar
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Matar o processo pelo PID ou pelo Nome dele (não recomendavel -- nome)
	public void mataProcesso(String parametro){
		//WINDOWS
		String cmdPid = "TASKKILL /PID"; //único e númerico
		String cmdNome = "TASKKILL /IM"; //repetido e pode ter número ou não
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		//NumberFormatException (possibilidade)
		try{
			//TASKKILL /PID qlqrnúmero
			pid = Integer.parseInt(parametro); //matar pelo pid -- converte o parametro para número
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
		}catch(NumberFormatException e){
			//TASKKILL /IM nomedoprocesso.exe
			buffer.append(cmdNome);
			buffer.append(" ");
			buffer.append(parametro); //String
		}
		chamaProcesso(buffer.toString());
		
	}
}
