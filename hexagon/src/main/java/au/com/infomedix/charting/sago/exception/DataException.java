package au.com.infomedix.charting.sago.exception;

import jakarta.ejb.ApplicationException;
import java.io.Serial;

@ApplicationException(rollback = true)
public class DataException extends AbstractException {
  @Serial private static final long serialVersionUID = -3332188098525710745L;

  public DataException() {}

  public DataException(String message) {
    super(message);
  }

  public DataException(Throwable cause) {
    super(cause);
  }
}
