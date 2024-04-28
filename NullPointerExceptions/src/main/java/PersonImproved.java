import java.util.ArrayList;
import java.util.List;

public class PersonImproved {
  private String name;
  private final List<PersonImproved> family = new ArrayList<>();

  public PersonImproved(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addFamilyMember(PersonImproved person) {
    family.add(person);
  }

  public List<PersonImproved> getFamily() {
    return family;
  }
}
