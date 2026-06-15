package ordena;

public class Ordena {

    public static Item[] bubbleSort(Item[] vetor) {

        int n = vetor.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (vetor[j].getValor() > vetor[j + 1].getValor()) {

                    Item aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }

        return vetor;
    }

    public static Item[] insertionSort(Item[] vetor) {

        for (int i = 1; i < vetor.length; i++) {

            Item chave = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j].getValor() > chave.getValor()) {

                vetor[j + 1] = vetor[j];
                j--;
            }

            vetor[j + 1] = chave;
        }

        return vetor;
    }

    public static Item[] shellSort(Item[] vetor) {

        int n = vetor.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {

                Item temp = vetor[i];
                int j;

                for (j = i; j >= gap && vetor[j - gap].getValor() > temp.getValor(); j -= gap) {

                    vetor[j] = vetor[j - gap];
                }

                vetor[j] = temp;
            }
        }

        return vetor;
    }
}
