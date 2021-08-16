# SimuladorBanco

Exercício acadêmico - depósito e saque (concorrência)

O sistema representa o funcionamento bancário. Há 20 transações (Thread) realizando operações de saque ou deposito. No entanto, pode ser simultâneo um saque e um deposito, mas não dois saques (Semaphore) e dois deposito (Semaphore).

Assim, cada transição precisa do número da conta, a operação que será realizada, o saldo, o valor da operação e os semáforos - um para saque e outro para deposito.