import java.util.ArrayList;
import java.util.Random;

public class Tank extends Characters {

    public Tank(){
        Random random=new Random();
        setStrength(random.nextInt(5));
        setIntelligence(random.nextInt(7));
        setVitality(random.nextInt(10));
        setHp(getStrength()*0.7+ getIntelligence()*0.1+ getVitality()*0.2);
        setArrayList(new ArrayList<Items>());
        setWielded(false);
        setClothes(new Clothes());
        setWeapons(new Weapons());
        setInvSize(0.0);
        setLevel(0);
    }
    public Tank(int strength, int vitality, int intelligence, double hp, boolean isWielded, ArrayList<Items> arrayList, double invSize, Weapons weapons, Clothes clothes,int level){
        super(strength,vitality,intelligence,hp,isWielded,arrayList,invSize,weapons,clothes,level);
    }


    @Override
    public void specialAction(Characters characters, Characters target){
        System.out.println("Tank's hp increased by target's hp");
        characters.setHp(characters.getHp() + target.getHp());
    }

    @Override
    public double calculateDamage(Characters character){
        double v = character.setDamage1(character.getVitality()*character.getWeapons().getDamage());
        return v ;
    }
    @Override
    public void printInfo(){
        System.out.println("******TANK INFO*******");
        super.printInfo();
    }

    @Override
    public void attack(Characters character1, Characters character2) {
        super.attack(character1, character2);
    }

    @Override
    public void wield(Characters character,Weapons weapons) {
        super.wield(character,weapons);
    }

    @Override
    public void unWield(Characters character) {
        super.unWield(character);
    }

    @Override
    public void wear(Characters character, Clothes clothing) {
        super.wear(character, clothing);
    }

    @Override
    public void pick(Characters character, EnemySoldier enemySoldier) {
        super.pick(character, enemySoldier);
    }

    @Override
    public void examine(Items items) {
        super.examine(items);
    }

    @Override
    public void listInventory(Characters characters) {
        super.listInventory(characters);
    }


}
