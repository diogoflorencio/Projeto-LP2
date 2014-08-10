package Testes;

import org.junit.*;

import Projeto.LP2.CategoriaDeTransacao;
import Projeto.LP2.Cor;

public class TestaCategoriaDeTramsacao {
	@Test
	public void testaCategoriaDeTramsacao() throws Exception {
		try{
			new CategoriaDeTransacao("Categoria", Cor.AMARELO);
		}catch(Exception e){
			Assert.fail("Não esperava exceção");
		}
		
		try{
			new CategoriaDeTransacao("  ", Cor.AMARELO);
			Assert.fail("Esperava exceção de nome invalido");
		}catch(Exception e){
			Assert.assertEquals("Nome invalido", e.getMessage());
		}
		
		try{
			new CategoriaDeTransacao("", Cor.AMARELO);
			Assert.fail("Esperava exceção de nome invalido");
		}catch(Exception e){
			Assert.assertEquals("Nome invalido", e.getMessage());
		}
		//equals
		Assert.assertTrue(new CategoriaDeTransacao("Categoria", Cor.AMARELO).equals(new CategoriaDeTransacao("Categoria", Cor.AMARELO)));
		Assert.assertTrue(new CategoriaDeTransacao("Categoria", Cor.AMARELO).equals(new CategoriaDeTransacao("Categoria", Cor.AZUL)));
		Assert.assertFalse(new CategoriaDeTransacao("Categoria", Cor.AMARELO).equals(new CategoriaDeTransacao("Categoria2", Cor.AMARELO)));
	}

}
