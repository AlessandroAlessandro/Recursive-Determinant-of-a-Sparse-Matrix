
import java.lang.Math;

import java.util.*;


public class SparseMatrix implements SparseInterface {

    public int cur_rows = 5;
    public int cur_columns = 5;
    private int num_elements = 0;
    public MatrixNode head ;
    public MatrixNode tail ;


    class MatrixNode {
	private MatrixNode head ;
	int data;
	int row;
	int col;
	public MatrixNode next = null;
	public MatrixNode prev = null;



	public  MatrixNode( int row, int col,int data){
	    this.data = data;
	    this.row = row;
	    this.col = col;
	}
    }
    public SparseMatrix (){

	cur_rows = cur_columns = 5;

    }

    public SparseMatrix (int size){

	setSize(size);

    }

    public boolean emptyMatrix (){ // check if matrix is empty

	return (head == null);
    }

        @Override
	public void clear(){  // set all matrix data to 0;
	    this.head=null;
	}


    /*
      Sets maximum size of the matrix.  Number of rows. Itshould also clear the matrix (make all elements 0)
    */
        @Override
	public void setSize(int size){
	    this.cur_rows = this.cur_columns = size;
	    clear();

	}



    /*
        Adds an element to the row and column passed as arguments (overwrites if element is already present at that position).
        Throws an error if row/column combination is out of bounds.
    */

    public void addElement(int row, int col, int data){

	if (row > cur_rows || col > cur_columns){
	    throw new IndexOutOfBoundsException("Index " + row + ", "
						+ col + " is out of bounds!");
	}
	if ((row < 0) || (col < 0)){
	    throw new IndexOutOfBoundsException("Index " + row + ", "
						+ col + " is out of bounds!");
	}



	MatrixNode myNewNode = new MatrixNode(row, col, data);
	if (myNewNode.data == 0)
	    return;
	// Matrix is empty
	if (emptyMatrix()){
	    this.head = myNewNode;
	    this.head.next = null;


	}

	// not empty, we want to add to a matrix
	else{
	    MatrixNode curr = this.head;


	    while (curr.next != null){

		// if it's in there replace it
		if ( curr.row == row && curr.col == col) {
		    curr.data = data;
		    break;
		}

		if (row <= curr.row){
		    if (col <= curr.col || row < curr.row)
			{
			    if (curr.prev == null){
				this.head = myNewNode;
				myNewNode.next = curr;
				curr.prev = myNewNode;
			    }
			    else{
				curr.prev.next = myNewNode;
				myNewNode.next = curr;
				myNewNode.prev =curr.prev;
				curr.prev = myNewNode;
				break;
			    }
			}
		}


		curr = curr.next;
	    }


	    if(curr.next == null){
		if ( curr.row == row && curr.col == col) {
		    curr.data = data;

		}

		else if (row <= curr.row){
		    if (col <= curr.col || row < curr.row)
			{
			    if (curr.prev == null){
				this.head = myNewNode;
				myNewNode.next = curr;
				curr.prev = myNewNode;
			    }
			    else{
				curr.prev.next = myNewNode;
				myNewNode.next = curr;
				myNewNode.prev =curr.prev;
				curr.prev = myNewNode;
			    }
			}
		}

		else{

		    curr.next = myNewNode;
		    myNewNode.next = null;
		    myNewNode.prev = curr;
		}
	    }


	}


    }

    /*
        Remove (make 0) the element at the specified row and column.
        Throws an error if row/column combination is out of bounds.
    */

    public void removeElement(int row, int col){
	if (row > cur_rows || col > cur_columns){
	    throw new IndexOutOfBoundsException("Index " + row + ", "
						+ col + " is out of bounds!");
	}
	if ((row < 0) || (col < 0)){
	    throw new IndexOutOfBoundsException("Index " + row + ", "
						+ col + " is out of bounds!");
	}

	MatrixNode curr = this.head;


	while (curr != null){

	    // if it's in there replace it with zero
	    if ( curr.row == row && curr.col == col) {
		curr.data = 0;
		break;

	    }

	    curr = curr.next;
	}




    }


    /*
        Return the element at the specified row and column
        Throws an error if row/column combination is out of bounds.
    */
        @Override
	public int getElement(int row, int col){

	    if (row > cur_rows || col > cur_columns){
		throw new IndexOutOfBoundsException("Index " + row + ", "
						    + col + " is out of bounds!");
	    }
	    if ((row < 0) || (col < 0)){
		throw new IndexOutOfBoundsException("Index " + row + ", "
						    + col + " is out of bounds!");
	    }

	    MatrixNode curr = this.head;
	    while (curr != null){

		if ( curr.row == row && curr.col == col){
		    return curr.data;
		}


		curr = curr.next;
	    }
	    return 0;
	}




    /*
        Returns the determinant of the matrix calculated recursively (Use the formula provided in the project description).
    */
        @Override
	public int determinant(){
	    // base case of size 2X.
	    int sum = 0;

	    if (getSize() == 2){
		sum += getElement(0,0)*getElement(1,1) -
		    getElement(0,1)*getElement(1,0);
		return sum;
	    }
	    // This is the recursive step.
	    else {
		for (int i = 0; i < cur_rows; i++) {
		    sum += (int) (Math.pow(-1, i) * getElement(i, 0) * minor(i, 0).determinant());
		}
	    }
	    return sum;
	}


    /*
        Returns a new matrix which is the minor of the original (See project description for minor definition).
    */
    public SparseInterface minor(int row, int col){

	if (row > cur_rows || col > cur_columns){
	    throw new IndexOutOfBoundsException("Index " + row + ", "
						+ col + " is out of bounds!");
	}
	if ((row < 0) || (col < 0)){
	    throw new IndexOutOfBoundsException("Index " + row + ", "
						+ col + " is out of bounds!");
	}



	//Create neww matrix minor.
	MatrixNode curr = head;
	SparseMatrix minor = new SparseMatrix(); //(getSize-1 in argument)
	minor.setSize(getSize()-1);
	while (curr != null){

	    if ((curr.col != col) &&  (curr.row != row)){
		if (curr.col == 0  && curr.row == 0 ){
		    minor.addElement(curr.row, curr.col, curr.data);
		    curr = curr.next;
		    continue;
		}
		if (curr.col == 0  && curr.row != 0 ){
		    minor.addElement(curr.row-1, curr.col, curr.data);
		    curr = curr.next;
		    continue;
		}

		if (curr.col != 0  && curr.row == 0 ){
		    minor.addElement(curr.row, curr.col-1, curr.data);
		    curr = curr.next;
		    continue;
		}

		if (curr.col != 0  && curr.row != 0 ) {
		    minor.addElement(curr.row - 1, curr.col - 1, curr.data);
		    curr = curr.next;
		    continue;
		}


	    }
	    curr = curr.next;


	}
	return minor;

    }
    /*
    Should return the nonzero elements of your sparse matrix as a string.
    The String should be k lines, where k is the number of nonzero elements.
    Each line should be in the format "row column data" where row and column are the "coordinate" of the data and all are separated by spaces.
    An empty matrix should return an empty string.
    The print should be from left to right and from top to bottom (like reading a book) i.e. the matrix
                                                     3 0 1
                                                     0 2 0
                                                     0 0 4
						          Should print as:
                                                     0 0 3
                                                     0 2 1
                                                     1 1 2
                                                     2 2 4
    */
        @Override
	public String toString() {

	    MatrixNode curr = this.head;
	    String output= "";
	    while (curr != null){
		if (curr.data != 0)
		    output = output + curr.row + " " +  curr.col + " " + curr.data + "\n";
		curr = curr.next;
	    }

	    return output;

	}
    /*
      Should return the size of the matrix.
    */

        @Override
	public int getSize(){
	    return this.cur_rows;

	}




}

