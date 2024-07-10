package RelatorioTecnico;

public class MergeSort {

    // Variáveis estáticas para contar comparações e trocas
    static int comparacoes = 0;
    static int trocas = 0;

    // Método principal para iniciar o Merge Sort e retornar contadores
    static int[] mergeSort(int arr[], int n) {
        comparacoes = 0;
        trocas = 0;
        mergeSort(arr, 0, n - 1);
        return new int[]{comparacoes, trocas};
    }

    // Função recursiva para dividir e ordenar o array
    static void mergeSort(int arr[], int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            mergeSort(arr, esquerda, meio);
            mergeSort(arr, meio + 1, direita);
            merge(arr, esquerda, meio, direita);
        }
    }

    // Função para mesclar dois subarrays ordenados
    static void merge(int arr[], int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] arrEsquerda = new int[n1];
        int[] arrDireita = new int[n2];

        // Copia os elementos para os arrays temporários
        for (int i = 0; i < n1; ++i) {
            arrEsquerda[i] = arr[esquerda + i];
        }
        for (int j = 0; j < n2; ++j) {
            arrDireita[j] = arr[meio + 1 + j];
        }

        // Índices para percorrer os arrays temporários e o array principal
        int i = 0, j = 0;
        int k = esquerda;

        // Combina os arrays temporários de volta ao array principal
        while (i < n1 && j < n2) {
            comparacoes++;  // Contador de comparações
            if (arrEsquerda[i] <= arrDireita[j]) {
                arr[k] = arrEsquerda[i];
                i++;
            } else {
                arr[k] = arrDireita[j];
                j++;
                trocas += (meio - esquerda + 1 - i); // Contador de trocas
            }
            k++;
        }

        // Copia os elementos restantes do array esquerdo, se houver
        while (i < n1) {
            arr[k] = arrEsquerda[i];
            i++;
            k++;
        }

        // Copia os elementos restantes do array direito, se houver
        while (j < n2) {
            arr[k] = arrDireita[j];
            j++;
            k++;
        }
    }
}