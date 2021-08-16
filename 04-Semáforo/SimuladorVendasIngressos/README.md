# SimuladorVendaIngressos

Exercício acadêmico - Thread e Semáforo

O sistema é um simulador de venda de ingressos. Há 300 pessoas (thread) interessadas em comprar ingressos de um show. A bilheteria possui apenas 100 ingressos. 

Assim, para conseguir os ingressos a pessoa precisa fazer o login (tempo aleatório: 5seg até 2min) se o tempo for menor que 1min, a pessoa pode informar quantos ingressos deseja (1 até 4) no processo de compra. Se o tempo do processo  (1min até 3min) for menor que 1min e 5seg há a validação da compra que só pode ser feita uma por vez (Semaphore) até o total de ingressos esgotarem. 

O login e o processo de compra são simultâneos, apenas a validação da compra é uma por vez, já que utiliza um recurso compartilhado (totalIngressos - = qtdIngressos;).