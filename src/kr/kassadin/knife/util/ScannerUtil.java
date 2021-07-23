package kr.kassadin.knife.util;

//우리가 Scanner의 메소드를 사용할때
//좀더 편리하게 사용할 수 있는 메소드를 우리가 구현해놓은 
//클래스
import java.util.Scanner;
public class ScannerUtil {
 // 1. 버퍼메모리에 엔터키가 남아있을 때 해결할 nextLine() 메소드
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
 
 // 사용자로부터 특정 범위내의 숫자값을 입력받는 nextInt() 메소드
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