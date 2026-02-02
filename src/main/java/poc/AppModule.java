package poc;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

public class AppModule extends AbstractModule {
  @Override
  protected void configure() {
    // Bind two implementations differentiated by @Named
    bind(MessageService.class)
        .annotatedWith(Names.named("friendly"))
        .to(FriendlyMessageService.class)
        .in(Scopes.SINGLETON);

    bind(MessageService.class)
        .annotatedWith(Names.named("formal"))
        .to(FormalMessageService.class)
        .in(Scopes.SINGLETON);

    // Bind a Clock as singleton (example of concrete class binding)
    bind(Clock.class).in(Scopes.SINGLETON);
  }
}
