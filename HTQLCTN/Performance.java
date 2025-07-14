public class Performance {
    private String name;
    private int techicalScore;
    private int artisticScore;
    private int emotionalScore;

    public Performance(String name, int techicalScore, int artisticScore, int emotionalScore){
        this.name = name;
        this.techicalScore = techicalScore;
        this.artisticScore = artisticScore;
        this.emotionalScore = emotionalScore;
    }

    public int calculateScore(){
        return this.techicalScore + this.artisticScore + this.emotionalScore;
    };
    public void isCompleted(){};
}
