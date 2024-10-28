package negocio.exception;

/**
 *
 * @author brand
 */
public class NegocioException extends Exception{
    
    public NegocioException(String mensaje) {
        super(mensaje);
    }

    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
