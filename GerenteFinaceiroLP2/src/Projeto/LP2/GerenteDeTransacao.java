package Projeto.LP2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import projetop2.utils.ArquivoDeDados;

public class GerenteDeTransacao {
	private List<Transacao> transacoes;
	private ArquivoDeDados<List<Transacao>> arquivoDeTransacao;
	
	public GerenteDeTransacao(String email){
		arquivoDeTransacao =  new ArquivoDeDados<List<Transacao>>("["+email+"]"+".transacoes");
		transacoes = new ArrayList<Transacao>();
		
	}
	
	public boolean carrega() throws Exception{
 		transacoes = arquivoDeTransacao.carregaObjetos();
 		return true;
		
	}
	public boolean salvar()throws Exception{
		arquivoDeTransacao.salvaObjeto(transacoes);
		return true;
	
	}
	public boolean deletaTransacoes(Transacao transacao){
		return transacoes.remove(transacao);
	}

	public boolean adicionaTransacao(Transacao transacao ){
		Iterator<Transacao> it = transacoes.iterator();
		while (it.hasNext())if(transacao.equals(it.next()))return false;
		transacoes.add(transacao);
		return true;
	}
	public boolean removeTransacao(Transacao transacao ){
		return transacoes.remove(transacao);
	}
	
	public ArrayList<Transacao> pesquisaPorCategoria( CategoriaDeTransacao categoria){
		Iterator<Transacao> it = transacoes.iterator();
		ArrayList<Transacao> pesquisa = new ArrayList<Transacao>();
		Transacao transacao;
		while (it.hasNext()){
			transacao = it.next();
			if (categoria.equals(transacao.get_Categoria()))
				pesquisa.add(transacao);
		}
		return pesquisa;
	}
	public ArrayList<Transacao> pesquisaPorData(String data){
		Iterator<Transacao> it = transacoes.iterator();
		ArrayList<Transacao> pesquisa = new ArrayList<Transacao>();
		Transacao transacao;
		while (it.hasNext()){
			transacao = it.next();
			if (data.equals(transacao.get_Data()))
				pesquisa.add(transacao);
		}
		return pesquisa;
	}
	public ArrayList<Transacao> pesquisaPorRecorrencia(Recorrencia rec){
		Iterator<Transacao> it = transacoes.iterator();
		ArrayList<Transacao> pesquisa = new ArrayList<Transacao>();
		Transacao transacao;
		while (it.hasNext()){
			transacao = it.next();
			if (rec.equals(transacao.get_Recorrencia()))
				pesquisa.add(transacao);
		}
		return pesquisa;
	}
	public Transacao pesquisaTransacao(String codigo){
		Iterator<Transacao> it = transacoes.iterator();
		Transacao transacao;
		while (it.hasNext()){
			transacao = it.next();
			if (codigo == transacao.get_Codigo())
				return transacao;
		}
		return null;
	}
		
	public List<Transacao> getTransacoes(){
		return transacoes;
	}
}
