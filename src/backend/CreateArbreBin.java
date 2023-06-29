package backend;

public class CreateArbreBin {
	
	public ArbreBin getArbreBin () {
		Integer N1 = new Integer(1);
		Integer N2 = new Integer(2);
		Integer N3 = new Integer(3);
		Integer N4 = new Integer(4);
		Integer N5 = new Integer(5);
		Integer N6 = new Integer(6);
		Integer N7 = new Integer(7);
		Integer N8 = new Integer(8);
		Integer N9 = new Integer(9);

		ArbreBin A1 = new ArbreBin(N1);
		ArbreBin A2 = new ArbreBin(N2);
		ArbreBin A3 = new ArbreBin(N3);
		ArbreBin A4 = new ArbreBin(N4);
		ArbreBin A5 = new ArbreBin(N5);
		ArbreBin A6 = new ArbreBin(N6);
		ArbreBin A7 = new ArbreBin(N7);
		ArbreBin A8 = new ArbreBin(N8);
	

		A1.setLeftChild(A2);
		A1.setRightChild(A6);
		A2.setLeftChild(A3);
		A2.setRightChild(A4);
		A4.setLeftChild(A5);
		A6.setRightChild(A7);
		A7.setLeftChild(A8);
		

		return A1;
	}
}
