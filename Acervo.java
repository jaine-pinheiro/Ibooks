import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

public class Acervo {
	private Map<Integer, Livro> livrosDoAcervo;

	public Acervo() {
		livrosDoAcervo = new HashMap<Integer, Livro>();
	}
	
	public void geraAcervo() {
		Livro livro1 = new Livro("Spring MVC Framework", new BigDecimal("50.90"));
		Livro livro2 = new Livro("SOA aplicado", new BigDecimal("60.00"));
		Livro livro3 = new Livro("JSF e JPA", new BigDecimal("60.00"));

		livrosDoAcervo.put(livro1.getId(), livro1);
		livrosDoAcervo.put(livro2.getId(), livro2);
		livrosDoAcervo.put(livro3.getId(), livro3);
	}

	public Map<Integer, Livro> getLivrosDoAcervo() {
		return livrosDoAcervo;
	}
}