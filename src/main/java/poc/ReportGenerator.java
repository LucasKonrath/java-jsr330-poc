package poc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

public class ReportGenerator {
  private final Provider<MessageService> formalServiceProvider;

  @Inject
  public ReportGenerator(@Named("formal") Provider<MessageService> formalServiceProvider) {
    this.formalServiceProvider = formalServiceProvider;
  }

  public String generate() {
    // Provider.get() demonstrates late resolution / lazy retrieval.
    MessageService service = formalServiceProvider.get();
    return "REPORT: " + service.messageFor("Reader");
  }
}
