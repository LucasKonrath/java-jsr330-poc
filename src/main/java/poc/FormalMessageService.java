package poc;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FormalMessageService implements MessageService {
  private final Clock clock;

  @Inject
  public FormalMessageService(Clock clock) {
    this.clock = clock;
  }

  @Override
  public String messageFor(String name) {
    return "Hello, " + name + ". (" + clock.nowIso() + ")";
  }
}
