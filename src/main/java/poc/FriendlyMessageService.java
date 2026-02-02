package poc;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FriendlyMessageService implements MessageService {
  private final Clock clock;

  @Inject
  public FriendlyMessageService(Clock clock) {
    this.clock = clock;
  }

  @Override
  public String messageFor(String name) {
    return "Hi, " + name + "! (" + clock.nowIso() + ")";
  }
}
