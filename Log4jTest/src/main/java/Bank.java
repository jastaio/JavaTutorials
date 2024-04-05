import java.util.HashMap;
import java.util.Map;
import org.slf4j.*;

public class Bank {

  private final Logger LOGGER;
  private final Map<String, String> customers = new HashMap<>();
  private final Map<String, Long> balances = new HashMap<>();

  public Bank(String bankName) {
    LOGGER = LoggerFactory.getLogger(bankName);

    LOGGER.info("Bank has been created!");
  }

  public void register(String id, String password) {
    String errorMessage = "Customer cannot be registered!";

    if (id == null || id.isBlank()) {
      LOGGER.error(errorMessage + " Id is invalid!");
      return;
    }

    if (password == null || password.isBlank()) {
      LOGGER.error(errorMessage + " Password is invalid!");
      return;
    }

    if (password.length() < 8) {
      LOGGER.error(errorMessage + " Password must be at least 8 characters long");
      return;
    }

    if (customers.containsKey(id)) {
      LOGGER.error("Customer '{}' is already registered", id);
      return;
    }

    customers.put(id, password);
    balances.put(id, 0L);
    LOGGER.info("Customer '{}' successfully registered!", id);
  }

  public void login(String id, String password) {
    if ((id == null || password == null) || (!customers.containsKey(id) || !customers.get(id)
        .equals(password))) {
      LOGGER.error("Provided credentials are not valid!");
      return;
    }

    LOGGER.info("Customer '{}' Successfully logged in!", id);
  }

  public void deleteAccount(String id) {
    if (customers.containsKey(id)) {
      LOGGER.warn("Customer '{}' deleted!", id);
      return;
    }

    LOGGER.error("Customer '{}' is not registered!", id);
  }

  public void deposit(String id, Long amount) {
    if (!customers.containsKey(id)) {
      LOGGER.error("Customer '{}' is not registered!", id);
      return;
    }

    balances.put(id, balances.get(id) + amount);
    LOGGER.info("Customer '{}' deposited '{}'€", id, amount);
  }

  public void withdrawal(String id, Long amount) {
    if (!customers.containsKey(id)) {
      LOGGER.error("Customer '{}' is not registered!", id);
      return;
    }

    if (balances.get(id) - amount < 0) {
      LOGGER.error("Customer '{}' has not enough money!", id);
      return;
    }

    balances.put(id, balances.get(id) - amount);
    LOGGER.info("Customer '{}' withdrew '{}'€", id, amount);
  }
}
