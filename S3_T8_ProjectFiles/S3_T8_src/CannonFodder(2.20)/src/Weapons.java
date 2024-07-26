public class Weapons extends Items{

    private double damage;

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Damage: "+ getDamage());
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
}
