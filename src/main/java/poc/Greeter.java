package poc;

import javax.inject.Inject;
import javax.inject.Named;

public class Greeter {
  private final MessageService messageService;

  @Inject
  public Greeter(@Named("friendly") MessageService messageService) {
    this.messageService = messageService;
  }

  public String greet(String who) {
    return messageService.messageFor(who);
  }
}
