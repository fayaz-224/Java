package JavaConcepts.Serialization.JSON;

public class MobilePhone {
    private String brand;
    private String name;
    private int ram;
    private int rom;


    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public int getRom() {
        return rom;
    }
    public void setRom(int rom) {
        this.rom = rom;
    }


    @Override
    public String toString() {
        return "MobilePhone: [Brand = "+ brand + ", Name = " + name + ", RAM = " + ram + ", ROM = " + rom + "]";
    }
}
