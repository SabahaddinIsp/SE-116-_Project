public class Clothes extends Items{

    private double protection;

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Protection= "+ getProtection());
    }

    public double getProtection() {
        return protection;
    }

    public void setProtection(double protection) {
        this.protection = protection;
    }
}
