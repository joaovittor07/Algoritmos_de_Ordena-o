package RelatorioTecnico;

public class BubbleSort {

    // Método para ordenar o array usando Bubble Sort
    static int[] bubbleSort(int arr[], int n) {
        int i, j, temp;
        boolean trocou;
        int comparacoes = 0;
        int trocas = 0;
        
        // Loop externo para percorrer o array
        for (i = 0; i < n - 1; i++) {
            trocou = false;
            // Loop interno para comparar elementos e trocar se necessário
            for (j = 0; j < n - i - 1; j++) {
                comparacoes++;    // Contador de comparação
                if (arr[j] > arr[j + 1]) {
                    // Troca os elementos se o anterior for maior que o seguinte
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocou = true;
                    trocas++;    // Contador de Trocas
                }
            }
            // Se não houver trocas neste passo, o array já está ordenado
            if (!trocou)
                break;
        }
        
        // Retorna um array com o número de comparações e trocas realizadas
        return new int[]{comparacoes, trocas};  
    }
}