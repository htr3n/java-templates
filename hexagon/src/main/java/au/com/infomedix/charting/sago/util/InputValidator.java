package au.com.infomedix.charting.sago.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/**
 * A reusable input validator with fluent API to check all possible input values and generate
 * corresponding error messages.
 */
public final class InputValidator {

  private final List<String> errors = new ArrayList<>();

  private InputValidator() {}

  public static InputValidator newInstance() {
    return new InputValidator();
  }

  public List<String> getErrors() {
    return errors;
  }

  public String getErrorsAsString() {
    if (!errors.isEmpty()) {
      return String.join(", ", errors);
    }
    return "";
  }

  public boolean hasErrors() {
    return !errors.isEmpty();
  }

  public InputValidator nonNullNorEmpty(final String input, final String label) {
    if (StringUtils.isBlank(input)) {
      String errorMsg = "'" + label + "' must not be null nor empty.";
      errors.add(errorMsg);
    }
    return this;
  }

  public InputValidator equalsIgnoreCase(
      final String input, final String expected, final String label) {
    if (StringUtils.isNotBlank(input)) {
      String errorMsg = "'" + label + "' must not be null nor empty.";
      errors.add(errorMsg);
    } else {

      if (!input.equalsIgnoreCase(expected)) {
        String errorMsg =
            "'"
                + label
                + "' is expected to be equal (case-insensitive) to '"
                + expected
                + "' instead of '"
                + input
                + "'";
        errors.add(errorMsg);
      }
    }
    return this;
  }

  public InputValidator notEqualsIgnoreCase(
      final String input, final String expected, final String label) {
    if (StringUtils.isBlank(input)) {
      String errorMsg = "'" + label + "' must not be null nor empty.";
      errors.add(errorMsg);
    } else {

      if (input.equalsIgnoreCase(expected)) {
        String errorMsg =
            "'" + label + "' is not expected to be (case-insensitive) '" + expected + "'";
        errors.add(errorMsg);
      }
    }
    return this;
  }

  @SuppressWarnings("rawtypes")
  public InputValidator nonNullNorEmpty(final Collection input, final String label) {
    if (input == null || input.isEmpty()) {
      String errorMsg = "'" + label + "' must not be null nor empty.";
      errors.add(errorMsg);
    }
    return this;
  }

  @SuppressWarnings("rawtypes")
  public InputValidator nonNullNorEmpty(final Map input, final String label) {
    if (input == null || input.isEmpty()) {
      String errorMsg = "'" + label + "' must not be null nor empty.";
      errors.add(errorMsg);
    }
    return this;
  }

  public InputValidator nonNull(final Object input, final String label) {
    if (Objects.isNull(input)) {
      String errorMsg = "'" + label + "' must not be null.";
      errors.add(errorMsg);
    }
    return this;
  }

  @SuppressWarnings("rawtypes")
  public InputValidator hasSizeEqualTo(
      final Collection input, final int expectedSize, final String label) {
    if (Objects.isNull(input)) {
      String errorMsg = "'" + label + "' must not be null.";
      errors.add(errorMsg);
    } else {
      if (input.size() != expectedSize) {
        String errorMsg =
            "The size of '"
                + label
                + "' is expected to be '"
                + expectedSize
                + "' instead of '"
                + input.size()
                + "'";
        errors.add(errorMsg);
      }
    }
    return this;
  }

  @SuppressWarnings("rawtypes")
  public InputValidator hasSizeGreaterThan(
      final Collection input, final int expectedSize, final String label) {
    if (Objects.isNull(input)) {
      String errorMsg = "'" + label + "' must not be null.";
      errors.add(errorMsg);
    } else {
      if (input.size() <= expectedSize) {
        String errorMsg =
            "The size of '"
                + label
                + "'  is expected to be greater than '"
                + expectedSize
                + "' instead of '"
                + input.size()
                + "'";
        errors.add(errorMsg);
      }
    }
    return this;
  }

  @SuppressWarnings("rawtypes")
  public InputValidator hasSizeLessThan(
      final Collection input, final int expectedSize, final String label) {
    if (Objects.isNull(input)) {
      String errorMsg = "'" + label + "' must not be null.";
      errors.add(errorMsg);
    } else {
      if (input.size() >= expectedSize) {
        String errorMsg =
            " The size of '"
                + label
                + "' is expected to be less than '"
                + expectedSize
                + "' instead of '"
                + input.size()
                + "'";
        errors.add(errorMsg);
      }
    }
    return this;
  }

  public InputValidator lessThan(final Long value, final Long pivot, final String label) {
    if (Objects.isNull(value)) {
      String errorMsg = "'" + label + "' must not be null.";
      errors.add(errorMsg);
    } else if (value >= pivot) {
      String errorMsg =
          " The '"
              + label
              + "' is expected to be less than '"
              + pivot
              + "' instead of '"
              + value
              + "'";
      errors.add(errorMsg);
    }
    return this;
  }

  public InputValidator greaterThan(final Long value, final Long pivot, final String label) {
    if (Objects.isNull(value)) {
      String errorMsg = "'" + label + "' must not be null.";
      errors.add(errorMsg);
    } else if (value <= pivot) {
      String errorMsg =
          " The '"
              + label
              + "' is expected to be greater than "
              + pivot
              + " but actually is "
              + value;
      errors.add(errorMsg);
    }
    return this;
  }

  public void clearErrors() {
    this.errors.clear();
  }

  public void addErrorMessage(final String message) {
    if (StringUtils.isNotBlank(message)) {
      this.errors.add(message);
    }
  }
}
