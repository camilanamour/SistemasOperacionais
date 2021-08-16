package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ArquivoController {

	public ArquivoController() {
		super();
	}

	public String readFile(String path, String name) throws IOException {
		File arq = new File(path, name);
		if (arq.exists() && arq.isFile()) {
			StringBuffer print = new StringBuffer();
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			print.append("NAME" + this.tabulacao("NOME", 45) + 
					"SCIENTIFIC NAME" + this.tabulacao("SCIENTIFIC NAME", 45) +
					"SUBGROUP\n\n");

			String linha = buffer.readLine();
			while (linha != null) {
				if (linha.contains("Fruits,")) {
					if(!linha.contains(" (")){
						String[] coluna = linha.split(",");
						print.append(coluna[0]);
						print.append(this.tabulacao(coluna[0], 45));
						print.append(coluna[1]);
						print.append(this.tabulacao(coluna[1], 45));
						print.append(coluna[3] + "\n");
					} else {
						String[] nome = linha.split(Pattern.quote(")"));
						String[] coluna = nome[1].split(",");
						print.append(nome[0] + ")");
						print.append(this.tabulacao(nome[0], 45));
						print.append(coluna[1]);
						print.append(this.tabulacao(coluna[1], 45));
						print.append(coluna[3] + "\n");
					}
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
			return print.toString();
		} else {
			throw new IOException("Arquivo inválido");
		}
	}

	private String tabulacao(String coluna, int limite) {
		StringBuffer buffer = new StringBuffer();
		int vezes = (limite - (coluna.length()));
		int espaco = 0;
		while(espaco <= vezes){
			buffer.append(" ");
			espaco++;
		}
		buffer.append("\t");
		return buffer.toString();
	}

}
