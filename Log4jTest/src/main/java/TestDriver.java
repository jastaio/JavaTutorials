import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDriver {

  private static final Logger LOGGER = LoggerFactory.getLogger(TestDriver.class);

  public static void main(String[] args) throws InterruptedException {
    LOGGER.info("Application is starting...");

    Bank worldBank = new Bank("WorldBank Germany");
    worldBank.deposit("Id", 10L);
    worldBank.login("Id", "Password");
    worldBank.deleteAccount("Id");
    worldBank.register("Id", "");
    worldBank.register("", "Password");
    worldBank.register("Id", "Password");
    worldBank.register("Id", "Password");
    worldBank.login("Id", "Password");
    worldBank.withdrawal("Id", 10L);
    worldBank.deposit("Id", 1000L);
    worldBank.withdrawal("Id", 500L);
    worldBank.deleteAccount("Id");
    Thread.sleep(400);

    LOGGER.info("Application has stopped");
  }
}
