public class Main {

  public static void main(String[] args) {
    Car audiA4 = new Car("Audi", "A5");

    audiA4.setColor("green");

    Steeringwheel steeringwheel = new Steeringwheel("Leather", 38);
    audiA4.setSteeringwheel(steeringwheel);

    audiA4.addSeat(new Seat("Leather", 10, true));
    audiA4.addSeat(new Seat("Leather", 10, true));
    audiA4.addSeat(new Seat("Fabric", 8, false));
    audiA4.addSeat(new Seat("Fabric", 8, false));
    audiA4.addSeat(new Seat("Fabric", 8, false));

    audiA4.setPlate("ABCD1");

    System.out.println(
        "Car: " + audiA4.getBrand() + " " + audiA4.getModel() + " in " + audiA4.getColor());
    System.out.println(
        "Steeringwheel: " + audiA4.getSteeringwheel().getMaterial() + " steeringwheel which is "
            + audiA4.getSteeringwheel().getDiameter() + "cm big");

    int count = 1;
    String tempSeatOutput;
    for (Seat seat : audiA4.getSeats()) {
      tempSeatOutput =
          "Seat " + count + ": " + seat.getMaterial() + " seat which weights " + seat.getWeight()
              + "kg";

      if (seat.isHeating()) {
        tempSeatOutput += " and can heat up";
      } else {
        tempSeatOutput += " and cannot heat up";
      }

      System.out.println(tempSeatOutput);
      count++;
    }

    System.out.println("Plate: " + audiA4.getPlate());
  }
}
