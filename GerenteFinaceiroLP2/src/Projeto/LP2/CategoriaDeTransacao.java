package Projeto.LP2;

import java.io.Serializable;


public class CategoriaDeTransacao implements Serializable{
		private static final long serialVersionUID = 1L;
		private Cor cor;
		private String nome;
		
		public CategoriaDeTransacao(String nome, Cor cor) throws Exception{
			if(!testaString(nome)) throw new Exception("Nome invalido");
			this.nome = nome;
			this.cor = cor;
		}
		
		public boolean testaString(String string) {
			return !(string == null || string.trim().equals(""));
		}

		public String getNome(){
			return nome;
		}
		
		public void  setNome(String nome) throws Exception{
			if(!testaString(nome)) throw new Exception("Nome invalido");
			this.nome = nome;
		}

		public Cor getCor(){
			return cor;
		}
		public void  setCor(Cor cor){
			this.cor = cor;
		}
		
		@Override
		public String toString(){
			return "Categoria: "+nome+" "+cor;
		}
		
		@Override
		public boolean equals(Object obj){
			if(!(obj instanceof CategoriaDeTransacao))
				return false;
			CategoriaDeTransacao nova = (CategoriaDeTransacao) obj;
			return nome.equals(nova.getNome());
			
		}
	}
