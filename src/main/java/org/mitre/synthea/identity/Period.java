package org.mitre.synthea.identity;

import static org.mitre.synthea.helpers.Utilities.localDateToTimestamp;

import java.time.LocalDate;

public class Period {
  private LocalDate start;
  private LocalDate end;

  public Period() {

  }

  public Period(LocalDate start, LocalDate end) {
    this.start = start;
    this.end = end;
  }

  public boolean contains(LocalDate date) {
    return ((this.start.isBefore(date) || this.start.isEqual(date))
        && ((this.end == null) || (this.end.isAfter(date) || this.end.isEqual(date))));
  }

  public boolean contains(long timestamp) {
    return (localDateToTimestamp(this.start) <= timestamp)
        && ((this.end == null) ||
            (localDateToTimestamp(this.end) >= timestamp));
  }

  public boolean isBefore(long timestamp) {
    long startStamp = localDateToTimestamp(this.start);
    return timestamp <= startStamp;
  }

}
