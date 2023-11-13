public abstract class AutomateCellulaire {
    private Cell[][] cells;
    private Cell[][] cellsInit;
    private int length;
    private int height;

    public AutomateCellulaire(int length, int height){
        this.length = length;
        this.height = height;
        this.cells = new Cell[length][height];
        this.cellsInit = new Cell[length][height];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < height; j++){
                this.cells[i][j] = new Cell(0);
                this.cellsInit[i][j] = new Cell(0);
            }
        }
    }

    public Cell[][] getCells(){
        return this.cells;
    }

    public int getLength(){
        return this.length;
    }

    public int getHeight(){
        return this.height;
    }

    public void setCellState(int i, int j, int state){
        if (i >= 0 && i < length && j >= 0 && j < height) {
            this.cells[i][j].setState(state);
        } else {
            throw new IndexOutOfBoundsException("Indices out of bounds");
        }
    }

    public Cell getCellByIndice(int i, int j){
        if (i >= 0 && i < length && j >= 0 && j < height) {
            return this.cells[i][j];
        } else {
            throw new IndexOutOfBoundsException("Indices out of bounds");
        }
    }

    public int getCellState(int i, int j){
        if (i >= 0 && i < length && j >= 0 && j < height) {
            return this.cells[i][j].getState();
        } else {
            throw new IndexOutOfBoundsException("Indices out of bounds");
        }
    }

    public int getNbNeighbours(int i, int j){
        int nbNeighbours = 0;
        for(int k = -1; k <= 1; k++){
            for(int l = -1; l <= 1; l++){
                if(!(k == 0 && l == 0)){
                    if(i + k >= 0 && i + k < getLength() && j + l >= 0 && j + l < getHeight()){
                        nbNeighbours += getCellState(i + k, j + l);
                    }
                }
            }
        }
        return nbNeighbours;
    }


    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < length; i++){
            for(int j = 0; j < height; j++){
                s += this.cells[i][j].getState() + " ";
            }
            s += "\n";
        }
        return s;
    }

    public abstract void next();

    public Cell[][] getInit(){
        return this.cellsInit;
    }

    public void setInit(){
        for (int i = 0; i < length; i++){
            for (int j = 0; j < this.height; j++){
                this.cellsInit[i][j].setState(this.cells[i][j].getState());
            }
        }
    }

    public void reInit(){
        for (int i = 0; i < length; i++){
            for (int j = 0; j < this.height; j++){
                this.cells[i][j].setState(this.cellsInit[i][j].getState());
            }
        }
        System.out.println(getInit());
    }
}
