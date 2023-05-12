package arvoreBinaria;


public class arvoreBinaria {
	private Nodo raiz;

	public arvoreBinaria() {
		setRaiz(null);
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	// nao recursiva
	public void insere(int valor) {
		Nodo novo = new Nodo(valor);
		if (getRaiz() == null) {
			//System.out.println("Inseriu " + valor + "na raiz");
			setRaiz(novo);

		} else {
			Nodo aux = getRaiz();
			boolean inseriu = false;
			while (!inseriu) {
				if (novo.getValor() < aux.getValor()) {
					if (aux.getEsquerda() != null) {
						aux = aux.getEsquerda();
					} else {
						aux.setEsquerda(novo);
						inseriu = true;
					System.out.println("Inseriu " + valor + " a esquerda de " + aux.getValor());
					}
				} else if (novo.getValor() > aux.getValor()) {
					if (aux.getDireita() != null) {
						aux = aux.getDireita();
					} else {
						aux.setDireita(novo);
						inseriu = true;
					System.out.println("Inseriu " + valor + " a direita de " + aux.getValor());
					}
				}

			}
		}
	}

	// recursiva pois chama ele mesmo
	public void insere(Nodo aux, int valor) {
		if (aux == null) {
			setRaiz(new Nodo(valor));
			System.out.println("Inseriu " + valor + " na raiz");
		} else if (valor < aux.getValor()) {
			if (aux.getEsquerda() != null)
				insere(aux.getEsquerda(), valor);
			else {
				System.out.println("Inseriu " + valor + " a esquerda de "+ aux.getValor());
				aux.setEsquerda(new Nodo(valor));
			}

		} else if (valor > aux.getValor()) {
			if(aux.getDireita()!=null)
				insere(aux.getDireita(),valor);
			else {
				System.out.println("Inseriu " + valor + " a direita de "+ aux.getValor());
				aux.setDireita(new Nodo(valor));
			}
		}
	}
	
	public void remove(Nodo aux, Nodo pai, int Valor) {
		
		if (aux!=null) {
			//se encontrou, testa qual tipo de remoção
			if(aux.getValor() == Valor) {
				//testa se o aux e folha
				if(aux.getEsquerda()==null && aux.getDireita() == null) {
					removeFolha(aux,pai,Valor);
				}
				//se aux tiver apenas uma subárvore à esquerda
				else if(aux.getEsquerda()!= null && aux.getDireita()== null) {
					removeNodoSubArvoreEsquerda(aux,pai,Valor);	
				}
				//se aux tiver apenas uma subárvore à direita
				else if(aux.getEsquerda()==null && aux.getDireita()!=null) {
					removeNooSubArvoreDireita(aux,pai,Valor);	
				}
				//se o aux tiver duas subarvores
				else {
					removeNodosDuasSubArvores(aux,pai,Valor);	
				}
			}
			//se nao encontrou,procura à esquerda
			else if(aux.getValor()> Valor)
				remove(aux.getEsquerda(), aux,Valor);
			//se não enconrou à esqueda, procura à direita
			else if(aux.getValor()< Valor)
				remove(aux.getDireita(), aux, Valor);
		}
		else
			System.out.println("Valor não encontrado!");
	}
	
	private void removeNodosDuasSubArvores(Nodo aux, Nodo pai, int valor) {
		Nodo aux2= aux.getEsquerda();
		Nodo paiaux2= aux.getEsquerda();
	
		//procura o nodo mais a direita(aux2) e seu pai
		while(aux2.getDireita()!=null) {
		paiaux2= aux2;
		aux2= aux2.getDireita();
		}
	
		paiaux2.setDireita(aux2.getEsquerda());
		if(pai!=null) {
			if(aux.getValor()<pai.getValor()) 
				pai.setEsquerda(aux2);
			else 
				pai.setDireita(aux2);
		
	}
		else
			setRaiz(aux2); //se nao ele vai ser a raiz
		aux2.setDireita(aux.getDireita());
		if(aux2!= aux.getEsquerda())
			aux2.setEsquerda(aux.getEsquerda());
		aux=null;
		System.out.println("Nodo "+ valor + " removido!");
	}

	private void removeNooSubArvoreDireita(Nodo aux, Nodo pai, int valor) {
		if(pai!=null) {
			if(aux.getValor()<pai.getValor()) {
				pai.setEsquerda(aux.getDireita());
			}
			else {
				pai.setDireita(aux.getDireita());
			}
		}
		else {
			setRaiz(aux.getDireita());
			aux = null;
					System.out.println("Valor " + valor + " removido" );
		}
		
	}

	private void removeNodoSubArvoreEsquerda(Nodo aux, Nodo pai, int valor) {
		if(pai!=null) {
			if(aux.getValor()<pai.getValor()) {
				pai.setEsquerda(aux.getEsquerda());
			}
			else {
				pai.setDireita(aux.getEsquerda());
			}
		}
		else {
			setRaiz(aux.getEsquerda());
			aux = null;
					System.out.println("Valor " + valor + " removido" );
		}
		
	}

	private void removeFolha(Nodo aux, Nodo pai, int valor) {
		if(pai!=null) {
			if(aux.getValor()<pai.getValor()) {//se o valor do aux for menor uqe o valor do pai
				pai.setEsquerda(null);
			}
			else {
				pai.setDireita(null);
			}
		}
		else {
			setRaiz(null);
			aux= null;
			System.out.println("Valor: " + valor +" removido!");
		}
		
	}

	public void imprimeAux(Nodo aux) {

		if(aux!=null) {
			imprime(aux); //chama recusiva
		}
		else {
			System.out.println("Árvore vazia");
		}
	}
	
	public void imprime(Nodo aux) {
		// é recursiva pois ela se chama
		if (aux != null) {
			System.out.println(aux.getValor());
			imprime(aux.getEsquerda());
			imprime(aux.getDireita());
		}
		//não pode ter um else para imprimir 'arvore vazia' pois irá imprimi no console a mensagem dps da folha
		
	}

	// O VALOR MÍNIMO É O QUE ESTÁ MAIS NA ESQUERDA
	public Nodo min() {
		Nodo atual = raiz;
		Nodo anterior = null;

		while (atual != null) {
			anterior = atual;
			atual = atual.getEsquerda();
		}
		return anterior;
	}

	// O VALOR MÁXIMO É O QUE ESTÁ MAIS NA DIREITA
	public Nodo max() {
		Nodo atual = raiz;
		Nodo anterior = null;

		while (atual != null) {
			anterior = atual;
			atual = atual.getDireita();
		}
		return anterior;
	}

	// IMPRIME OS VALORES MAX E MIN
	public void valorMaxMin() {
		System.out.println("-----------------");
		System.out.println("O valor mínimo é: " + min().getValor());
		System.out.println("O valor máximo é: " + max().getValor());
		System.out.println("-----------------");
	}
	
}