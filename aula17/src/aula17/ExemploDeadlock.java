package aula17;

public class ExemploDeadlock {
	private static class Recurso {
		public int value;
	}
	
	private Recurso RecursoX = new Recurso();
	private Recurso RecursoY = new Recurso();
	
	public int read() {
		synchronized(RecursoY) {
			synchronized(RecursoY){
			return RecursoY.value = RecursoX.value;
			}
		}
	}
	
	public void write(int x, int y) {
		synchronized(RecursoX) {
			RecursoX.value = x;
			RecursoY.value = y;
		}
	}
	
	
}
