package au.com.infomedix.charting.sago.exception;

import java.io.Serial;

public class ValidationException extends AbstractException {
  @Serial private static final long serialVersionUID = 6571430962193638850L;

  public ValidationException() {}

  public ValidationException(String message) {
    super(message);
  }

  public ValidationException(Throwable cause) {
    super(cause);
  }
}
