package poc;

import java.time.Instant;

public class Clock {
  public String nowIso() {
    return Instant.now().toString();
  }
}
