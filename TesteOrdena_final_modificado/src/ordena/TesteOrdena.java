package ordena;

public class TesteOrdena {

    public static void main(String[] args) {

        //define o tamanho dos datasets
        //compara o comportamento dos algoritmos em diferentes quantidades de dados
        int[] tamanhos = {
                10, 20, 30, 40, 50,
                60, 70, 80, 90, 100,
                1000, 2000, 3000, 4000, 5000,
                6000, 7000, 8000, 9000, 10000
        };

        Item[][] datasets = new Item[tamanhos.length][];

        for (int i = 0; i < tamanhos.length; i++) {

            //chama a classe utilidades, gera vetores preenchidos com números aleatórios
            datasets[i] = Utilidades.gerarVetor(tamanhos[i]);

            //imprime apenas os vetores até o tamanho 100
            if (tamanhos[i] <= 100) {

                System.out.println("Dataset tamanho " + tamanhos[i]);

                Utilidades.imprimirVetor(datasets[i]);

                System.out.println();
            }
        }

        System.out.println();
        System.out.println("RESULTADOS");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s %-20s%n",
                "Tamanho", "Bubble(ms)", "Insertion(ms)", "Shell(ms)");
        System.out.println("--------------------------------------------------------------------------------");

        double[] mediaBubble    = new double[tamanhos.length];
        double[] mediaInsertion = new double[tamanhos.length];
        double[] mediaShell     = new double[tamanhos.length];

        for (int i = 0; i < datasets.length; i++) {

            Item[] original = datasets[i];

            long somaBubble    = 0;
            long somaInsertion = 0;
            long somaShell     = 0;

            //faz com que cada algoritmo seja executado 100 vezes e depois calcula a média
            for (int execucao = 0; execucao < 100; execucao++) {

                //o nano time mede o tempo com alta precisão, a diferença entre o início e o fim representa o tempo gasto pelo algoritmo
                Item[] bubble = Utilidades.copiarVetor(original);
                long inicio = System.nanoTime();
                Ordena.bubbleSort(bubble);
                long fim = System.nanoTime();
                somaBubble += (fim - inicio);

                Item[] insertion = Utilidades.copiarVetor(original);
                inicio = System.nanoTime();
                Ordena.insertionSort(insertion);
                fim = System.nanoTime();
                somaInsertion += (fim - inicio);

                Item[] shell = Utilidades.copiarVetor(original);
                inicio = System.nanoTime();
                Ordena.shellSort(shell);
                fim = System.nanoTime();
                somaShell += (fim - inicio);
            }

            //soma todos os tempos, divide por 100 e converte mara milissegundos
            mediaBubble[i]    = (somaBubble    / 100.0) / 1_000_000.0;
            mediaInsertion[i] = (somaInsertion / 100.0) / 1_000_000.0;
            mediaShell[i]     = (somaShell     / 100.0) / 1_000_000.0;

            System.out.printf("%-10d %-20.6f %-20.6f %-20.6f%n",
                    original.length,
                    mediaBubble[i],
                    mediaInsertion[i],
                    mediaShell[i]);
        }

        //salva os resultados
        Utilidades.salvarResultados("resultados.txt", tamanhos,
                mediaBubble, mediaInsertion, mediaShell);
    }
}
