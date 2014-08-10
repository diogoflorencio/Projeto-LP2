package Projeto.LP2;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transacao implements Serializable{
	private static final long serialVersionUID = 1L;
	private Recorrencia recorrencia;
	private CategoriaDeTransacao categoria;
	private String descricao, data;
	protected String codigo;
	private double valor;


	public Transacao(String descricao,double valor, Recorrencia rec, CategoriaDeTransacao categoria) throws Exception{
		if(valor<0) throw new Exception("Valor de transação invalido");
		if(!testaString(descricao)) throw new Exception("Descrição invalido");
		this.descricao = descricao;
		this.valor = valor;
		recorrencia = rec;
		this.categoria = categoria;
		insereData();
	}

	public boolean testaString(String string) {
		return !(string == null || string.trim().equals(""));
	}

	private void insereData(){
		SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss - dd/MM/yyyy");
		data = dt.format(new Date());
	}
	public String get_Data(){
		return data;
	}

	public String get_Descricao(){
		return descricao;
	}
	public void set_Descricao(String novaDescricao) throws Exception{
		if(!testaString(descricao)) throw new Exception("Descrição invalido");
		descricao = novaDescricao;
	}

	public Recorrencia get_Recorrencia(){
		return recorrencia;
	}
	public void set_Recorrencia(Recorrencia rec){
		recorrencia = rec;
	}

	public double get_Valor(){
		return valor;
	}
	public void set_valor(double valor){
		this.valor = valor;
	}

	public CategoriaDeTransacao get_Categoria(){
		return categoria;
	}
	public void set_Categoria(CategoriaDeTransacao categoria){
		this.categoria = categoria;
	}

	public void geraCodigo(String codigo){
		Date agora = new Date();  
		DateFormat f24h = new SimpleDateFormat("dMyy/HHmm");
		codigo = "codigo"+(f24h.format(agora));
	}
	public String get_Codigo(){
		return codigo;
	}

	@Override
	public String toString(){
		return data+" "+" valor: "+valor+ " categoria: " + categoria+
				" recorrencia: " +recorrencia+ " descrição: "+ descricao;
	}

	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof Transacao))
			return false;
		Transacao nova = (Transacao) obj;
		return (data.equals(nova.get_Data())&&valor == nova.get_Valor()&&categoria.equals(nova.get_Categoria())&&
				recorrencia.equals(nova.get_Recorrencia()));
	}
}
