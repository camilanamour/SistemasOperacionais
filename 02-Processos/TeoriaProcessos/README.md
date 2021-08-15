# Teoria Processos

A aplicação traz as informações do sistema - nome, arquitetura e versão - que está sendo utilizado.  Além de realizar funções, para Windows, como:

1. **Processo (aplicação) chama outro processo:** segundo o path (*C://...* ) fornecido pelo usuário é executado um processo, caso dê a exceção de administrador (erro 740), preenche o (*"cmd /c" + path do processo*) - usando o *StringBuffer*;

    

2. **Processo mata outro processo:** segundo o parâmetro (nome ou número) mata aquele processo - usando a exceção *NumberFormatException* para identificar se é número ou caractere - usando os comandos *TASKKILL /PID número* ou *TASKKILL /IM nome*;

    

3. **Processo (aplicação) se comunica com outro processo e lê o que ele está gerando:** segundo o comando "TASKLIST /FO TABLE" (listar processos) que pegará um fluxo de bits (*InputStream*), o qual será lido e convertido para String pelo leitor (*InputStreamReader*) e armazenado no buffer essa conversão (*BufferedReader*). Será lido linha a linha do que está armazenado no buffer e será impresso no console. Assim, aparecerá a saída do comando para listar todos os processos na própria aplicação.