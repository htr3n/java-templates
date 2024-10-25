package au.com.infomedix.charting.sago.exception;

import jakarta.ejb.ApplicationException;

@ApplicationException
public abstract class AbstractException extends Exception {

  public AbstractException() {
    super();
  }

  public AbstractException(String message) {
    super(message);
  }

  public AbstractException(Throwable cause) {
    super(cause);
  }
}
