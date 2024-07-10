package RelatorioTecnico;

import java.util.Arrays;

public class RadixSort {
    
    private static int comparacoes;
    private static int trocas;

    // Método principal para iniciar o Radix Sort e retornar contadores
    public static int[] radixSort(int[] arr, int tamanho) {
        comparacoes = 0;
        trocas = 0;

        // Encontra o valor máximo no array para determinar o número de dígitos
        int max = valueMaximo(arr, tamanho);

        // Realiza o counting sort para cada dígito, começando pelo dígito menos significativo
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, tamanho, exp);
        }

        return new int[] { comparacoes, trocas };
    }

    // Função para realizar o counting sort com base no dígito específico (exp)
    private static void countingSort(int[] arr, int tamanho, int exp) {
        int[] output = new int[tamanho];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Conta a ocorrência de cada dígito
        for (int i = 0; i < tamanho; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Ajusta o count para obter a posição correta de cada elemento no array de saída
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Constrói o array de saída usando o count ajustado
        for (int i = tamanho - 1; i >= 0; i--) {
            int digito = (arr[i] / exp) % 10;
            output[count[digito] - 1] = arr[i];
            count[digito]--;
            trocas++;  // Contador de Trocas
        }

        // Copia o array de saída de volta para o array original
        for (int i = 0; i < tamanho; i++) {
            arr[i] = output[i];
            trocas++;  
        }
    }

    // Função para encontrar o valor máximo no array
    private static int valueMaximo(int[] arr, int tamanho) {
        int max = arr[0];
        for (int i = 1; i < tamanho; i++) {
            comparacoes++;  // Contador de Comparações
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}