package Testes;

import org.junit.*;

import Projeto.LP2.CategoriaDeTransacao;
import Projeto.LP2.Cor;
import Projeto.LP2.GerenteDeCategoria;

public class TestaGerenteDeCategorias {
	
	private GerenteDeCategoria gerente;
	private CategoriaDeTransacao categoria;
	
	@Before
	public void criaGerenteDeUsuario() throws Exception{
		gerente = new GerenteDeCategoria("email@fake.com");
		categoria = new CategoriaDeTransacao("categoria",Cor.AZUL);
	}

	@Test
	public void testaAdicionaCategoria() throws Exception {
		Assert.assertTrue(gerente.adicionaCategorias(categoria));
		Assert.assertFalse(gerente.adicionaCategorias(categoria));
		Assert.assertTrue(gerente.adicionaCategorias(new CategoriaDeTransacao("categoria2",Cor.AZUL)));
		Assert.assertTrue(gerente.salvar());
	}
	
	@Test
	public void testaPesquisas() throws Exception {
		Assert.assertTrue(gerente.carrega());
		Assert.assertEquals(1, gerente.pesquisaCategoriaPorCor(Cor.AZUL).size());//
		Assert.assertEquals(0, gerente.pesquisaCategoriaPorCor(Cor.AMARELO).size());
		Assert.assertEquals(categoria, gerente.pesquisaCategoriaPorNome("categoria"));
		Assert.assertEquals(null, gerente.pesquisaCategoriaPorNome("categotiafake"));
	}
	
	@Test 
	public void testaRemove() throws Exception{
		gerente.carrega();
		gerente.removeCategoria(new CategoriaDeTransacao("categoria2",Cor.AZUL));
		Assert.assertEquals(null, gerente.pesquisaCategoriaPorNome("categoria2"));
		Assert.assertEquals(1, gerente.pesquisaCategoriaPorCor(Cor.AZUL).size());
		Assert.assertTrue(gerente.salvar());
	}

}
