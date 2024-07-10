package RelatorioTecnico;

import java.util.Arrays;
import java.util.Random;

public class TestesRelatorio {
		
    public static void main(String[] args) {
        int[] tamanhos = {100000, 1000000};
        String[] algoritmos = {"Bubble Sort", "Insertion Sort", "Merge Sort", "Quick Sort", "Selection Sort", "Radix Sort"};
        
        for (int tamanho : tamanhos) {
            System.out.println("Tamanho do Array: " + tamanho);
            System.out.println("----------------------------------------");
            
            // Arrays para cada tipo de teste
            int[] arrayOrdenado = new int[tamanho];
            int[] arrayInvertido = new int[tamanho];
            int[] arrayAleatorio = new int[tamanho];
            Random random = new Random();
            
            // Preenche os arrays com dados para cada tipo de teste
            for (int i = 0; i < tamanho; i++) {
                arrayOrdenado[i] = i;
                arrayInvertido[i] = tamanho - i;
                arrayAleatorio[i] = random.nextInt(tamanho);
            }
            
            // Itera sobre os algoritmos para cada tipo de array
            for (String algoritmo : algoritmos) {
                System.out.println("**" + algoritmo + "**");
                analisarDesempenho("Array Ordenado", arrayOrdenado, algoritmo);
                analisarDesempenho("Array Invertido", arrayInvertido, algoritmo);
                analisarDesempenho("Array Aleatório", arrayAleatorio, algoritmo);
                System.out.println("----------------------------------------");
            }
        }
    }

    private static void analisarDesempenho(String tipo, int[] array, String algoritmo) {
        int[] arrayTemporario = Arrays.copyOf(array, array.length);
        long inicioTempo = System.currentTimeMillis();
        int[] resultado;
        
        // Escolhe qual algoritmo executar com base no parâmetro 'algoritmo'
        switch (algoritmo) {
            case "Bubble Sort":
                resultado = BubbleSort.bubbleSort(arrayTemporario, arrayTemporario.length);
                break;
            case "Insertion Sort":
                resultado = InsertionSort.insertionSort(arrayTemporario, arrayTemporario.length);
                break;
            case "Merge Sort":
                resultado = MergeSort.mergeSort(arrayTemporario, arrayTemporario.length);
                break;
            case "Quick Sort":
                resultado = QuickSort.quickSort(arrayTemporario, arrayTemporario.length);
                break;
            case "Selection Sort":
                resultado = SelectionSort.selectionSort(arrayTemporario, arrayTemporario.length);
                break;
            case "Radix Sort":
                resultado = RadixSort.radixSort(arrayTemporario, arrayTemporario.length);
                break;
            default:
                throw new IllegalArgumentException("Algoritmo desconhecido: " + algoritmo);
        }
        
        long fimTempo = System.currentTimeMillis();
        
        System.out.println("----------------------------------------");
        System.out.print(tipo);
        System.out.println(" - Comparações: " + resultado[0]);
        System.out.println("               - Trocas: " + resultado[1]);
        System.out.println("               - Tempo: " + (fimTempo - inicioTempo) + " milissegundos");
    }
}
