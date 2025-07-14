public class Vision extends Car{
    private String modelName = "Mustang";
    public static void main(String[] args){
        Vision myCar = new Vision();
        myCar.honk();
        System.out.println(myCar.brand + " " + myCar.modelName);
    }
}
