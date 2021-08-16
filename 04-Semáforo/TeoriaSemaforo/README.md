# Semáforo

O paralelismo gera concorrência de **recursos** - que pode ser uma variável, um hardware, entre outros - **compartilhados**. Para isso é usado o semafóro (*Semaphore*) que é responsável em abrir (*semaforo.release()*) e fechar (*semaforo.acquire()*).

Assim, quando uma thread chega na sessão crítica - que só pode rodar uma por vez - a  thread fecha o semáforo, usa o recurso, quando termina, abre, para outra thread usar esse recurso. Utilizado o *try (comando em paralelo; **fecha**) /catch/finally (**abre**; comandos em paralelo).* 

Isso mantém o paralelismo nas sessões normais e o **sincronismo** nas sessões críticas.