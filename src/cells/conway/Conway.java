

public class Conway{
    private int length;
    private int height;
    private int nbStates;
    private int nbCells = length * height;
    private Cell[][] cells;
    private Cell[][] cellsInit;


    public Conway(int length, int height){
        this.length = length;
        this.height = height;
        this.nbStates = 2;
        this.cells = new Cell[length][height];
        this.cellsInit = new Cell[length][height];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < height; j++){
                this.cells[i][j] = new Cell(0);
                this.cellsInit[i][j] = new Cell(0);
            }
        }
    }

    // second constructeur qui fait un tableau de cellules carré
    public Conway(int length){
        this.length = length;
        this.height = length;
        this.nbStates = 2;
        this.cells = new Cell[length][length];
        this.cellsInit = new Cell[length][length];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                this.cells[i][j] = new Cell(0);
                this.cellsInit[i][j] = new Cell(0);
            }
        }
    }

    // troisième constructeur qui fait un tableau de cellules carré à partir d'un tableau carré de nombres
    public Conway(int[][] tab){
        this.length = tab.length;
        this.height = tab.length;
        this.nbStates = 2;
        this.cells = new Cell[length][length];
        this.cellsInit = new Cell[length][length];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                this.cells[i][j] = new Cell(tab[i][j]);
                this.cellsInit[i][j] = new Cell(tab[i][j]);
            }
        }
    }

    public int getLength(){
        return this.length;
    }

    public int getHeight(){
        return this.height;
    }

    public reInit(){
        this.cells =(Cell[][]) this.cellsInit.clone();
    }

    public Cell getCell(int i, int j){
        if (i >= 0 && i < length && j >= 0 && j < height) {
            return this.cells[i][j];
        } else {
            throw new IndexOutOfBoundsException("Indices out of bounds");
        }
    }

    public void setCellState(int i, int j, int state){
        if (i >= 0 && i < length && j >= 0 && j < height) {
            this.cells[i][j].setState(state);
            } else {
            throw new IndexOutOfBoundsException("Indices out of bounds");
        }
    }
}
