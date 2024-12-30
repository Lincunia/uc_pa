package menus;

public class Worker {
  private int ID, salary;
  private String name, address, phone, region;

  public Worker(int ID, int salary, String name, String address, String phone,
                String region) {
    this.ID = ID;
    this.salary = salary;
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.region = region;
  }
  public int getSalary() { return salary; }
  public int getID() { return ID; }
  public String getName() { return name; }
  public String getAddress() { return address; }
  public String getPhone() { return phone; }
  public String getRegion() { return region; }
}
