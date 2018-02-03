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
        SparseMatrix(int r, int c){
            this.cur_rows = r;
            this.cur_columns = c;
        }

        public void addElement(int row, int col, int data){
            if (row > cur_rows || col > cur_columns){
               throw new IndexOutOfBoundsException("Index " + row + ", "
                       + col + " is out of bounds!");
            }
            if ((row < 0) || (col < 0)){
                throw new IndexOutOfBoundsException("Index " + row + ", "
                        + col + " is out of bounds!");
            }




        }

        @Override
        public String toString() {
            return "SparseMatrix{" +
                    "cur_rows=" + cur_rows +
                    ", cur_columns=" + cur_columns +
                    ", num_elements=" + num_elements +
                    ", head=" + head +
                    '}';
        }
    }
