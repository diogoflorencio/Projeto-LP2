package Projeto.LP2;

import java.util.*;

import projetop2.utils.ArquivoDeDados;

public class GerenteDeUsuario {
	private ArquivoDeDados<List<Usuario>> arquivoDeUsuarios;
	private List<Usuario> usuarios;
	
	public GerenteDeUsuario() throws Exception{
		arquivoDeUsuarios = new ArquivoDeDados<List<Usuario>>("arquivo");
		usuarios = new ArrayList<Usuario>();
	}
	
	public boolean carrega() throws Exception{
		usuarios = arquivoDeUsuarios.carregaObjetos();
		return true;
	}
	public boolean salvar() throws Exception{
		arquivoDeUsuarios.salvaObjeto(usuarios);
		return true;
	}
	public boolean deletaUsuarios(){
		return arquivoDeUsuarios.limpaArquivo();
	}
	
	public boolean adicionaUsuario(Usuario usuario){
		Iterator<Usuario> it =  usuarios.iterator();
		while (it.hasNext())if(it.next().getEmail().equals(usuario.getEmail()))return false;
		usuarios.add(usuario);
		return true;
	}
	public boolean removeUsuario(Usuario usuario){
		return usuarios.remove(usuario);
	}
	
	public Usuario pesquisaUsuario(String email){
		Iterator<Usuario> it =  usuarios.iterator();
		Usuario usuario;
		while (it.hasNext()){
			usuario = it.next();
			if(email.equals(usuario.getEmail()))return usuario;
		}return null;
	}
	public Usuario login(String email, String senha) throws Exception{
		Iterator<Usuario> it =  usuarios.iterator();
		Usuario usuario;
		while (it.hasNext()){
			usuario = it.next();
			if(email.equals(usuario.getEmail())){
				if(!senha.equals(usuario.getSenha()))throw new Exception("Senha incorreta");
				return usuario;
			}
		}throw new Exception("Usuario inexistente");
	}
	
	public List<Usuario> getUsuarios(){
		return usuarios;
	}
}
