public abstract class Dancer {
    protected String id;
    protected String name;
    protected int energy;
    protected DanceStyle style;

    public Dancer(String id, String name, int energy, DanceStyle style){
        this.id = id;
        this.name = name;
        this.energy = energy;
        this.style = style;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setEnergy(int energy){
        this.energy = energy;
    }

    public int getEnere(){
        return this.energy;
    }

    public void setStyle(DanceStyle style){
        this.style = style;
    }

    public DanceStyle getStyle(){
        return this.style;
    }

    public void performDance(){};
    public void canPerform(){};
    public void rest(){};
}
