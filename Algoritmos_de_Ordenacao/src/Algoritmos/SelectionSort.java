package RelatorioTecnico;

public class SelectionSort {
    
    // Método para ordenar o array usando Selection Sort e retornar contadores
    static int[] selectionSort(int arr[], int n) {
        int i, j, indiceMenor;
        int comparacoes = 0;
        int trocas = 0;
        
        // Percorre todo o array
        for (i = 0; i < n - 1; i++) {
            indiceMenor = i;
            
            // Encontra o índice do menor elemento restante no array
            for (j = i + 1; j < n; j++) {
                comparacoes++;  // Contador de Comparações
                if (arr[j] < arr[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            
            // Troca o elemento atual pelo menor encontrado, se necessário
            if (indiceMenor != i) {
                int temp = arr[indiceMenor];
                arr[indiceMenor] = arr[i];
                arr[i] = temp;
                trocas++;  // Contador de Trocas
            }
        }
        
        // Retorna um array com o número de comparações e trocas realizadas
        return new int[]{comparacoes, trocas};
    }
}
