public class ArrayAssignDemo {
     public static void main(String[] args) {
          int[] data = {1, 2, 3, 4, 5, 6};
     //   �Ndata���w��data1    
          int[] data1 = data;
     //   �Ndata�e�T�Ӥ������W10 
          for(int i = 0; i < data.length - 3; i++)
               data[i] *= 10;
     //   �C�Ldata1�Ҧ�����
          for(int i = 0; i < data1.length ; i++)
               System.out.println(data1[i]);
     } // end of main()
} // end of class ArrayAssignDemo 

