package Testes;

import org.junit.*;

import Projeto.LP2.Usuario;

public class TestaUsuario {
	private Usuario usuario;
	
	@Before
	public void criaUsuario() throws Exception{
		usuario = new Usuario("usuario", "email@fake.com", "123456", "123456", "de um a seis");
	}
	
	public void testaUsuario() {
		try{
			Assert.assertEquals("usuario", usuario.getNome());
			Assert.assertEquals( "email@fake.com", usuario.getEmail());
			Assert.assertEquals("123456", usuario.getSenha());
			Assert.assertEquals("de um a seis", usuario.getDica());
		}catch(Exception e){
			Assert.fail("Não Esperava exceção");
		}
		
		try{
			new Usuario("","email@fake.com", "123456", "123456", "de um a seis");
			Assert.fail("Esperava exceção de nome invalido");
		}catch(Exception e){
			Assert.assertEquals("Nome invalido", e.getMessage());
		}
		
		try{
			new Usuario("   ","email@fake.com", "123456", "123456", "de um a seis");
			Assert.fail("Esperava exceção de nome invalido");
		}catch(Exception e){
			Assert.assertEquals("Nome invalido", e.getMessage());
		}
		
		try{
			new Usuario("usuario","email@", "123456", "123456", "de um a seis");
			Assert.fail("Esperava exceção de email invalido");
		}catch(Exception e){
			Assert.assertEquals("Email invalido", e.getMessage());
		}
		
		try{
			new Usuario("usuario","   ", "123456", "123456", "de um a seis");
			Assert.fail("Esperava exceção de email invalido");
		}catch(Exception e){
			Assert.assertEquals("Email invalido", e.getMessage());
		}
		
		try{
			new Usuario("usuario","email@fake.com", "123456", "23456", "de um a seis");
			Assert.fail("Esperava exceção de senha invalida");
		}catch(Exception e){
			Assert.assertEquals("As senhas não coincidem", e.getMessage());
		}
		
		try{
			new Usuario("usuario","email@fake.com", "123", "123", "de um a seis");
			Assert.fail("Esperava exceção de senha invalida");
		}catch(Exception e){
			Assert.assertEquals("Senha invalida", e.getMessage());
		}
		try{
			 new Usuario("usuario", "email@fake.com", "123456789", "123456789", "de um a seis");
			Assert.fail("Esperava exceção de senha invalida");
		}catch(Exception e){
			Assert.assertEquals("Senha invalida", e.getMessage());
		}
		try{
			new Usuario("usuario", "email@fake.com", "123456", "123456", "");
			Assert.fail("Esperava exceção de dica invalida");
		}catch(Exception e){
			Assert.assertEquals("Dica invalida", e.getMessage());
		}
		try{
			new Usuario("usuario", "email@fake.com", "123456", "123456", "     ");
			Assert.fail("Esperava exceção de dica invalida");
		}catch(Exception e){
			Assert.assertEquals("Dica invalida", e.getMessage());
		}
	}
	
	@Test
	public void testaEquals() throws Exception{
		Assert.assertTrue(usuario.equals(new Usuario("usuario", "email@fake.com", "123456", "123456", "de um a seis")));
		Assert.assertTrue(usuario.equals(new Usuario("outro usuario", "email@fake.com", "678910", "678910", "de seis a dez")));
		Assert.assertFalse(usuario.equals(new Usuario("usuario", "email2@fake.com", "123456", "123456", "de um a seis")));
		
	}
	
	@Test
	public void testaToString() throws Exception{
		Assert.assertEquals("Nome: "+usuario.getNome()+"/"+"Email: "+usuario.getEmail(),usuario.toString());
	}

}
