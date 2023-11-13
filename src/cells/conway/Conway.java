

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

    // second constructeur qui fait un tableau de cellules carré à partir d'un tableau carré de nombres
    public Conway(int[][] tab){
        this.length = tab.length;
        this.height = tab[0].length;
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

    public void reInit(){
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

    public void next(){
        int[][] tab = new int[length][height];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < height; j++){
                tab[i][j] = this.cells[i][j].getState();
            }
        }
        for(int i = 0; i < length; i++){
            for(int j = 0; j < height; j++){
                int nbVoisins = 0;
                for(int k = -1; k < 2; k++){
                    for(int l = -1; l < 2; l++){
                        if(i+k >= 0 && i+k < length && j+l >= 0 && j+l < height && !(k == 0 && l == 0)){
                            if(tab[i+k][j+l] == 1){
                                nbVoisins++;
                            }
                        }
                    }
                }
                if(nbVoisins == 3){
                    this.cells[i][j].setState(1);
                }
                else if(nbVoisins == 2){
                    this.cells[i][j].setState(this.cells[i][j].getState());
                }
                else{
                    this.cells[i][j].setState(0);
                }
            }
        }
    }
        
}
