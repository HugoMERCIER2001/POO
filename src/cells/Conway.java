public class Conway extends AutomateCellulaire{
    public Conway(int length, int height){
        super(length, height);
    }

    public int getNbStates(){
        return 2;
    }

    public void next(){
        int[][] newStates = new int[getLength()][getHeight()];
        for(int i = 0; i < getLength(); i++){
            for(int j = 0; j < getHeight(); j++){
                int nbNeighbours = getNbNeighbours(i, j, 1);
                if(this.getCellByIndice(i, j).getState() == 1){
                    if(nbNeighbours == 2 || nbNeighbours == 3){
                        newStates[i][j] = 1;
                    } else {
                        newStates[i][j] = 0;
                    }
                } else {
                    if(nbNeighbours == 3){
                        newStates[i][j] = 1;
                    } else {
                        newStates[i][j] = 0;
                    }
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