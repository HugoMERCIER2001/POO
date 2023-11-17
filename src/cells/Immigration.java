public class Immigration extends AutomateCellulaire{
    private int nbStates;

    public Immigration(int length, int height){
        super(length, height);
        this.nbStates = 3;
    }

    public void setNbStates(int nbStates){
        this.nbStates = nbStates;
    }

    public int getNbStates(){
        return this.nbStates;
    }

    public void next(){
        int[][] newStates = new int[getLength()][getHeight()];
        for(int i = 0; i < getLength(); i++){
            for(int j = 0; j < getHeight(); j++){
                int neighboursState = (this.getCellState(i, j) + 1) % this.nbStates;
                int nbNeighbours = getNbNeighbours(i, j, neighboursState);
                if (nbNeighbours>=3){
                    newStates[i][j] = neighboursState;
                }
            }
        }
        for(int i = 0; i < getLength(); i++){
            for(int j = 0; j < getHeight(); j++){
                setCellState(i, j, newStates[i][j]);
            }
        }
    }
}