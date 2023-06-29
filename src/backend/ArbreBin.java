package backend;

import java.util.ArrayList;

public class ArbreBin {
	protected Integer root;
	protected ArbreBin leftChild;
	protected ArbreBin rightChild;

	public ArbreBin() {

		this.root = null;
		this.leftChild = null;
		this.rightChild = null;
	}

	public ArbreBin(Integer root) {

		this.root = root;
		this.leftChild = null;
		this.rightChild = null;
	}

	public void setRoot (Integer root) {
		this.root = root;
	}

	public void setLeftChild (ArbreBin leftArbreBin) {
		this.leftChild = leftArbreBin;
	}

	public void setRightChild (ArbreBin rightArbreBin) {
		this.rightChild = rightArbreBin;
	}
	
	public Integer getRoot() {
		return root;
	}

	public ArbreBin getLeftChild() {
		return leftChild;
	}

	public ArbreBin getRightChild() {
		return rightChild;
	}

	public String depthRoutePre() {

		 ArrayList<Integer> listRoute = new ArrayList<Integer>();
		 Pile<ArbreBin> pileWait = new Pile<ArbreBin>();

		if (this.root == null) {
			return null;
		}

		listRoute.add(this.root);

		pileWait.push(this.rightChild);
		pileWait.push(this.leftChild);

		while (pileWait.isEmpty() == false) {

			ArbreBin top = pileWait.pop();
			Integer r = top.root;
			listRoute.add(r) ;

			if (top.rightChild != null) {
				pileWait.push(top.rightChild);			
			}

			if (top.leftChild != null) {
				pileWait.push(top.leftChild);
			}
		
		}

		// retour du résultat du parcours en profondeur

		String result = listRoute.toString();
		return result;
	}
	
	public String depthRouteIn() {

		 ArrayList<Integer> listRoute = new ArrayList<Integer>();
		 Pile<ArbreBin> pileWait = new Pile<ArbreBin>();

		if (this.root == null) {
			return null;
		}

		pileWait.push(this.rightChild);
		pileWait.push(this.leftChild);
		
		int en=0;
		while (pileWait.isEmpty() == false) {
			
			ArbreBin top = pileWait.pop();
			
			if(pileWait.isEmpty() == true && en==0) {
				listRoute.add(this.root);
				en=1;
			}
			
			Integer r = top.root;
			listRoute.add(r) ;
			
			if (top.rightChild != null) {
				pileWait.push(top.rightChild);			
			}

			if (top.leftChild != null) {
				pileWait.push(top.leftChild);
			}
		
		}

		// retour du résultat du parcours en profondeur

		String result = listRoute.toString();
		return result;
	}
	
	public String depthRoutePost() {

		 ArrayList<Integer> listRoute = new ArrayList<Integer>();
		 Pile<ArbreBin> pileWait = new Pile<ArbreBin>();

		if (this.root == null) {
			return null;
		}

		pileWait.push(this.rightChild);
		pileWait.push(this.leftChild);

		while (pileWait.isEmpty() == false) {

			ArbreBin top = pileWait.pop();
			Integer r = top.root;
			listRoute.add(r) ;

			if (top.rightChild != null) {
				pileWait.push(top.rightChild);			
			}

			if (top.leftChild != null) {
				pileWait.push(top.leftChild);
			}
		
		}
		
		listRoute.add(this.root);

		// Retour du résultat du parcours en profondeur
		
			String result = listRoute.toString();
			return result;
		}
}

