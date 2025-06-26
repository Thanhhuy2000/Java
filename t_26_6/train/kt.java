public class kt {
    public static void main(String[] args){
        Student sta = new Student();
        Student str = new Student("Tuan", 25);
        // str.name = "Tuan";
        sta.age = 25;
        System.out.println(str.name); // Tuan
        str.xuatThongTin(); // Hoc code java
    }
}
