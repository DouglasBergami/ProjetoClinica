package Util;

public class ValidacaoException extends Exception{
	
	private static final long serialVersionUID = 3695074141531810267L;
	
	public ValidacaoException(String mensagem) {
		
		super(mensagem);
		
	}
	
	public ValidacaoException(String mensagem, Exception exception) {
		super(mensagem, exception);
	}

}
