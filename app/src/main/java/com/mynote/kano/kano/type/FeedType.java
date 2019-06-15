package com.mynote.kano.kano.type;

import java.lang.String;
import javax.annotation.Generated;

/**
 * A list of options for the sort order of the feed
 */
@Generated("Apollo GraphQL")
public enum FeedType {
  /**
   * Sort by a combination of freshness and score, using Reddit's algorithm
   */
  HOT("HOT"),

  /**
   * Newest entries first
   */
  NEW("NEW"),

  /**
   * Highest score entries first
   */
  TOP("TOP"),

  /**
   * Auto generated constant for unknown enum values
   */
  $UNKNOWN("$UNKNOWN");

  private final String rawValue;

  FeedType(String rawValue) {
    this.rawValue = rawValue;
  }

  public String rawValue() {
    return rawValue;
  }

  public static FeedType safeValueOf(String rawValue) {
    for (FeedType enumValue : values()) {
      if (enumValue.rawValue.equals(rawValue)) {
        return enumValue;
      }
    }
    return FeedType.$UNKNOWN;
  }
}
