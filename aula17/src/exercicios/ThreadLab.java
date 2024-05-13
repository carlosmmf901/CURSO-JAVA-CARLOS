package exercicios;

public class ThreadLab extends Thread {
	private static final Object lock = new Object();
	
	public ThreadLab(String mensagem) {
		super(mensagem);
		
	}
	
	@Override
	public void run() {
		synchronized (lock) {
		for (int i = 0; i < 10; i++) {
			 System.out.println(getName());
			 try {
				 sleep(500);
			 } catch(InterruptedException e) {
				 System.out.println(e);
			 }
			 
			} 
		 }
	}
	
	
}
