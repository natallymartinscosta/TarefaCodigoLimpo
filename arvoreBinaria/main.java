package arvoreBinaria;

public class main {

	public static void main(String[] args) {
		arvoreBinaria ab = new arvoreBinaria();
		ab.insere(5);
		ab.insere(10);
		ab.insere(2);
		ab.insere(8);
		ab.insere(7);
		ab.insere(60);
		ab.insere(3);
		
//		ab.insere(ab.getRaiz(), 5);
//		ab.insere(ab.getRaiz(), 7);
//		ab.insere(ab.getRaiz(), 4);
//		ab.insere(ab.getRaiz(), 9);
//		ab.insere(ab.getRaiz(), 2);
		//ab.imprimeAux(ab.getRaiz());
		System.out.println("----");
//		ab.remove(ab.getRaiz(), null, 8);
//		ab.imprimeAux(ab.getRaiz());
//		System.out.println("----");
//		ab.remove(ab.getRaiz(), null, 2);
//		ab.imprimeAux(ab.getRaiz());
//		System.out.println("----");
//		ab.remove(ab.getRaiz(), null, 10);
//		ab.imprimeAux(ab.getRaiz());
//		System.out.println("----");
		ab.remove(ab.getRaiz(), null, 5);
		ab.valorMaxMin();
		ab.imprimeAux(ab.getRaiz());
		
		
		
	}

}