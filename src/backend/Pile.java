package backend;

import java.util.ArrayList;

public class Pile<T> {
	protected ArrayList <T> pile;

	public Pile () {
		pile = new ArrayList <>();
	}

	// methode push pour inserer un element 
	public void push(T a){
		pile.add(a);

	}

	//methode drop pour recuperer le dernier element entrer
	public T drop() {
		if (pile.isEmpty() == true) {
			System.out.println ("La pile est vide");
			return null;
		}

		return pile.get(pile.size() - 1);
}

	//methode pop supprimer le dernier élément entrer
	public T pop() {
		if (pile.isEmpty() == true) {
			System.out.println ("La pile est vide");
			return null;
		}

		return pile.remove(pile.size()-1);
	}

	//methode pour avoir la taille d'une pile
	public int len() {
		if (pile.isEmpty() == true) {
			System.out.println ("La pile est vide");
			return -1;
		}

		return pile.size();
	}

	public boolean isEmpty() {
		if (pile.isEmpty() == true) {
			System.out.println ("La pile est vide");
			return true;
		}

		return false;
	}
}
