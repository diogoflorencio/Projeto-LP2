package Testes;

import org.junit.*;

import Projeto.LP2.GerenteDeUsuario;
import Projeto.LP2.Usuario;


public class TestaGerenteDeUsuario {
	private GerenteDeUsuario gerente;
	private Usuario usuario;
	
	@Before
	public void criaGerenteDeUsuario() throws Exception{
		gerente = new GerenteDeUsuario();
		usuario = new Usuario("usuario", "email@fake.com", "123456", "123456", "de um a seis");
	}

	@Test
	public void testaAdicionarUsuario() throws Exception{
		Assert.assertTrue(gerente.adicionaUsuario(usuario));
		Assert.assertFalse(gerente.adicionaUsuario(usuario));
		//pesquisa
		Assert.assertEquals(usuario, gerente.pesquisaUsuario("email@fake.com"));
		Assert.assertEquals(null, gerente.pesquisaUsuario("email2@fake.com"));
		//login
		Assert.assertEquals(usuario, gerente.login("email@fake.com", "123456"));
		
		try{
			Assert.assertEquals(usuario, gerente.login("email@fake.com", "123456"));
		}catch(Exception e){
			Assert.fail("Não Esperava exceção");
		}
		
		try{
			gerente.login("email2@fake.com", "123456");
			Assert.fail("Esperava exceção de usuario inexistente");
		}catch(Exception e){
			Assert.assertEquals("Usuario inexistente", e.getMessage());
		}
		
		try{
			gerente.login("email@fake.com", "123457");
			Assert.fail("Esperava exceção de senha incorreta");
		}catch(Exception e){
			Assert.assertEquals("Senha incorreta", e.getMessage());
		}
		Assert.assertTrue(gerente.salvar());
	}
	
	
	/*@Test
	public void testaLogin() {
		try{
			gerente.login("email2@fake.com", "123456");
			Assert.fail("Esperava exceção de usuario inexistente");
		}catch(Exception e){
			Assert.assertEquals("Usuario inexistente", e.getMessage());
		}
		
		try{
			gerente.login("email@fake.com", "123457");
			Assert.fail("Esperava exceção de senha incorreta");
		}catch(Exception e){
			Assert.assertEquals("Senha incorreta", e.getMessage());
		}
		
	}*/
	
	/*@Test
	public void testaPesquisaUsuario() throws Exception{
		Assert.assertEquals(usuario, gerente.pesquisaUsuario("email@fake.com"));
		
	}*/
	
	
	
}
