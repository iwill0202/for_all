public class OverloadingDemo {
     static void greeting() {
         System.out.println("Hello!");
     }
     
     static void greeting(String name) {
         System.out.println("Hello! " + name);
     }
     
     static void greeting(String name, int n) {
         for (int i = 1; i <= n; i++)
              System.out.println("Hello! " + name);
     } 
     
     public static void main(String[] args) {
         greeting();
         greeting("John");
         greeting("Mary", 3);
     } // end of main()
 } // end of class OverloadingDemo

