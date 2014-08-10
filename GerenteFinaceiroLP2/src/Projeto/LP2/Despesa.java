package Projeto.LP2;

import java.io.Serializable;

public class Despesa extends Transacao implements Serializable{
	private static final long serialVersionUID = 1L;

	public Despesa(String descricao, double valor, Recorrencia rec, CategoriaDeTransacao categoria) throws Exception {
		super(descricao,valor,rec, categoria);
		geraCodigo("D");
		
	}

}
