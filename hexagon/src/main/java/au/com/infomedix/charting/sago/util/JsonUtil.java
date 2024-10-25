package au.com.infomedix.charting.sago.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.Map;

/**
 * This class is a JSON util based on Jackson {@link ObjectMapper}. ObjectMapper is thread-safe but
 * it's recommendeded to create {@link ObjectReader} for reading and {@link ObjectWriter} for
 * writing because they are fully immutable and light-weight. See <a
 * href="https://fasterxml.github.io/jackson-databind/javadoc/2.8/com/fasterxml/jackson/databind/SerializationFeature.html">https://fasterxml.github.io/jackson-databind/javadoc/2.8/com/fasterxml/jackson/databind/SerializationFeature.html</a>
 */
public final class JsonUtil {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  // some common configurations for Json Object Mapper
  static {
    MAPPER.findAndRegisterModules();
    MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    // only include non-null values
    MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    MAPPER.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
    // serialize date in human-readable format instead of Long timestamp (Epoch)
    MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    MAPPER.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, false);
  }

  private JsonUtil() {}

  public static ObjectMapper getMapper() {
    return MAPPER;
  }

  public static ObjectReader getReader() {
    return MAPPER.reader();
  }

  public static <T> ObjectReader getReaderFor(Class<T> clazz) {
    return MAPPER.readerFor(clazz);
  }

  public static <T> ObjectWriter getWriterFor(Class<T> clazz) {
    return MAPPER.writerFor(clazz);
  }

  public static ObjectWriter getPrettyWriter() {
    return MAPPER.writerWithDefaultPrettyPrinter();
  }

  public static <T> T fromJson(final String json, final Class<T> clazz) throws IOException {
    if (json != null && clazz != null) {
      return getReaderFor(clazz).readValue(json);
    }
    return null;
  }

  public static <T> T fromJson(final String json, final TypeReference<T> typeReference)
      throws IOException {
    if (json != null && typeReference != null) {
      return getMapper().readValue(json, typeReference);
    }
    return null;
  }

  public static <T> String toJson(T object) throws IOException {
    if (object != null) {
      return getWriterFor(object.getClass()).writeValueAsString(object);
    }
    return null;
  }

  public static <T> String toFormattedJson(T object) throws IOException {
    if (object != null) {
      return getPrettyWriter().writeValueAsString(object);
    }
    return null;
  }

  @SuppressWarnings("rawtypes")
  public static <T> T fromJsonMap(final Map map, final Class<T> clazz) {
    if (map != null && clazz != null) {
      return MAPPER.convertValue(map, clazz);
    }
    return null;
  }
}
