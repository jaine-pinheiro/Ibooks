import java.math.BigDecimal;

public class ItemProduto {
	private Livro livro;
	private Integer quantidade;
	
	public ItemProduto(Livro livro, Integer quantidade) {
		setLivro(livro);
		setQuantidade(quantidade);
	}
	
	public ItemProduto() {
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public BigDecimal getValorTotalItem() {
		BigDecimal valorUnitario = getLivro().getValorUnitario();
		BigDecimal quantidade = BigDecimal.valueOf(getQuantidade());
		return valorUnitario.multiply(quantidade);		
	}
	
	@Override
	public String toString() {
		return String.format("%s - Quantidade de Livros: %d", this.livro, this.quantidade);
	}
}
