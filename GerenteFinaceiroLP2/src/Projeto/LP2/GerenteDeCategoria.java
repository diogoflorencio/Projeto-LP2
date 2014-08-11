package Projeto.LP2;

import java.util.*;

import projetop2.utils.ArquivoDeDados;

public class GerenteDeCategoria {
	private List<CategoriaDeTransacao> categorias;
	private ArquivoDeDados<List<CategoriaDeTransacao>> arquivoDeCategoria;
	
	public GerenteDeCategoria(String email){
		arquivoDeCategoria =  new ArquivoDeDados<List<CategoriaDeTransacao>>("["+email+"]"+".categorias");
		categorias = new ArrayList<CategoriaDeTransacao>();
	}
	
	public boolean carrega()throws Exception{
		categorias = arquivoDeCategoria.carregaObjetos();
		return true;
	}
	public boolean salvar() throws Exception{
		arquivoDeCategoria.salvaObjeto(categorias);
		return true;
	}
	public boolean deletaCategorias(){
		return arquivoDeCategoria.limpaArquivo();
	}
	
	public boolean adicionaCategorias(CategoriaDeTransacao categoria){
		Iterator<CategoriaDeTransacao> it = categorias.iterator();
		while (it.hasNext()){
			if(categoria.equals(it.next()))
				return false;
		}
		categorias.add(categoria);
		return true;
	}
	public boolean removeCategoria(CategoriaDeTransacao categoria){
		return categorias.remove(categoria);
	}
	
	public List<CategoriaDeTransacao> pesquisaCategoriaPorCor(Cor cor){
		Iterator<CategoriaDeTransacao> it = categorias.iterator();
		List<CategoriaDeTransacao> pesquisa = new ArrayList<CategoriaDeTransacao>();
		CategoriaDeTransacao categoria;
		while (it.hasNext()){
			categoria = it.next();
			if (cor.equals(categoria.getCor()))
				pesquisa.add(categoria);
		}
		return pesquisa;
}
	public CategoriaDeTransacao pesquisaCategoriaPorNome(String nome){
		Iterator<CategoriaDeTransacao> it = categorias.iterator();
		CategoriaDeTransacao categoria;
		while (it.hasNext()){
			categoria = it.next();
			if (nome.equals(categoria.getNome()))
					return categoria;
		}
		return null;
}
	
	public List<CategoriaDeTransacao> getCategorias(){
		return categorias;
	}
}
	

