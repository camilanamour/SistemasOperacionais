# SimuladorCorredor

A aplicação simula uma situação: 

Quatro pessoas (Thread) caminham, cada uma em um corredor diferente. Considere que cada corredor tem 200m e que cada pessoa anda de 4 a 6 m/s.

Os quatro corredores terminam em uma única porta (Semaphore), sendo que apenas uma pessoa pode cruzar a porta por vez. Cada pessoa leva de 1 a 2 seg para abrir e cruzar a porta.