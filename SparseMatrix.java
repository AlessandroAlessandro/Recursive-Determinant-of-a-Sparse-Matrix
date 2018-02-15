
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
    
    // Constructor
   
	    
	    
    public boolean emptyMatrix (){ // check if matrix is empty

	return (head == null);
	    }

@Override 
public void clear(){  // set all matrix data to 0;
  MatrixNode  curr = this.head;
    while (curr != null){
	curr.data = 0;
	curr= curr.next;
    }
    
    }


    /*
        Sets maximum size of the matrix.  Number of rows. Itshould also clear the matrix (make all elements 0)
    */
    @Override
    public void setSize(int size){
	cur_rows = cur_columns = size;
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
    /*	boolean replace = false;
	myNewNode.row=row;
	myNewNode.col=col;
	myNewNode.data = data;
	myNewNode.next = null;
	MatrixNode curr = head;
	
    */

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
		//	System.out.println("row "+row+" Cur  row "+ curr.row);
		//	System.out.println("col "+col+" Cur  col "+ curr.col);
		
		if (row <= curr.row){
		    if (col <= curr.col || row < curr.row)
			{
			    curr.prev.next = myNewNode;
			    myNewNode.next = curr;
			    myNewNode.prev =curr.prev;
			    curr.prev = myNewNode;
			    break;
			}
		}
		
		
		curr = curr.next;
	    }


	    if(curr.next == null){
		if ( curr.row == row && curr.col == col) {
		    curr.data = data;
		    
		}
		//	System.out.println("row "+row+" Cur  row "+ curr.row);
		//		System.out.println("col "+col+" Cur  col "+ curr.col);
		
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

	    if ( curr.row == row && curr.col == col) 
		return curr.data;
	
	    

	    curr = curr.next;
	}
        return 0;	
    }




    /*
        Returns the determinant of the matrix calculated recursively (Use the formula provided in the project description).
    */
    @Override
    public int determinant(){

	return 0;
    }

    /*
        Returns a new matrix which is the minor of the original (See project description for minor definition).
    */
     public SparseInterface minor(int row, int col){
    	return null ;
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

	// set to ignore 0's


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
	return cur_rows;
     
    }
    
    
    
   
}

