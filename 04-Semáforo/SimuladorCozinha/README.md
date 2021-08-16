# SimuladorCozinha

Exercício acadêmico - threads com semáforo (Jogo de Simulação - console)

O sistema é um simulador de cozinha. O cozinheiro (main) prepara cinco pratos (threads) simultaneamente. 

- Os pratos com identificadores pares cozinham Lasanha a Bolonhesa - tempo de preparo: 0,6 a 1,2 segundos. 
- Os pratos com identificadores impares cozinham Sopa de Cebola -  tempo de preparo: 0,5 a 0,8 segundos.

Os pratos precisam mostrar seu progresso de preparo (%). 

Quando o prato fica pronto (100%) é preciso especificar ao jogador que está sendo entregue o prato. A espera é de 5 segundos, passando esse tempo o prato é entregue para avaliação. No entanto, a espera e a entrega só pode ser feita um prato por vez (Semaphore).