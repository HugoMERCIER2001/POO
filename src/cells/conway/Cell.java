

public class Cell{
    private int state;
    private int i;
    private int j;

    public Cell(int state){
        this.state = state;
    }

    public int getState(){
        return this.state;
    }

    public int getI(){
        return this.i;
    }

    public int getJ(){
        return this.j;
    }

    public void setState(int state){
        this.state = state;
    }
}