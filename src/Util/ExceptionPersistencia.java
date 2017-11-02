package Util;

public class ExceptionPersistencia extends Exception{

	
	public ExceptionPersistencia(String mensagem) {
		
		super(mensagem);
		
	}
	
	public ExceptionPersistencia(String mensagem, Exception exception) {
		super(mensagem, exception);
	}

}
