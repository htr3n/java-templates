package au.com.infomedix.charting.sago.exception;

import java.io.Serial;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RemoteException extends AbstractException {
  @Serial private static final long serialVersionUID = 2631783166802391833L;

  private int code = -1;

  public RemoteException() {}

  public RemoteException(String message) {
    super(message);
  }

  public RemoteException(Throwable cause) {
    super(cause);
  }

  public RemoteException(String message, int code) {
    super(message);
    this.code = code;
  }

  public RemoteException(int code) {
    super();
    this.code = code;
  }
}
