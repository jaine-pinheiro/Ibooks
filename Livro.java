import java.math.BigDecimal;

public class Livro {
	private Integer id;
	private static Integer contador = 0;
	private String titulo;
	private BigDecimal valorUnitario;
	
	public Integer getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void staticetTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public Livro(String titulo, BigDecimal valorUnitario) {
		this.titulo = titulo;
		this.valorUnitario = valorUnitario;
		this.contador++;
		this.id = this.contador;
	}	
	
	@Override
	public String toString(){
		return "ID do Livro: " + this.id + " - Nome: " + this.titulo + " - Valor: R$ " + this.valorUnitario;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj.getClass().equals(Livro.class) && ((Livro)obj).getId().equals(getId()));
	}
}