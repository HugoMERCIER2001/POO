

public class Conway{
    private int length;
    private int height;
    private int nbStates;
    private int nbCells = length * height;
    private Cell[][] cells;

    public Conway(int nbStates, int length, int height){
        this.length = length;
        this.height = height;
        this.nbStates = nbStates;
        this.cells = new Cell[length][height];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < height; j++){
                this.cells[i][j] = new Cell(0);
            }
        }
    }

    // seocond constructeur qui fait un tableau de cellules carré
    public Conway(int nbStates, int length){
        this.length = length;
        this.height = length;
        this.nbStates = nbStates;
        this.cells = new Cell[length][length];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                this.cells[i][j] = new Cell(0);
            }
        }
    }
}
