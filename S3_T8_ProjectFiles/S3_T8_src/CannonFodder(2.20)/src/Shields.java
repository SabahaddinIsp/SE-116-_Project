public class Shields extends Weapons{

    private double attack;

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        Characters characters=new Characters();
        this.attack=attack;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Attack: "+ getAttack());
    }

    public double firstAttack(Characters characters){
        double first_attack= getDamage()*characters.getVitality();
        return first_attack;
    }
}
