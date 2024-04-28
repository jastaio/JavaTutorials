public class TestDriver {

  public static void main(String[] args) {
    try {
      Person person1 = new Person();

      person1.addFamilyMember(new Person()); //NullPointerException: The addFamilyMember methods wants to add a person to a list which was never initialized

      for (Person p : person1.getFamily()) {
        System.out.println(p.getName()); //NullPointerException: Person p is always null since person1.getFamily returns null since the family members list was never initialized
      }

      System.out.println(person1.getName().charAt(0)); //NullPointerException: The name was never set. Therefore, getName returns null
    } catch (NullPointerException e) {
      e.printStackTrace();
    }

    try {
      PersonImproved person1 = new PersonImproved("Jack");

      person1.addFamilyMember(new PersonImproved("Jack Jr."));

      for (PersonImproved p : person1.getFamily()) {
        System.out.println(p.getName());
      }

      System.out.println(person1.getName().charAt(0));

      System.out.println("No exception occured!");
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
  }
}
