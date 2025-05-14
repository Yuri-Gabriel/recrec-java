package main;

import java.text.Normalizer;
import java.util.Scanner;

import main.estrutura.stack.Stack;

public class App {

	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		// questao01(scan);
		// questao02(scan);
		// questao03(scan);
		// questao04(scan);
		questao05(scan);
	}

	public static void questao01(Scanner scan) {
		Stack<String> stack = new Stack<String>();
		String livro = "";
		int option = -1;
		do {
			System.out.println("[0] Inserir um livro");
			System.out.println("[1] Consultar um livro");
			System.out.println("[2] Remover um livro");
			System.out.println("[3] Esvaziar um livro");
			System.out.println("[4] Sair");

			option = getIntInput(0, 4);

			switch (option) {
				case 0:
					System.out.print("Digite o nome do livro: ");
					livro = scan.nextLine();
					stack.add(livro);
					System.out.println("Livro '" + livro + "' adicionado!");
					livro = "";
					break;
				case 1:
					if (stack.isEmpty()) {
						System.out.println("A pilha está vazia");
						break;
					}
					System.out.print("Digite o nome do livro que deseja consultar: ");
					livro = scan.nextLine();
					boolean encontrado = false;
					while (stack.haveNext()) {
						encontrado = stack.current.value.equals(livro);
						if (encontrado)
							break;
					}
					if (encontrado) {
						System.out.println("Este livro está na pilha");
					} else {
						System.out.println("Este livro não está na pilha");
					}
					break;
				case 2:
					livro = stack.pop();
					System.out.println("Livro '" + livro + "' removido!");
					livro = "";
					break;
				case 3:
					stack.clear();
					System.out.println("Pilha esvaziada");
					break;
			}
		} while (option != 4);
	}

	public static void questao02(Scanner scan) {
		Stack<Character> stack = new Stack<Character>();
		System.out.println("Teste de palindromo!");
		System.out.print("Digite uma palavra: ");
		String palavra = scan.nextLine();

		palavra = Normalizer.normalize(palavra.trim(), Normalizer.Form.NFD);
		palavra = palavra.replaceAll("[^\\p{ASCII}]", "");

		char[] letras = palavra.toCharArray();

		for (char letra : letras) {
			stack.add(letra);
		}

		Stack<Character> stackReverso = new Stack<Character>();
		for (int i = letras.length - 1; i >= 0; i--) {
			stackReverso.add(letras[i]);
		}

		boolean igual = false;
		for (int i = 0; i < stack.lenght; i++) {
			igual = stack.get(i).equals(stackReverso.get(i));
			if (!igual)
				break;
		}
		if (igual) {
			System.out.println("A palavra '" + palavra + "' é um palindromo");
		} else {
			System.out.println("A palavra '" + palavra + "' não é um palindromo");
		}
	}

	public static void questao03(Scanner scan) {
		Stack<String> stack = new Stack<String>();
		int option = -1;
		String tarefa = "";
		do {
			System.out.println("[0] Inserir uma tarefa");
			System.out.println("[1] Obter próxima tarefa");
			System.out.println("[2] Sair");
			option = getIntInput(0, 2);
			switch (option) {
				case 0:
					System.out.print("Digite a tarefa que deverá ser realizada: ");
					tarefa = scan.nextLine();
					stack.add(tarefa);
					System.out.println("Tarefa '" + tarefa + "' adicionada");
					break;
				case 1:
					tarefa = stack.pop();
					if (tarefa != null) {
						System.out.println("A próxima tarefa é '" + tarefa + "'");
					} else {
						System.out.println("Sem tarefas");
					}

					break;
			}
		} while (option != 2);
	}

	public static void questao04(Scanner scan) {
		Stack<String> stack = null;
		int option = -1;
		String pagina = "";
		do {
			System.out.println("[0] Inicializar pilha");
			System.out.println("[1] Adicionar pagina");
			System.out.println("[2] Romover pagina");
			System.out.println("[3] Sair");
			option = getIntInput(0, 3);
			switch (option) {
				case 0:
					stack = new Stack<String>();
					System.out.println("Pilha inicializada!");
					break;
				case 1:
					if (stack == null) {
						System.out.println("A pilha precisa ser inicializada!");
						break;
					}

					System.out.print("Digite o titulo da página que visitou: ");
					pagina = scan.nextLine();
					stack.add(pagina);
					System.out.println("Pagina '" + pagina + "' adicionada");
					break;
				case 2:
					if (stack == null) {
						System.out.println("A pilha precisa ser inicializada!");
						break;
					}

					pagina = stack.pop();
					if (pagina == null) {
						System.out.println("Sem paginas para serem removidas");
					} else {
						System.out.println("Pagina '" + pagina + "' removida");
					}

					break;
			}
		} while (option != 3);
	}

	public static void questao05(Scanner scan) {
		Stack<String> stack = null;
		int option = -1;
		String etapa = "";
		do {
			System.out.println("[0] Inicializar pilha");
			System.out.println("[1] Adicionar etapa");
			System.out.println("[2] Romover etapa");
			System.out.println("[3] Visualizar etapas");
			System.out.println("[4] Sair");
			option = getIntInput(0, 4);
			switch (option) {
				case 0:
					stack = new Stack<String>();
					System.out.println("Pilha inicializada!");
					break;
				case 1:
					if (stack == null) {
						System.out.println("A pilha precisa ser inicializada!");
						break;
					}

					System.out.print("Digite a etapa a ser realizada: ");
					etapa = scan.nextLine();
					stack.add(etapa);
					System.out.println("Etapa '" + etapa + "' adicionada");
					break;
				case 2:
					if (stack == null) {
						System.out.println("A pilha precisa ser inicializada!");
						break;
					}

					etapa = stack.pop();
					if (etapa == null) {
						System.out.println("Sem etapas para serem removidas");
					} else {
						System.out.println("Etapa '" + etapa + "' removida");
					}

					break;
				case 3:
					if (stack == null) {
						System.out.println("A pilha precisa ser inicializada!");
						break;
					}

					if (stack.isEmpty()) {
						System.out.println("A pilha está vazia");
					} else {
						System.out.println("As etapas são: ");
						stack.show();
					}
					break;
			}
		} while (option != 4);

		if (stack != null) {
			if (!stack.isEmpty()) {
				System.out.println("As etapas são: ");
				stack.show();
				do {
					System.out.println("[0] Realizar próxima etapa");
					System.out.println("[1] Sair");
					option = getIntInput(0, 1);
					if (option == 0) {
						etapa = stack.pop();
						if(etapa != null) {
							System.out.println("A etapa a ser feita é: '" + etapa + "'");
						} else {
							System.out.println("Todas a etapas foram realizadas!");
							break;
						}
						
					}
				} while (option != 1);
			}
		}

	}

	private static int getIntInput(int min, int max) {
		int option = -1;
		do {
			try {
				System.out.print("Sua escolha: ");
				option = scan.nextInt();
			} catch (Exception err) {
				System.out.println("Opção inválida, tente novamente");
				scan.next();
			}
		} while (option < min || option > max);
		scan.nextLine();
		return option;
	}
}
