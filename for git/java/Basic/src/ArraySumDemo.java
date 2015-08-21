public class ArraySumDemo {
	public static void main(String[] args) {
		int sum = 0;
		int[] oneDim = { 2, 6, 1, 4, 3, 5 };
		// �[�`oneDim�U��������
		for (int i = 0; i < oneDim.length; i++)
			sum += oneDim[i];
		System.out.println(sum);
		
		sum = 0;
		int[][] twoDim = { { 2, 6, 1 }, { 4, 3, 5 } };
		// �[�`twoDim�U��������
		for (int i = 0; i < twoDim.length; i++)
			for (int j = 0; j < twoDim[i].length; j++)
				sum += twoDim[i][j];
		System.out.println(sum);
		
		sum = 0;
		int[][][] threeDim = { {{ 2, 6, 1 }, { 4, 3, 5 }} ,
				                         {{ 2, 6, 1 }, { 4, 3, 5 }} ,
				                         {{ 2, 6, 1 }, { 4, 3, 5 }}
				                      }; // 3 X 2 X 3
		// �[�`threeDim�U��������
		for (int i = 0; i < threeDim.length; i++)
			for (int j = 0; j < threeDim[i].length; j++)
				for (int k = 0; k < threeDim[i][j].length; k++)
				sum += threeDim[i][j][k];
		System.out.println(sum);
	} // end of main()
} // end of class ArraySumDemo

