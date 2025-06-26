public class student {

    private String name;
    private int age;

    public student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void learnJava(){
        System.out.println("Learn Java with Youtube");
    }
}
