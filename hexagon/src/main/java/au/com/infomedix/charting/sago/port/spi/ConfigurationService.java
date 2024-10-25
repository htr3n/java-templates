package au.com.infomedix.charting.sago.port.spi;

import java.util.Map;

public interface ConfigurationService {

  Map<String, ?> getAll();

  String get(String name);

  int delete(String name);

  int deleteAll();

  void create(String name, String value);

  int update(String name, String newValue);
}
