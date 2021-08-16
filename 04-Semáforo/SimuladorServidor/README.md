# SimuladorServidor

Exercício acadêmico - threads com semáforo

A apliação dispara 21 threads - que simulam o funcionamento de um servidor - que realizam requisições.  O cálculo do tempo de espera (*sleep*)  do processamento é simultaneamente, mas o tempo de transição é realizado uma thread por vez - usando o semáforo (*Semaphore*).