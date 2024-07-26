import java.util.ArrayList;

public class EnemySoldier extends Characters{

    private double hp;


    public EnemySoldier() {
        setStrength(0);
        setIntelligence(0);
        setVitality(0);
        setHp(0);
        setWielded(false);
        setArrayList(new ArrayList<Items>());
        setClothes(new Clothes());
        setWeapons(new Weapons());
        setInvSize(getStrength());
        setLevel(0);
    }

    public EnemySoldier(int strength, int vitality,int intelligence, double hp, boolean isWielded, ArrayList<Items>arrayList, double invSize,Weapons weapons,Clothes clothes,int level){
        super(strength,vitality,intelligence,hp,isWielded,arrayList,invSize,weapons,clothes,level);
    }

    @Override
    public void attack(Characters character1, Characters character2) {
        super.attack(character1, character2);
    }

    @Override
    public void wear(Characters character,Clothes clothing) {
        super.wear(character,clothing);
    }



    @Override
    public double getHp() {
        return hp;
    }

    @Override
    public void setHp(double hp) {
        this.hp = hp;
    }
}
