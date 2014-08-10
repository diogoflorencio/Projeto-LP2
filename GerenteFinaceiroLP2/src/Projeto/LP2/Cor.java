package Projeto.LP2;

public enum Cor {
	AMARELO(1), VERMELHO(2), AZUL(2), VERDE(3), LARANJA(4);
    
    private int valor;
    Cor(int valor) {
       this.valor = valor;
    }
    public int getValor() {
       return valor;
    }
   
 }

