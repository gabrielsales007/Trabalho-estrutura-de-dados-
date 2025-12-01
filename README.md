
# Análise de Desempenho de Estruturas de Dados em Java

Este repositório contém a implementação e análise comparativa de desempenho entre diferentes **estruturas de dados** e **algoritmos de ordenação**, utilizando a linguagem **Java**.  
O projeto foi desenvolvido com fins **acadêmicos**, visando o estudo prático da complexidade computacional e do impacto da escolha das estruturas de dados no desempenho de aplicações.

---

## 📚 Conteúdos Abordados

### Estruturas de Dados
- Vetor (Array Dinâmico – implementação própria)
- Árvore Binária de Busca (BST)
- Árvore AVL (Árvore Balanceada)

### Algoritmos de Ordenação
- Insertion Sort (simples)
- Merge Sort (avançado)

### Algoritmos de Busca
- Busca Sequencial
- Busca Binária (em vetor previamente ordenado)

---

## 🎯 Objetivo do Projeto

Avaliar, na prática, o desempenho das principais estruturas de dados quanto às operações de:

- Inserção
- Busca
- Ordenação

considerando diferentes:

- Tamanhos de entrada (100, 1.000 e 10.000 elementos)
- Ordens de inserção (ordenada, inversa e aleatória)

---

## ⚙️ Tecnologias Utilizadas

- Java (JDK 8 ou superior)
- jGRASP
- Git e GitHub

---

## 📂 Estrutura do Projeto

Todos os arquivos estão no mesmo diretório para facilitar a execução:

```

Main.java               => Classe principal que executa os testes
MyVector.java           => Implementação do vetor dinâmico
Sorts.java              => Algoritmos de ordenação
BSTree.java             => Implementação da Árvore Binária de Busca
AVLTree.java            => Implementação da Árvore AVL
DataGenerator.java     => Geração dos conjuntos de dados
InsertionOrder.java    => Enum com os tipos de ordem de inserção
README.md               => Documentação do projeto

````

---

## ▶️ Como Compilar e Executar

### ✅ Via Terminal

Abra o terminal dentro da pasta do projeto e execute:

```bash
javac Main.java
java Main
````

---

### ✅ Via jGRASP

1. Abra o jGRASP
2. Clique em **File → Open**
3. Selecione todos os arquivos `.java`
4. Clique com o botão direito em `Main.java`
5. Selecione **Compile**
6. Selecione **Run**

---

## 🧪 Metodologia de Testes

* Para cada cenário, os testes são executados **5 vezes**
* O resultado final exibido é a **média dos tempos**
* As buscas são realizadas para:

  * Primeiro elemento
  * Último elemento
  * Elemento central
  * Três valores aleatórios existentes
  * Um valor inexistente
* Os tempos são medidos com `System.nanoTime()`

---

## 📊 Resultados

Os tempos de execução são exibidos diretamente no **console** ao final da execução do programa, organizados por:

* Estrutura de dados
* Tipo de operação
* Tipo de ordem de inserção
* Tamanho do conjunto de dados

Os dados podem ser facilmente exportados para planilhas para geração de gráficos.

---

## 🧾 Padrões de Código

O projeto segue boas práticas de programação:

* Nomes de variáveis e métodos claros e objetivos
* Separação de responsabilidades por classe
* Métodos pequenos e bem definidos
* Código limpo, organizado e comentado
* Facilidade de manutenção e entendimento

---

## 👨‍🎓 Autor

**Gabriel Sales**
Curso: (Analise e desenvolvimento de sistemas)
Instituição: (UniFaminas)
Disciplina: Estrutura de Dados

---

## ⚠️ Observações

Este projeto possui finalidade **exclusivamente acadêmica** e foi desenvolvido para fins de aprendizado em **Análise de Algoritmos** e **Estruturas de Dados**.

---

```
```
