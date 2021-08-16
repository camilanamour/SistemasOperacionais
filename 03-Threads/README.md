# Threads

É um conjunto de processos, que trabalham de forma **paralelas, aleatórias e independências**. Isso é possível por conta dos múltiplos núcleos rodarem múltiplos fluxos simultaneamente.

O uso de threads no Java é necessário que a classe que trabalhará com conjunto de processos simultâneos herde (*extends*) a Classe Thread, implementando o método *run()* responsável pela inicialização da execução da thread. Cada thread (objeto) precisa ser iniciada na main (*thread.start()*), construindo uma estrutura com o método construtor - atribuir valor as características da classe - segundo a passagem de parâmetros.

### Semáforo

O paralelismo gera concorrência de **recursos** - que pode ser uma variável, um hardware, entre outros - **compartilhados**. Para resolver o problema é usado o semáforo. Isso mantém o **paralelismo** nas sessões normais e o **sincronismo** nas sessões críticas.
