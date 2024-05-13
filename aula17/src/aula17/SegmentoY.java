package aula17;

public class SegmentoY {

	int montante;
	
	public void run() {
		synchronized(this) {
			for(int a = 0; a <= 10; a++) {
				montante += a;
			}
			notify();
		}
	}

}
