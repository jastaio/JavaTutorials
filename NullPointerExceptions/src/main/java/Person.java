import java.util.List;

public class Person {
  private String name;
  private List<Person> family;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addFamilyMember(Person person) {
    family.add(person);
  }

  public List<Person> getFamily() {
    return family;
  }
}
