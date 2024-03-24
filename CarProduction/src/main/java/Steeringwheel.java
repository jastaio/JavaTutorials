public class Steeringwheel {

  private final String material;
  private final int diameter;

  public Steeringwheel(String material, int diameter) {
    this.material = material;
    this.diameter = diameter;
  }

  public String getMaterial() {
    return material;
  }

  public int getDiameter() {
    return diameter;
  }
}
