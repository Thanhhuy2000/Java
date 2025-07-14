// equalsIgnoreCase() và equals() đều để so sánh mà equals() so sánh chữ hoa hay không
// Thường người nhập sẽ nhập cho tiện nên không rõ nhập chữ hoa hay thường nên dùng equalsIgnoreCase
// để nhập thì cần import thư viện Scanner và khai báo đối tượng scanner

import java.util.ArrayList;
import java.util.Scanner;

public class Array_List{
    public static void main(String[] args){
        ArrayList<String> arr = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Nhap chuoi: ");
            String s = scanner.nextLine();
            arr.add(s);
            System.out.println("Co muon nhap tiep khong(Y/N)? ");
            String answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("n")){
                break;
            }
        }

        System.out.println("Danh sach chuoi da nhap:");
        for(String i : arr){
            System.out.println(i);
        }
    }
}
