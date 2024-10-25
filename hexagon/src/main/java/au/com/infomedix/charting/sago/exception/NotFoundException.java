package au.com.infomedix.charting.sago.exception;

import java.io.Serial;

public class NotFoundException extends AbstractException {
  @Serial private static final long serialVersionUID = -1491829759691855982L;

  public NotFoundException() {}

  public NotFoundException(String message) {
    super(message);
  }

  public NotFoundException(Throwable cause) {
    super(cause);
  }
}
