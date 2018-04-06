import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Menu {

	private Map<Character, String> opcoesMenu;
	private Scanner sc;

	public Menu() {
		sc = new Scanner(System.in);
		opcoesMenu = new HashMap<Character, String>();
		opcoesMenu.put('A', "Listar Livros do Catalogo");
		opcoesMenu.put('C', "Exibir Carrinho");
		opcoesMenu.put('I', "Incluir Livro no carrinho");
		opcoesMenu.put('R', "Remover Itens do Carrinho");
		opcoesMenu.put('L', "Limpar Carrinho");
		opcoesMenu.put('E', "Sair");
	}

	public void imprimirMenu() {
		for (Character opcao : opcoesMenu.keySet()) {
			System.out.printf("%c - %s \n", opcao, opcoesMenu.get(opcao));
		}
		System.out.println("\n");
	}

	public Character selecionaOpcaoMenu() {
		try {
			Character opcao = sc.next().charAt(0);
			opcao = Character.toUpperCase(opcao);
			if (opcoesMenu.get(opcao) != null)
				return opcao;
			throw new IllegalArgumentException("Opção selecionada é inválida");
		} catch (Exception e) {
			throw new IllegalArgumentException("Opção inválida. Selecione alguma das opções abaixo:");
		}
	}
 
	public Integer getQuantidade(String msg) {
		System.out.println(msg);
		try {
			String scQtd = sc.next();
			int quantidadeLivros = Integer.parseInt(scQtd.toString());

			if (quantidadeLivros > 0) 
				return quantidadeLivros;
			throw new IllegalArgumentException("Digite valor maior que zero.");
		} catch (Exception e) {
			throw new IllegalArgumentException("Opção Invalida.");
		}
	}
	
	public void printLivros(Map<Integer, Livro> livros) {		
		if(!livros.isEmpty()) {
			for (Map.Entry<Integer, Livro> livro : livros.entrySet()) {
				System.out.println(livro.getValue().toString());
			}
		}
	}
	
	public void printLivros(ArrayList<ItemProduto> livros) {		
		if(livros.isEmpty()) {
			System.out.println("Seu carrinho esta vazio.");
		} else {
			BigDecimal valorTotal = new BigDecimal("0.0");
			for (ItemProduto item : livros) {
				valorTotal = valorTotal.add(item.getValorTotalItem());
				System.out.println(item.toString());
			}
			System.out.println("Valor total do carrinho: R$ " + valorTotal);
		}
	}

	public Livro selectLivro(Map<Integer, Livro> livros) {	
		System.out.println("Selecione o Id do livro: ");
		int opcaoId = 0;
		try {
			String IdDoLivro = sc.next();
			opcaoId = Integer.parseInt(IdDoLivro);
		} catch (Exception e) {
			throw new IllegalArgumentException("Id invalido. Digite um valor inteiro");
		}
		
		if (livros.keySet().contains(opcaoId))
			return livros.get(opcaoId);
		throw new IllegalArgumentException("Livro não encontrado.");
	}
}