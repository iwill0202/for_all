public class ArrayAssignDemo {
     public static void main(String[] args) {
          int[] data = {1, 2, 3, 4, 5, 6};
     //   將data指定給data1    
          int[] data1 = data;
     //   將data前三個元素乘上10 
          for(int i = 0; i < data.length - 3; i++)
               data[i] *= 10;
     //   列印data1所有元素
          for(int i = 0; i < data1.length ; i++)
               System.out.println(data1[i]);
     } // end of main()
} // end of class ArrayAssignDemo 

