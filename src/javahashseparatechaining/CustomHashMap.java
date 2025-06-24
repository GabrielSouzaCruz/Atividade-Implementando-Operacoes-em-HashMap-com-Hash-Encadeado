
package javahashseparatechaining;

import java.util.LinkedList;

public class CustomHashMap<T> {
    private LinkedList<Dado<T>>[] tabela;
    private int tamanho;
    private int numElementos;
    private int comparacoes;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private static class Dado<T> {
        long key;
        T value;

        // Construtor da classe 'Dado' que inicializa a chave e o valor.
        Dado(long key, T value) {
            this.key = key;
            this.value = value;
        }
    }

    // Construtor da classe CustomHashMap. É chamado quando um novo mapa é criado.
    public CustomHashMap(int tamanho) {
        this.tamanho = tamanho;
        tabela = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    // Método privado que calcula o índice da tabela para uma determinada chave.
    private int funcaoHash(long chave) {
        return (int) (chave % tamanho);
    }

    // Método para adicionar um par chave-valor.
    public void put(long key, T value) {
        if ((double) numElementos / tamanho >= DEFAULT_LOAD_FACTOR) {
            resize();
        }
        Dado<T> dado = new Dado<>(key, value);
        int indice = funcaoHash(key);
        tabela[indice].add(dado);
        numElementos++;
    }

    // Método que verifica se uma determinada chave existe no mapa.
    public boolean containsKey(long key) {
        int indice = funcaoHash(key);
        for (Dado<T> item : tabela[indice]) {
            if (item.key == key) {
                return true;
            }
        }
        return false;
    }

    // Método para remover um par chave-valor com base na chave.
    public boolean remove(long key) {
        int indice = funcaoHash(key);
        for (Dado<T> item : tabela[indice]) {
            if (item.key == key) {
                tabela[indice].remove(item);
                numElementos--;
                return true;
            }
        }
        return false;
    }

    // Método para obter (buscar) o valor associado a uma chave.
    public T get(long key) {
        // Zera o contador de comparações para esta operação específica.
        comparacoes = 0;
        // Calcula o índice da tabela onde a chave deveria estar.
        int indice = funcaoHash(key);
        // Percorre cada 'item' da lista encadeada no índice calculado.
        for (Dado<T> item : tabela[indice]) {
            // Incrementa o contador a cada chave que é comparada.
            comparacoes++;
            // Verifica se a chave do 'item' atual é a chave que estamos procurando.
            if (item.key == key) {
                // Se encontrou, imprime uma mensagem de sucesso com o número de comparações.
                System.out.println("Chave " + key + " encontrada. Comparações: " + comparacoes);
                // Retorna o valor associado à chave encontrada.
                return item.value;
            }
        }
        // Se o laço terminar, a chave não foi encontrada. Imprime uma mensagem de falha.
        System.out.println("Chave " + key + " não encontrada. Comparações: " + comparacoes);
        // Retorna 'null' para indicar que nenhum valor foi encontrado para a chave.
        return null;
    }

    // Método para substituir o valor de uma chave que já existe.
    public void replace(long key, T value) {
        // Zera o contador de comparações para esta operação.
        comparacoes = 0;
        // Calcula o índice onde a chave deveria estar.
        int indice = funcaoHash(key);

        // Percorre cada 'item' na lista encadeada do índice.
        for (Dado<T> item : tabela[indice]) {
            // A cada passo, incrementa o contador de comparações.
            comparacoes++;
            // Verifica se a chave do 'item' atual é a chave que queremos alterar.
            if (item.key == key) {
                // Se encontrou, atualiza o valor do 'item' com o novo valor fornecido.
                item.value = value;
                // Imprime uma mensagem de sucesso com o número de comparações.
                System.out.println("Chave " + key + " alterada. Comparações: " + comparacoes);
                // Usa 'return' para sair do método, pois a alteração já foi feita.
                return;
            }
        }
        // Se o laço terminar, a chave não foi encontrada para alteração.
        // Imprime uma mensagem de falha com o número de comparações realizadas na busca.
        System.out.println("Chave " + key + " não encontrada para alteração. Comparações: " + comparacoes);
    }

    // Método privado para redimensionar a tabela quando ela fica muito cheia.
    private void resize() {
        int novoTamanho = tamanho * 2;
        this.tamanho = novoTamanho;
        LinkedList<Dado<T>>[] novaTabela = new LinkedList[novoTamanho];
        for (int i = 0; i < novoTamanho; i++) {
            novaTabela[i] = new LinkedList<>();
        }

        for (LinkedList<Dado<T>> lista : tabela) {
            for (Dado<T> dado : lista) {
                 int novoIndice = funcaoHash(dado.key);
                novaTabela[novoIndice].add(dado);
            }
        }

        this.tabela = novaTabela;
        System.out.println("Tabela redimensionada para " + novoTamanho + " elementos.");
    }

    // Sobrescreve o método 'toString' para fornecer uma representação textual do HashMap.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append("[").append(i).append("]");
            for (Dado<T> item : tabela[i]) {
                sb.append(" -> ").append(item.key).append(":").append(item.value);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}