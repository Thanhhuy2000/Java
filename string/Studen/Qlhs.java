package Studen;

import java.util.ArrayList;

public class Qlhs {
    public static void main(String[] args){
        Student s1 = new Student("Hoi dan IT", 1);
        Student s2 = new Student("Nguyen van a", 2);
        Student s3 = new Student("Eric pham", 3);
        Student s4 = new Student("Tran thanh man", 4);
        Student s5 = new Student("Bui phuong nga", 5);
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(s1);
        arr.add(s2);
        arr.add(s3);
        arr.add(s4);
        arr.add(s5);
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i).getName().startsWith("Nguyen")){
                System.out.println("Start with Nguyen: " + arr.get(i));
            }
        }
    }
}
