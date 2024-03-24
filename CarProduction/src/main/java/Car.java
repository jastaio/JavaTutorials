import java.util.ArrayList;
import java.util.List;

public class Car {

  private final List<Seat> seats = new ArrayList<>();
  private final String brand;
  private final String model;
  private Steeringwheel steeringwheel;
  private String plate;
  private String color;

  public Car(String brand, String model) {
    this.brand = brand;
    this.model = model;
  }

  public List<Seat> getSeats() {
    return seats;
  }

  public void addSeat(Seat seat) {
    seats.add(seat);
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public Steeringwheel getSteeringwheel() {
    return steeringwheel;
  }

  public void setSteeringwheel(Steeringwheel steeringwheel) {
    this.steeringwheel = steeringwheel;
  }

  public String getPlate() {
    return plate;
  }

  public void setPlate(String plate) {
    this.plate = plate;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}
