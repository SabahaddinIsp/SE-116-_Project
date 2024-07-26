public class Swords extends Weapons{

    private double attack;

    public double getAttack() {
        return attack;
    }


    public void setAttack(double attack) {

            this.attack=attack;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Attack: "+ getAttack());
    }

    public double firstAttack(Characters characters){
        double first_attack= getDamage()*characters.getStrength();
        return first_attack;
    }


}
