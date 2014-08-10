package Testes;

import org.junit.*;

import Projeto.LP2.CategoriaDeTransacao;
import Projeto.LP2.Cor;
import Projeto.LP2.Despesa;
import Projeto.LP2.Recorrencia;

public class TestaTransacao {

	@Test
	public void testaTransacao() throws Exception {
		try{
			new Despesa("descricao qualquer", 10, Recorrencia.NENHUMA, new CategoriaDeTransacao("Categoria", Cor.AMARELO));
		}catch(Exception e){
			Assert.fail("N�o esperava exce��o");
		}
		
		try{
			new Despesa("     ", 10, Recorrencia.NENHUMA, new CategoriaDeTransacao("Categoria", Cor.AMARELO));
			Assert.fail("Esperava exce��o");
		}catch(Exception e){
			Assert.assertEquals("Descri��o invalido", e.getMessage());
		}
		
		try{
			new Despesa("descricao qualquer", 10, Recorrencia.NENHUMA, new CategoriaDeTransacao("Categoria", Cor.AMARELO));
		}catch(Exception e){
			Assert.fail("N�o esperava exce��o");
		}
		
		try{
			new Despesa("     ", 10, Recorrencia.NENHUMA, new CategoriaDeTransacao("Categoria", Cor.AMARELO));
			Assert.fail("Esperava exce��o");
		}catch(Exception e){
			Assert.assertEquals("Descri��o invalido", e.getMessage());
		}
		
		//equals
		
		Assert.assertTrue(new Despesa("descricao qualquer", 10, Recorrencia.NENHUMA, new CategoriaDeTransacao("Categoria", Cor.AMARELO)).equals(new Despesa("descricao qualquer", 10, Recorrencia.NENHUMA, new CategoriaDeTransacao("Categoria", Cor.AMARELO))));
		Assert.assertTrue(new Despesa("descricao diferente", 10, Recorrencia.NENHUMA, new CategoriaDeTransacao("Categoria", Cor.AMARELO)).equals(new Despesa("descricao qualquer", 10, Recorrencia.NENHUMA, new CategoriaDeTransacao("Categoria", Cor.AMARELO))));
		Assert.assertFalse(new Despesa("descricao qualquer", 10, Recorrencia.SEMANAL, new CategoriaDeTransacao("Categoria", Cor.AMARELO)).equals(new Despesa("descricao qualquer", 10, Recorrencia.NENHUMA, new CategoriaDeTransacao("Categoria", Cor.AMARELO))));
		Assert.assertFalse(new Despesa("descricao qualquer", 10, Recorrencia.NENHUMA, new CategoriaDeTransacao("Categoria2", Cor.AMARELO)).equals(new Despesa("descricao qualquer", 10, Recorrencia.NENHUMA, new CategoriaDeTransacao("Categoria", Cor.AMARELO))));
	}

}
