package exercicios;

public class Cap17_Lab1 extends ThreadLab{
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    ThreadLab thread1 = new ThreadLab("Thread 1");
	    ThreadLab thread2 = new ThreadLab("Thread 2");

        // Iniciando as threads
        thread1.start();
        thread2.start();
	}

}