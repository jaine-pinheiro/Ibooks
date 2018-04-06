import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Carrinho {
	private ArrayList<ItemProduto> livrosDaSessao;
	
	public Carrinho() {
		livrosDaSessao = new ArrayList<ItemProduto>(); 
	}
	
	public Map<Integer, Livro> getLivrosDaSessao(){
		Map<Integer, Livro> livros = new HashMap<Integer, Livro>();
		for (ItemProduto itemProduto : livrosDaSessao) {
			livros.put(itemProduto.getLivro().getId(),itemProduto.getLivro());
		}
		return livros;
	}

	public ArrayList<ItemProduto> getItensDaSessao(){
		return livrosDaSessao;
	}
	
	public void adicionaNaSessao(Livro livro, Integer quantidade) {
		for (ItemProduto item : livrosDaSessao) {
			if(item.getLivro().equals(livro)) {
				item.setQuantidade(item.getQuantidade() + quantidade);
				return;
			}
		}
		livrosDaSessao.add(new ItemProduto(livro, quantidade));
	}

	public void removerLivroDaSessao(Livro livro, Integer quantidade) {
		for (ItemProduto item : livrosDaSessao) {
			if (item.getLivro().equals(livro)) {
				if (item.getQuantidade() - quantidade > 0) {
					item.setQuantidade(item.getQuantidade() - quantidade);
				} else {
					livrosDaSessao.remove(item);
				}
				break;
			}
		}
	}

	public void limparSessao(){
		livrosDaSessao.clear();
	}
}
