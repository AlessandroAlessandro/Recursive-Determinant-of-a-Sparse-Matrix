
public class LinkedListStack {

    public static void main(String[] args){

	/*SparseMatrix myMatrix = new SparseMatrix();
	 	myMatrix.addElement(0,0,5);
		 	myMatrix.addElement(0,0,3);
	myMatrix.addElement(0,1,3);
	myMatrix.addElement(0,1,5);
	myMatrix.addElement(0,0,7);
	
	System.out.print(myMatrix.toString());

	*/
	SparseInterface myTest = new SparseMatrix();

	myTest.addElement(0, 0, 16);

	myTest.addElement(0, 1, 4);

	myTest.removeElement(0,1);

	String correctString = "0 0 16\n";

	System.out.println("toString is correct: " + correctString.equals(myTest.toString()));
	
	
	myTest.setSize(3);

	System.out.println("Size is 3: " + (myTest.getSize() == 3));

	correctString = "";

	System.out.println("toString is correct: " + correctString.equals(myTest.toString()));

	System.out.println(myTest.toString());
	/*
	myTest.addElement(3,3,5);
	myTest.addElement(3,1,3);
	myTest.addElement(0,0,1);
	myTest.addElement(2,1,5);
	
	myTest.addElement(2,2,7);
       
	
	myTest.addElement(2,2,4);
	myTest.addElement(2,2,1);
	
	myTest.addElement(1,1,-5);
	
	myTest.addElement(3,3,-3);
	myTest.addElement(0,0,-3);
	
	*/
	myTest.addElement(2,2,4);

	myTest.addElement(1,0,-3);
	correctString = "1 0 -3\n2 2 4\n";

	System.out.println(myTest.toString());

	System.out.println(myTest.getElement(2,2));

	System.out.println("toString is correct: " + correctString.equals(myTest.toString()));

	System.out.println("The determinant is 0: " + (myTest.determinant() == 0));

	SparseInterface myMinor = myTest.minor(1,1);

	System.out.println("The (1,1) element of the minor is 4: " + (myMinor.getElement(1, 1) == 4));
	System.out.println(myMinor.toString());

	myTest.clear();


	
    }
}
     

