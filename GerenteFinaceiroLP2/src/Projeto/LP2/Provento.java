package Projeto.LP2;

import java.io.Serializable;

public class Provento extends Transacao implements Serializable{
	private static final long serialVersionUID = 1L;

	public Provento(String descricao, double valor, Recorrencia rec, CategoriaDeTransacao categoria) throws Exception {
		super(descricao,valor,rec,categoria);
		geraCodigo("P");
		
	}

}

