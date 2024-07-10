package RelatorioTecnico;

public class InsertionSort {
    
    // Método para ordenar o array usando Insertion Sort
    static int[] insertionSort(int arr[], int n) {
        int i, j, chave;
        int comparacoes = 0;
        int trocas = 0;
        
        // Percorre o array a partir do segundo elemento
        for (i = 1; i < n; i++) {
            chave = arr[i];
            j = i - 1;
            comparacoes++; // Contador de Comparações
            
            // Move os elementos maiores que a chave uma posição à frente
            while (j >= 0 && arr[j] > chave) {
                arr[j + 1] = arr[j];
                j = j - 1;
                trocas++;
                comparacoes++;
            }
            
            arr[j + 1] = chave;
            trocas++; // Contador de Trocas
        }
        
        // Retorna um array com o número de comparações e trocas realizadas
        return new int[]{comparacoes, trocas};
    }
}