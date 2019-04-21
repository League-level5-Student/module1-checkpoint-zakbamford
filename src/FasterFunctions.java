
public class FasterFunctions {
	public static void main(String[] args) {
		float totalTime = 0;
		long startTime = System.currentTimeMillis();
		// Your Code Here
		Thread t0 = new Thread(() -> {
			SlowFunctions.slowSortLargeArray();
		});

		Thread t1 = new Thread(() -> {
			SlowFunctions.ackermann(3, 14);
		});

		Thread t2 = new Thread(() -> {
			SlowFunctions.millionsOfSqrts();
		});
		
		t0.start();
		t1.start();
		t2.start();
		
		try {
			t0.join();
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		float endTime = (float) ((double) System.currentTimeMillis() - (double) startTime) / 1000.0f;
		totalTime += endTime;
		System.out.println("Total Time: " + totalTime);
	}
}
