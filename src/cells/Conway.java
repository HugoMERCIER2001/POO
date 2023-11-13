public class Conway extends AutomateCellulaire{
    public Conway(int length, int height){
        super(length, height);
    }

    public void next(){
        int[][] newStates = new int[getLength()][getHeight()];
        for(int i = 0; i < getLength(); i++){
            for(int j = 0; j < getHeight(); j++){
                int nbNeighbours = getNbNeighbours(i, j);
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

    private int getNbNeighbours(int i, int j){
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
}