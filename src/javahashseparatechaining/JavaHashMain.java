package javahashseparatechaining;

import java.util.Locale;
import java.util.Scanner;

public class JavaHashMain<T> {

    private static int menu(Scanner scanner) {
        System.out.println("\n\t\t*** IFSULDEMINAS - CAMPUS MACHADO ***");
        System.out.println("\t\t*** Estrutura de Dados I ***");
        System.out.println("\t\t*** HASH ENCADEADO - Separate Chaining ***");
        System.out.println("1-Inserir / Atualizar");
        System.out.println("2-Remover");
        System.out.println("3-Buscar (obter valor)");
        System.out.println("4-Alterar (se existir)");
        System.out.println("0-Sair");
        System.out.print("Escolha uma opcao: ");
        // Tratamento para evitar erro se o usuário digitar algo que não seja um número
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.next(); // Limpa o buffer
            System.out.print("Escolha uma opcao: ");
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tamanho inicial da tabela: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        
        CustomHashMap<String> meuHashMap = new CustomHashMap<>(n);
        int op;
        do {
            System.out.println(meuHashMap.toString());
            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine(); 
            
            op = menu(scanner);
            scanner.nextLine(); // Limpar o buffer do menu
            
            long chave;
            
            switch (op) {
                case 1: // Inserir / Atualizar
                    System.out.print("Entre com a chave (long): ");
                    chave = scanner.nextLong();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Entre com o valor (String): ");
                    String nome = scanner.nextLine();
                    meuHashMap.put(chave, nome);
                    break;

                case 2: // Remover
                    System.out.print("Chave para remover: ");
                    chave = scanner.nextLong();
                    scanner.nextLine(); // Limpar o buffer
                    boolean removeu = meuHashMap.remove(chave);
                    if (!removeu) {
                        System.out.println("Chave nao existente para remocao.");
                    } else {
                        System.out.println("Chave removida com sucesso! :)");
                    }
                    break;

                case 3: // Buscar (usando GET)
                    System.out.print("Chave para busca: ");
                    chave = scanner.nextLong();
                    scanner.nextLine(); // Limpar o buffer
                    String valorEncontrado = meuHashMap.get(chave);
                    if (valorEncontrado == null) {
                        System.out.println("Chave nao encontrada:(");
                    } else {
                        System.out.println("Valor encontrado: '" + valorEncontrado + "'");
                    }
                    break;
                case 4:
                    System.out.print("Chave para alterar: ");
                    chave = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Novo valor: ");
                    String novoValor = scanner.nextLine();
                    meuHashMap.replace(chave, novoValor); 
    
    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
            
        } while (op != 0);

        scanner.close();
    }
}