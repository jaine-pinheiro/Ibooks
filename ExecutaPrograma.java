import java.util.Map;
import java.util.ArrayList;

public class ExecutaPrograma {
	public static void main(String[] args) {
		Menu menuPrincipal = new Menu();
		Acervo acervo = new Acervo();
		acervo.geraAcervo();
		Carrinho carrinho = new Carrinho();
		Map<Integer, Livro> livros = acervo.getLivrosDoAcervo();

		Character opcao = 'X';
		do {
			menuPrincipal.imprimirMenu();
			try { 
				opcao = menuPrincipal.selecionaOpcaoMenu();
				switch (opcao) {
				case 'A':
					menuPrincipal.printLivros(livros);
					break;
				case 'C':
					ArrayList<ItemProduto> exibirLivros = carrinho.getItensDaSessao();
					menuPrincipal.printLivros(exibirLivros); 
					break; 
				case 'I': 
					Map<Integer, Livro> livro = acervo.getLivrosDoAcervo();
					menuPrincipal.printLivros(livros);
					Livro inserirLivro = null; 
					do {
						try {
							inserirLivro = menuPrincipal.selectLivro(livro);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					} while (inserirLivro == null);
					Integer quantidadeAdiciona = menuPrincipal.getQuantidade("Digite a quantidade de livros para adicionar no carrinho: ");
					carrinho.adicionaNaSessao(inserirLivro, quantidadeAdiciona);
					break;
				case 'R': 
					Map<Integer, Livro> livrosDaSessao = carrinho.getLivrosDaSessao();
					menuPrincipal.printLivros(livrosDaSessao);
					Livro removeLivro = null;
					do {
						try {
							removeLivro = menuPrincipal.selectLivro(livrosDaSessao);
							Integer quantidadeRemove = menuPrincipal.getQuantidade("Digite a quantidade de livros para remover do carrinho: ");
							carrinho.removerLivroDaSessao(removeLivro, quantidadeRemove);
						
						} catch (Exception e) {
							System.out.println(e.getMessage());
							break;
						}
					} while (removeLivro == null);
					break;
				case 'L':
					carrinho.limparSessao();
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (opcao != 'E');
	}
}