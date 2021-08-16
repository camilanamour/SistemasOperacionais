# SimuladorCruzamento

Exercício acadêmico - passagem de carros (console).

O sistema é uma simulação de um cruzamento. Quatro carros (Thread) querem passar num cruzamento (Semaphore). O carro ao sul vai para o norte, o do norte vai para o sul, o do leste vai oeste, o do oeste vai para o leste. 

No entanto, apenas um carro pode passar por vez no cruzamento, assim quando um carro passa fecha o semáforo para os outros carros (semaforo.acquire();), terminando de passar é necessário abrir o semáforo para os outros (semaforo.release();).