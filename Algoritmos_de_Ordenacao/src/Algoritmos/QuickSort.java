package RelatorioTecnico;

public class QuickSort {

    private static int[] array;
    private static int comparacoes;
    private static int trocas;

    // Método principal para iniciar o Quick Sort e retornar contadores
    public static int[] quickSort(int[] arr, int length) {
        array = arr;
        comparacoes = 0;
        trocas = 0;
        quickSortHelper(0, length - 1);
        return new int[] { comparacoes, trocas };
    }

    // Função auxiliar recursiva para o Quick Sort
    private static void quickSortHelper(int baixo, int alto) {
        while (baixo < alto) {
            int indicePivo = partition(baixo, alto);

            // Escolhe a parte menor para a próxima chamada recursiva
            if (indicePivo - baixo < alto - indicePivo) {
                quickSortHelper(baixo, indicePivo - 1);
                baixo = indicePivo + 1;
            } else {
                quickSortHelper(indicePivo + 1, alto);
                alto = indicePivo - 1;
            }
        }
    }

    // Função para particionar o array e retornar o índice do pivo
    private static int partition(int baixo, int alto) {
        int pivo = array[alto];
        int i = baixo - 1;

        for (int j = baixo; j < alto; j++) {
            comparacoes++;  // Contador de Comparações
            if (array[j] < pivo) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, alto);
        return i + 1;
    }

    // Função para trocar dois elementos no array
    private static void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        trocas++;  // Contador de Trocas
    }
}