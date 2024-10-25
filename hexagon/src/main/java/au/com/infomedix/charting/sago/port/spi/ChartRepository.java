package au.com.infomedix.charting.sago.port.spi;

import au.com.infomedix.charting.sago.adapter.persistence.entity.CallingCriteriaEntity;
import java.util.List;

public interface ChartRepository {
  List<CallingCriteriaEntity> getCallingCriteria();
}
