# GerenciarProcessos

Exercício acadêmico - listar e matar processos

O sistema é um Gerenciador de Processos - que segundo a escolha do usuário - lista os processos em execução ou mata o processo pelo PID ou o nome do processo. Para os sistemas operacionais Windows e Linux.

Windows - processos

- Listar: TASKLIST /FO TABLE
- Matar pelo PID: TASKKILL /PID
- Matar pelo nome: TASKKILL /IM

Linux - processos

- Listar: ps -ef
- Matar pelo PID: kill -9
- Matar pelo nome: pkill -f