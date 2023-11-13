public abstract class AutomateCellulaire {
    private Cell[][] cells;
    private Cell[][] cellsInit;
    private int length;
    private int height;

    public AutomateCellulaire(int length, int height){
        this.length = length;
        this.height = height;
        this.cells = new Cell[length][height];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < height; j++){
                this.cells[i][j] = new Cell(0);
            }
        }
        Cell[][] cellsInit = (Cell[][]) this.cells.clone();
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

    public void reInit(){
        this.cells = (Cell[][]) this.cellsInit.clone();
    }
}
