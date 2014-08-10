package Testes;

import org.junit.*;

import Projeto.LP2.CategoriaDeTransacao;
import Projeto.LP2.Cor;
import Projeto.LP2.Despesa;
import Projeto.LP2.GerenteDeTransacao;
import Projeto.LP2.Recorrencia;
import Projeto.LP2.Transacao;

public class TestaGerenteDeTransacao {
	private Transacao transacao;
	private GerenteDeTransacao gerente;
	
	@Before
	public void criaGerenteDeTransacao() throws Exception{
		transacao = new Despesa("descricao qualquer", 10, Recorrencia.NENHUMA, new CategoriaDeTransacao("Categoria", Cor.AMARELO));
		gerente = new GerenteDeTransacao("email@fake.com");
	}

	@Test
	public void testaGerenteDeTransacao() throws Exception {
		Assert.assertTrue(gerente.adicionaTransacao(transacao));
		Assert.assertFalse(gerente.adicionaTransacao(transacao));
		Assert.assertTrue(gerente.adicionaTransacao(new Despesa("descricao qualquer", 9, Recorrencia.NENHUMA, new CategoriaDeTransacao("Categoria", Cor.AMARELO))));
		// pesquisa
		Assert.assertEquals(2, gerente.pesquisaPorCategoria(new CategoriaDeTransacao("Categoria", Cor.AMARELO)).size());
		Assert.assertEquals(0, gerente.pesquisaPorCategoria(new CategoriaDeTransacao("Categoria2", Cor.AZUL)).size());
		Assert.assertEquals(2, gerente.pesquisaPorData(transacao.get_Data()).size());
		Assert.assertEquals(0, gerente.pesquisaPorData("data fake").size());
		Assert.assertEquals(2, gerente.pesquisaPorRecorrencia(Recorrencia.NENHUMA).size());
		Assert.assertEquals(0, gerente.pesquisaPorRecorrencia(Recorrencia.MENSAL).size());
		//remove
		gerente.removeTransacao(new Despesa("descricao qualquer", 9, Recorrencia.NENHUMA, new CategoriaDeTransacao("Categoria", Cor.AMARELO)));
		Assert.assertEquals(1, gerente.pesquisaPorCategoria(new CategoriaDeTransacao("Categoria", Cor.AMARELO)).size());
		gerente.salvar();
	}

}
