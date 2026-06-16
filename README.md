## Integrantes do grupo: Felipe Vieira, Isaac Luís e Victor Martins
# 1. Enunciado do problema
Objetivo: Implementar os seguintes métodos de ordenação: BubbleSort, InsertionSort, ShellSort.  

Requisitos de Dados: Criar dois conjuntos de vetores de dados (dataset) com valores aleatórios,
sendo que o tamanho de cada vetor é dado a seguir de acordo com os dois conjuntos:  

Dataset 1: 10 – 20 – 30 – 40 – 50 – 60 – 70 – 80 – 90 - 100  
Dataset 2: 1000 - 2000 – 3000 – 4000 – 5000 – 6000 – 7000 – 8000 – 9000 - 10000  

Regras de Execução: Cada método de ordenação deve receber os 20 vetores como entrada (receber
sempre os mesmos vetores) e devolver o vetor ordenado. Para cada execução tomar o tempo de
execução (calcular a média de 100 execuções).  

Requisitos de Estrutura: O projeto deverá conter no mínimo 4 classes:  

Classe Ordena: contém as implementações dos algoritmos de ordenação;  
Classe Item: contém o objeto a ser ordenado;  
Classe Utilidades: contém a geração dos vetores, leitura e escrita de arquivos e demais utilidades;  
Classe TesteOrdena: realiza a tomada de tempo  
# 2. Visão Geral
Este projeto consiste na implementação e análise comparativa de três algoritmos clássicos de ordenação da
ciência da computação: BubbleSort, InsertionSort e ShellSort. O objetivo principal é avaliar a eficiência
empírica de cada algoritmo quando submetidos a diferentes volumes de dados empacotados em objetos
complexos, medindo o tempo médio de processamento ao longo de múltiplas execuções contínuas.  
# 3. Estrutura de classes  
O sistema foi desenvolvido utilizando o paradigma de Orientação a Objetos na linguagem Java, estruturado
em quatro classes principais para garantir uma clara separação de responsabilidades:  

**Classe: Item**  
Responsabilidade: Representa a unidade básica de dados que
será ordenada dentro dos arranjos,
encapsulando a chave de ordenação  
Principais métodos: Atributo: chave (int)  
Métodos: getChave(), setChave()  

**Classe: Ordena**  
Responsabilidade: Funciona como uma biblioteca de
algoritmos, contendo as lógicas puras de
ordenação de forma estática  
Principais métodos: bubbleSort(Item[] vetor)  
insertionSort(Item[] vetor)  
shellSort(Item[] vetor)  

**Classe: Utilidades**  
Responsabilidades: Concentra rotinas de apoio, como a geração
automatizada de vetores com valores
aleatórios.  
Principais métodos: gerarVetorAleatorio(int
tamanho)  

**Classe: TesteOrdena**  
Responsabilidades: Ponto de entrada do sistema (main).
Coordena a geração dos conjuntos de
dados, o controle rigoroso de tempo e o
cálculo das médias.  
Principais métodos: main(String[] args)  

# 4. Algoritmos Implementados e Complexidade
##  4.1 BubbleSort
Percorre o vetor repetidamente, comparando elementos adjacentes e trocando-os de posição se estiverem na
ordem errada. O maior elemento "flutua" para o final a cada iteração completa. Possui complexidade de
tempo de O(n²) no caso médio e pior caso.
##  4.2 InsertionSort
Constrói a matriz ordenada final um elemento por vez, consumindo um elemento de entrada a cada iteração
e inserindo-o na sua posição correta dentro da fração já ordenada do vetor. Embora possua complexidade de
pior caso de O(n²), é extremamente eficiente para pequenos volumes de dados.
##  4.3 ShellSort
Uma extensão refinada do InsertionSort que permite a troca de elementos distantes. O vetor é segmentado
em subvetores baseados em um espaçamento (gap) que decresce progressivamente até atingir 1. Possui
complexidade típica entre O(n log² n) e O(n¹.⁵), dependendo da sequência de gaps.
# 5. Metodologia de Testes e Geração de Dados
Para assegurar a integridade científica e evitar distorções estatísticas, adotou-se a seguinte metodologia:  

**Isolamento de Variáveis**: Para cada tamanho de vetor, um conjunto único de dados aleatórios foi gerado.
Os três algoritmos foram testados exatamente com a mesma entrada original. 

**Prevenção contra Pré-Ordenação (Clonagem)**: Como os testes exigem 100 repetições por tamanho
para o cálculo da média, uma cópia idêntica do vetor original (via Arrays.copyOf) foi fornecida ao
algoritmo antes de disparar o cronômetro. Isso garante que o algoritmo nunca trabalhe com dados pré
ordenados pelas execuções anteriores.  

**Alta Precisão Cronométrica**: A medição de tempo utilizou o relógio de alta resolução do sistema através do método System.nanoTime(), convertendo a média final acumulada para milissegundos (ms).
# 6. Resultados de Desempenho Obtidos
Abaixo está consolidada a tabela de tempos médios obtidos após as 100 execuções para cada tamanho de
vetor (Datasets 1 e 2):  
<img width="544" height="625" alt="image" src="https://github.com/user-attachments/assets/0ffc0ab8-599a-4189-90b6-4d18596ac95f" />
# 7. Conclusões Experimentais
**Crescimento Quadrático do BubbleSort**: Conforme previsto pela análise assintótica, o BubbleSort
demonstrou um aumento severo de tempo à medida que o tamanho do vetor escalou. Para 10.000
elementos, atingiu expressivos 91,69 ms, evidenciando o alto custo de suas trocas sucessivas em
memória.  

**Vantagem Prática do InsertionSort**: Apesar de compartilhar do mesmo limite superior teórico do
BubbleSort (O(n²)), o InsertionSort completou o maior vetor em apenas 19,41 ms (cerca de 4,7 vezes
mais veloz). Isso decorre de seu menor número de movimentações e melhor aproveitamento de
subarrays parcialmente ordenados.  

**Supremacia Absoluta do ShellSort**: O ShellSort exibiu um comportamento de alta performance e
estabilidade impecável. Ao saltar de 1.000 para 10.000 itens, seu tempo variou de meros 0,07 ms para
apenas 1,18 ms. A quebra de barreiras de posições distantes por meio dos múltiplos gaps provou ser a
estratégia mais otimizada para conjuntos de dados de larga escala.  
<img width="1400" height="600" alt="graficoprojeto" src="https://github.com/user-attachments/assets/7f3e36b6-6f52-40dc-b29b-a8b0a1bb94be" />
