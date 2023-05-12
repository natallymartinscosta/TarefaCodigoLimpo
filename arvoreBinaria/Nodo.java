package arvoreBinaria;

public class Nodo {

	private int valor;
	private Nodo esquerda;
	private Nodo direita;

	public Nodo() {
		setValor(0);
		setEsquerda(null);
		setDireita(null);
	}

	public Nodo(int valor) {
		setValor(valor);
		setEsquerda(null);
		setDireita(null);
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Nodo getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Nodo esquerda) {
		this.esquerda = esquerda;
	}

	public Nodo getDireita() {
		return direita;
	}

	public void setDireita(Nodo direita) {
		this.direita = direita;
	}

}