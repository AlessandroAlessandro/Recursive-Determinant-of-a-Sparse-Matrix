
import java.util.*;


public class SparseMatrix implements SparseInterface {

        private int cur_rows = 5;
        private int cur_columns = 5;
        private int num_elements = 0;
        private MatrixNode head = null;


        class MatrixNode {
            int data;
            int row;
            int col;
            public MatrixNode next = null;
	    
            void matrixnode(int data, int row, int col){
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
public void clear(){  // set head to null to clear the list
    head = null;
    }


    /*
        Sets maximum size of the matrix.  Number of rows. Itshould also clear the matrix (make all elements 0)
    */
    @Override
    public void setSize(int size){
	
    }



    /*
        Adds an element to the row and column passed as arguments (overwrites if element is already present at that position).
        Throws an error if row/column combination is out of bounds.
    */
    
    public void addElement(int row, int col, int data){
    }
	/*if (row > cur_rows || col > cur_columns){
	    throw new IndexOutOfBoundsException("Index " + row + ", "
						+ col + " is out of bounds!");
	}
	if ((row < 0) || (col < 0)){
	    throw new IndexOutOfBoundsException("Index " + row + ", "
						+ col + " is out of bounds!");
	}
	MatrixNode myNewNode = new MatrixNode();
	boolean replace = false;
	myNewNode.row=row;
	myNewNode.col=col;
	myNewNode.data = data;
	myNewNode.next = null;
	MatrixNode curr = head;
	

	if (emptyMatrix()){
	    this.head=myNewNode;
	    	    
	
		}
    }

	   
	else {
	   
	       		
		if ( curr.next.row == row && curr.next.col == col) {
		    myNewNode.row=row;
		    myNewNode.col=col;
		    myNewNode.data = data;
		    myNewNode.next = null;
		    
		    //curr= myNewNode;
		    return;
		    
		}
		
		curr = curr.next;
		//	curr = curr.next;
	    
	       
		}
	    curr.next = myNewNode;
	    

	}

			
    */



    /*
        Remove (make 0) the element at the specified row and column.
        Throws an error if row/column combination is out of bounds.
    */
    @Override
    public void removeElement(int row, int col){
       
    }


    /*
        Return the element at the specified row and column
        Throws an error if row/column combination is out of bounds.
    */
    @Override
    public int getElement(int row, int col){
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
	MatrixNode curr = this.head;
	String output= "";
	while (curr != null){
	    output = output + curr.row + curr.col + curr.data + "\n";
	    curr = curr.next;
	}
		
	return output;
    
    }
    /*
      Should return the size of the matrix.
    */

    @Override
    public int getSize(){
	return 0;
    }
    
    
    
   
}

