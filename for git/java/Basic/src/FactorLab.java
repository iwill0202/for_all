
public class FactorLab {

	public static void main(String[] args) {
		int sum=0;
		int[][][] threeDim={{{4,3,5},{2,6,1}},
							{{4,3,5},{2,6,1}},
							{{4,3,5},{2,6,1}}};//3 x 2 x 3
			for(int i=0;i<threeDim.length;i++)
				for(int j=0;j<threeDim[i].length;j++)
					for(int k=0;k<threeDim[i][j].length;k++)
						sum+=threeDim[i][j][k];
		System.out.println(sum);
	}//main
}//class
