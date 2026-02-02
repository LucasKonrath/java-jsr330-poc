package poc;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiTest {
  @Test
  void greeterUsesFriendlyService() {
    Injector injector = Guice.createInjector(new AppModule());
    Greeter greeter = injector.getInstance(Greeter.class);

    String out = greeter.greet("World");
    assertTrue(out.startsWith("Hi, World!"));
  }

  @Test
  void namedBindingsResolveToDifferentSingletons() {
    Injector injector = Guice.createInjector(new AppModule());

    MessageService friendly1 = injector.getInstance(
        com.google.inject.Key.get(MessageService.class, com.google.inject.name.Names.named("friendly")));
    MessageService friendly2 = injector.getInstance(
        com.google.inject.Key.get(MessageService.class, com.google.inject.name.Names.named("friendly")));

    MessageService formal = injector.getInstance(
        com.google.inject.Key.get(MessageService.class, com.google.inject.name.Names.named("formal")));

    assertSame(friendly1, friendly2, "friendly should be singleton");
    assertNotSame(friendly1, formal, "friendly and formal should be different bindings");
  }

  @Test
  void providerWorks() {
    Injector injector = Guice.createInjector(new AppModule());
    ReportGenerator generator = injector.getInstance(ReportGenerator.class);

    String report = generator.generate();
    assertTrue(report.startsWith("REPORT: Hello, Reader."));
  }
}
