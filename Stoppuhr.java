
public class Stoppuhr {
	
	//Tests
	public static void main(String[] args) throws InterruptedException {
		Stoppuhr uhr = new Stoppuhr();
		
		try {
		uhr.start();
		uhr.start();
		uhr.stop();
		System.out.println("Gestoppte Zeit: " + uhr.getTime() + " ns");
		uhr.start();
		uhr.stop();
		uhr.stop();
		System.out.println("Gestoppte Zeit: " + uhr.getTime() + " ns");
		uhr.reset();
		System.out.println("Gestoppte Zeit: " + uhr.getTime() + " ns");
		uhr.start();
		System.out.println("Gestoppte Zeit: " + uhr.getTime() + " ns");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		//---------------------
		
		uhr.start();
		Thread.sleep(100);
		uhr.stop();
		Thread.sleep(1000);
		uhr.start();
		Thread.sleep(500);
		uhr.stop();
		
		System.out.println("100ms + 500ms warten: " + (uhr.getTime()/1000000) + " ms");
	}
	
	private long startValue, stoppedTime;
	private boolean running;
	
	public Stoppuhr() {
		startValue = 0;
		stoppedTime = 0;
		running = false;
	}
	
	public void start() {
		if(running) return;
		
		startValue = System.nanoTime();
		running = true;
	}
	
	public void stop() {
		if(running) {
			stoppedTime += System.nanoTime() - startValue;
		}
		running = false;
	}
	
	public long getTime() {
		if(running) throw new RuntimeException("Stoppuhr laeuft noch");
		
		return stoppedTime;
	}
	
	public void reset() {
		if(running) throw new RuntimeException("Stoppuhr laeuft noch");
		
		stoppedTime = 0;
	}
	
}
