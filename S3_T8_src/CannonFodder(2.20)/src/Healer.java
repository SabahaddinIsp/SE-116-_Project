import java.util.ArrayList;
import java.util.Random;

public class Healer extends Characters{

    protected int level;


    public Healer() {
        Random random=new Random();
        setStrength(random.nextInt(7));
        setIntelligence(random.nextInt(10));
        setVitality(random.nextInt(5));
        setHp(getStrength()*0.7+ getIntelligence()*0.1+ getVitality()*0.2);
        setArrayList(new ArrayList<Items>());
        setWielded(false);
        setClothes(new Clothes());
        setWeapons(new Weapons());
        setInvSize(0.0);
        setLevel(0);
    }

    public Healer(int strength, int vitality, int intelligence, double hp, boolean isWielded, ArrayList<Items> arrayList, double invSize, Weapons weapons, Clothes clothes,int level){
        super(strength,vitality,intelligence,hp,isWielded,arrayList,invSize,weapons,clothes,level);
    }
    @Override
    public void specialAction(Characters healer, Characters target){
        System.out.println("Now, Character will heal the target");
        if (healer.getIntelligence() * healer.getWeapons().getDamage() < target.getStrength() * 0.7 + target.getIntelligence() * 0.1 + target.getVitality() * 0.2) {
            double tempHp= healer.getIntelligence() * healer.getWeapons().getDamage();
            target.setHp(target.getHp()+tempHp);
            System.out.println("Target's hp " + tempHp + " increased!");
        } else {
            double tempHp = (target.getStrength() * 0.7) + (target.getIntelligence() * 0.1) + (target.getVitality() * 0.2);
            target.setHp(target.getHp()+tempHp);
            System.out.println("Target's hp " + tempHp + " increased");
        }
    }


    @Override
    public double calculateDamage(Characters character){
        double v = character.setDamage1(character.getIntelligence()*character.getWeapons().getDamage());
        return v ;
    }

    @Override
    public void printInfo(){
        System.out.println("******HEALER INFO*******");
        super.printInfo();
    }

}
