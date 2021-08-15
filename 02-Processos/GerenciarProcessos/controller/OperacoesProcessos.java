package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OperacoesProcessos {

	public OperacoesProcessos(){
		super();
	}
	
	public String sistemaOperacional(){
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void listarProcessos(String os){
		String processo = "";		
		try {
			if(os.contains("Windows")){
				processo = "TASKLIST /FO TABLE";
			}
			if(os.contains("Linux")){
				processo = "ps -ef";
			}
			Process p = Runtime.getRuntime().exec(processo); 
				
			InputStream fluxo = p.getInputStream();	
			InputStreamReader leitor = new InputStreamReader(fluxo); 	
			BufferedReader buffer = new BufferedReader(leitor);
							
			String linha = buffer.readLine();

			while(linha != null){
				System.out.println(linha);
				linha = buffer.readLine();
			}

				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				String msgErro = e.getMessage();
				System.err.println(msgErro);
			}	
	}
	
	public void mataPID(String os, int pid){
		String processo = "";
		StringBuffer buffer = new StringBuffer();
		
		 try {
			 if(os.contains("Windows")){
				buffer.append("TASKKILL /PID");
				buffer.append(" ");
				buffer.append(pid);
			}
			if(os.contains("Linux")){
				buffer.append("kill -9");
				buffer.append(" ");
				buffer.append(pid);
			}
			processo = buffer.toString();
			Runtime.getRuntime().exec(processo);
		} catch (IOException e) {
			String msgErro = e.getMessage();
			System.err.println(msgErro);
		}
	}
	
	public void mataNome(String os, String nome){
		String processo = "";
		StringBuffer buffer = new StringBuffer();
		
		try {
			if(os.contains("Windows")){
				buffer.append("TASKKILL /IM");
				buffer.append(" ");
				buffer.append(nome);
			}
			if(os.contains("Linux")){
				buffer.append("pkill -f");
				buffer.append(" ");
				buffer.append(nome);
			}
			processo = buffer.toString();
			Runtime.getRuntime().exec(processo);
		} catch (IOException e) {
			String msgErro = e.getMessage();
			System.err.println(msgErro);
		}
	}
}
