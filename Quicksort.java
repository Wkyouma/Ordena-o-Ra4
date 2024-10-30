import java.util.Random;

public class Quicksort {

    //declaração das variáveis auxiliares
    int pivo;
    int esquerda = 0;
    int direita = 0;
    int listaf[];
    int trocas = 0;
    int interacoes = 0;

    //função quicksort
    public void quicksort(int[] lista, int inicio, int tamanho) {
        // atribui os valores corretos as váriaveis auxiliares, valores fornecidos por parâmetro
        pivo = lista[inicio];
        esquerda = inicio;
        direita = tamanho;

        //Loop principal
        while (esquerda <= direita) {
            interacoes++;

            //compara elemento na posição esquerda com pivo, caso ele seja menor que o pivo passa para o próximo elemento
            //incrementa contador de interações
            while (lista[esquerda] < pivo) {
                esquerda++;
                interacoes++;
            }
            //compara elemento na posição direita com pivo, caso ele seja maior que pivo passa ao próximo elemento
            //incrementa contador de interações
            while (lista[direita] > pivo) {
                direita--;
                interacoes++;
            }
            //Troca os elementos direita e esquerda de lugar
            //incrementa contador de trocas
            //passa esquerda a próxima posição
            //passa direita a próxima posição
            if (esquerda <= direita) {
                int temp = lista[esquerda];
                lista[esquerda] = lista[direita];
                lista[direita] = temp;
                trocas++;
                esquerda++;
                direita--;
            }
        }

        //Função recursiva, reinicia o loop com direita como tamanho máximo
        if (inicio < direita) {
            quicksort(lista, inicio, direita);
        }
        //Função recursiva, reinicia o loop com esquerda como parâmetro de inicio
        if (esquerda < tamanho) {
            quicksort(lista, esquerda, tamanho);
        } 
        //caso não haja ordenação necessária será aplicada lista a lista final.
        else {
            listaf = lista;
        }
    }

    //função para impressão da lista final
    public void imprime() {
        for (int num : listaf) {
            System.out.println(num + " , ");
        }
    }

    //função principal
    public static void main(String[] args) {
        //randomiza os numeros e estabelece tamanho da lista de elementos.
        Random random = new Random(10);
        int[] numbers = new int[100000];
        for (int i = 0; i < 100000; i++) {
            numbers[i] = random.nextInt();
        }
        //inicia a classe Quicksort
        Quicksort qs = new Quicksort();
        //contador de tempo inicial
        long inicioTemp = System.currentTimeMillis();
        //Realiza operação de sort
        qs.quicksort(numbers, 0, 99999);
        //contador de tempo final
        long finalTemp = System.currentTimeMillis();
        //impressões: tempo decorrido, numero de trocas, numero de interações
        System.out.println("Tempo: " + (finalTemp - inicioTemp) + " ms");
        System.out.println("Trocas: " + qs.trocas);
        System.out.println("Iterações: " + qs.interacoes);
        
    }
}
