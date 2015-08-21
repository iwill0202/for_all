
public class SyncDemo implements Runnable {
	private Thread t;
	private int[] nums;
	
	public SyncDemo(String threadName, int[]nums){
		t=new Thread(this, threadName);
		this.nums=nums;
		t.start();
	}
	public void run(){
		int ans = SumArray.sa.sumArr(nums);
		System.out.println(t.getName()+":sum="+ans);
	}
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6,7,8,9,10};
		new SyncDemo("Thread 1",nums);
		new SyncDemo("Thread 2",nums);
	}
}

class SumArray{
	public final static SumArray sa =  new SumArray();
	int sum;
	
	private SumArray(){}
	
	public synchronized int sumArr(int[] nums){
		sum = 0;
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
			System.out.println(Thread.currentThread().getName()+":total = "+sum);
			try{
				Thread.sleep(10);
			}catch(InterruptedException e){}
		}
		return sum;
	}
}
