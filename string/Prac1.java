import java.util.Scanner;

public class Prac1 {
    public static void main(String[] args){
        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.print("Nhap username: ");
            String name = scan.nextLine();
            System.out.print("Nhap password: ");
            String pass = scan.nextLine();
            if(name.equals("hoidanit") && (pass.length() > 6)){
                System.out.println("Hop le");
                break;
            }
            else{
                System.out.println("Khong hop le! Nhap lai.");
            }
            scan.close();
        }
    }
}
