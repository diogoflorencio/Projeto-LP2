package Projeto.LP2;

import java.io.Serializable;
import java.util.regex.*;

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nome, email, senha, dica;
	
	public Usuario(String nome, String email, String senha, String confirmasenha, String dica) throws Exception {
		if(!testaString(nome)) throw new Exception("Nome invalido");
		if(!testaString(dica)) throw new Exception("Dica invalida");
		testaEmail(email);
		confirmaSenha(senha, confirmasenha);
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dica = dica;
	}

	public void confirmaSenha(String senha, String confirmasenha) throws Exception{
		if(!testaString(senha)||senha.length()<6 || senha.length()>8)throw new Exception("Senha invalida");
		if(!senha.equals(confirmasenha))throw new Exception("As senhas não coincidem");
	}
	public void testaEmail(String email) throws Exception {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		if(!matcher.matches())throw new Exception("Email invalido");
		
	}
	public boolean testaString(String string) {
		return !(string == null || string.trim().equals(""));
			
		
	}
	public String getEmail(){
		return email;
	}
	/*public void setEmail(String email) throws Exception{
		testaEmail(email);
	}*/
	public String getNome(){
		return nome;
	}
	public void setNome(String nome) throws Exception{
		if(testaString(nome))throw new Exception("Dica invalida");
		this.nome = nome;
	}
	public String getSenha(){
		return senha;
	}
	public void setSenha(String senha, String confirmasenha) throws Exception{
		confirmaSenha(senha,confirmasenha);
		this.senha = senha;
	}
	public String getDica(){
		return dica;
	}
	public void setDica(String dica)throws Exception{
		if(!testaString(dica))throw new Exception("Dica invalida");
		this.dica = dica;
		
	}
	
	
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Usuario))return false;	
		Usuario novo = (Usuario) obj;
		if(!email.equals(novo.getEmail()))return false;	
		return true;
	}
	@Override
	public String toString(){
		return "Nome: "+nome+"/"+"Email: "+email;
	}

}
