package au.com.infomedix.charting.sago.port.api;

import au.com.infomedix.charting.sago.adapter.rest.dto.UserProfile;
import au.com.infomedix.charting.sago.exception.RemoteException;

public interface UserProfileService {
  String KEY_INFO_API_URL = "infoapi.url";

  UserProfile getUserProfile() throws RemoteException;
}
