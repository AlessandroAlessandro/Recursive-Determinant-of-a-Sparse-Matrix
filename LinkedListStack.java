public class LinkedListStack {

    public static void main(String[] args){

	SparseMatrix Mymatrix = new SparseMatrix(2);
	Mymatrix.setSize(2);

	Mymatrix.addElement(0,1,66);
	Mymatrix.addElement(0,1,82);
	Mymatrix.addElement(0,1,-40);
	Mymatrix.addElement(1,0,46);
	Mymatrix.addElement(1,1,-63);
	Mymatrix.addElement(1,0,18);
	Mymatrix.addElement(1,1,-43);




	System.out.println(Mymatrix.toString());
	//        System.out.println(Mymatrix.getSize());
	//        System.out.println(Mymatrix.minor(1,1).toString());
	//System.out.println(Mymatrix.minor(0,0).toString());
	System.out.println(Mymatrix.determinant());
    }
}     

