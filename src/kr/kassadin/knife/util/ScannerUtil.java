package kr.kassadin.knife.util;

//�츮�� Scanner�� �޼ҵ带 ����Ҷ�
//���� ���ϰ� ����� �� �ִ� �޼ҵ带 �츮�� �����س��� 
//Ŭ����
import java.util.Scanner;
public class ScannerUtil {
 // 1. ���۸޸𸮿� ����Ű�� �������� �� �ذ��� nextLine() �޼ҵ�
 public static String nextLine(Scanner scanner, String message) {
     System.out.println(message);
     System.out.print("> ");        
     String str = new String(scanner.nextLine());        
     if(str.isEmpty()) {
         str = new String(scanner.nextLine());
     }                
     return str;        
 }
 
 public static int nextInt(Scanner scanner, String message) {
     String temp = nextLine(scanner,message);   
     while(!temp.matches("\\d+")) {
         System.out.println("Warning!");
         System.out.println("You can only enter \"Int Number\"");
         temp = nextLine(scanner,message);
     } 
     return Integer.parseInt(temp);                
 }
 
 // ����ڷκ��� Ư�� �������� ���ڰ��� �Է¹޴� nextInt() �޼ҵ�
 public static int nextInt(Scanner scanner, String message, int min, int max) {
     
     int number = nextInt(scanner, message);
     
     while(!(number >= min && number <= max)) {
         System.out.println("Warning!");
         System.out.println("You input wrong information");
         number = nextInt(scanner, message);
     }
     
     return number;
 }
}