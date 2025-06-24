
# Atividade: Implementando Operações em HashMap com Hash Encadeado

## 📝 Descrição do Projeto

Este repositório contém a implementação de uma estrutura de dados de `HashMap` customizada em Java, utilizando a técnica de **Hash Encadeado (Separate Chaining)** para tratamento de colisões. O projeto foi desenvolvido como atividade para a disciplina de Estrutura de Dados I no IFSULDEMINAS - Campus Machado.

O objetivo principal é demonstrar o funcionamento interno de uma tabela hash, incluindo a lógica de inserção, busca, remoção e alteração de dados, além de analisar a complexidade de cada operação através de um contador de comparações.

## ✨ Funcionalidades

  - **Estrutura de Tabela Hash**: Implementação de uma tabela hash usando um array de `LinkedLists` para armazenar os dados.
  - **Tratamento de Colisões**: Utilização da técnica de **Encadeamento Separado** (Separate Chaining), onde múltiplos elementos com o mesmo índice de hash são armazenados em uma lista encadeada.
  - **Operações Essenciais**:
      - `put(key, value)`: Insere um novo elemento ou atualiza o valor se a chave já existir.
      - `get(key)`: Retorna o valor associado a uma chave.
      - `remove(key)`: Remove um elemento com base na sua chave.
      - `replace(key, value)`: Altera o valor de uma chave apenas se ela já existir no mapa.
      - `containsKey(key)`: Verifica a existência de uma chave.
  - **Análise de Complexidade**: Um contador exibe o **número de comparações** de chave realizadas em cada operação, permitindo uma análise prática da eficiência.
  - **Redimensionamento Dinâmico (Resize)**: A tabela aumenta de tamanho automaticamente quando o fator de carga (75%) é atingido, para garantir a performance e evitar a degradação para O(n).
  - **Interface Interativa**: Uma interface de linha de comando (CLI) permite que o usuário interaja com a estrutura de dados de forma simples e intuitiva.

## 🛠️ Tecnologias Utilizadas

  - **Java**: Todo o projeto foi desenvolvido em linguagem Java, utilizando apenas bibliotecas padrão do JDK.

## 🚀 Como Executar o Projeto

Para executar este projeto, siga os passos abaixo:

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/GabrielSouzaCruz/Atividade-Implementando-Operacoes-em-HashMap-com-Hash-Encadeado.git
    ```

2.  **Acesse o diretório do projeto:**

    ```bash
    cd Atividade-Implementando-Operacoes-em-HashMap-com-Hash-Encadeado
    ```

3.  **Abra em sua IDE preferida:**

      - Abra o projeto em uma IDE Java, como IntelliJ IDEA, Eclipse ou VS Code com o pacote de extensões para Java.

4.  **Compile e execute:**

      - Localize o arquivo `JavaHashMain.java` dentro do pacote `javahashseparatechaining`.
      - Compile e execute o método `main()` contido neste arquivo.

5.  **Interaja com o programa:**

      - O terminal exibirá um menu interativo para que você possa testar as funcionalidades da tabela hash.

## ⚙️ Funcionalidades do Menu

O programa oferece um menu de operações para manipular a tabela hash:

  - **1 - Inserir / Atualizar**: Adiciona um novo par chave-valor. Se a chave já existir, seu valor é atualizado.
  - **2 - Remover**: Remove um par chave-valor com base na chave fornecida.
  - **3 - Buscar (obter valor)**: Procura por uma chave e, se encontrada, exibe o valor associado a ela.
  - **4 - Alterar (se existir)**: Altera o valor de uma chave existente. Se a chave não for encontrada, nenhuma operação é realizada.
  - **0 - Sair**: Encerra a aplicação.

A cada operação, o console exibirá o número de comparações realizadas, e antes de cada menu, o estado atual completo da tabela hash será impresso.

## 📂 Estrutura do Código

O código-fonte está organizado em dois arquivos principais dentro do pacote `javahashseparatechaining`:

  - **`CustomHashMap.java`**: Contém toda a lógica da estrutura de dados. Aqui estão a classe interna `Dado`, a tabela, a função de hash e todos os métodos de manipulação (`put`, `get`, `remove`, `replace`, etc.).

  - **`JavaHashMain.java`**: Responsável pela interface com o usuário. Contém o método `main`, o menu de opções e a lógica para capturar a entrada do usuário e interagir com a classe `CustomHashMap`.

## 👨‍💻 Autor

**`Gabriel de Souza Cruz`**
