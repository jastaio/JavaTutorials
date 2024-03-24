public class Seat {

  private final String material;
  private final int weight;
  private final boolean heating;

  public Seat(String material, int weight, boolean heating) {
    this.material = material;
    this.weight = weight;
    this.heating = heating;
  }

  public String getMaterial() {
    return material;
  }

  public int getWeight() {
    return weight;
  }

  public boolean isHeating() {
    return heating;
  }
}
