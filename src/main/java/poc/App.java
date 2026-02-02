package poc;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {
  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new AppModule());

    Greeter greeter = injector.getInstance(Greeter.class);
    System.out.println(greeter.greet("JSR-330"));

    // Demonstrate Provider usage (lazy) and singleton behavior
    ReportGenerator generator = injector.getInstance(ReportGenerator.class);
    System.out.println(generator.generate());
  }
}
