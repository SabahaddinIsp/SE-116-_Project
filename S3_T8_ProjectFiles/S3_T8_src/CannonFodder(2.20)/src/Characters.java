import java.util.ArrayList;

public class Characters implements InterfaceCharacter{

    private int Strength;
    private int Vitality;
    private int Intelligence;
    private double hp ;
    private boolean isWielded;
    private ArrayList<Items> inventory;
    private double calculateDamage;
    protected Weapons weapons;
    private Clothes clothes;
    private double damage1;
    private double invSize;
    protected int level;

    public Characters(){
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

    public Characters(int strength, int vitality,int intelligence, double hp, boolean isWielded, ArrayList<Items>arrayList, double invSize,Weapons weapons,Clothes clothes,int level){
        setStrength(strength);
        setIntelligence(intelligence);
        setVitality(vitality);
        setHp(hp);
        setWielded(true);
        setArrayList(arrayList);
        setWeapons(weapons);
        setClothes(clothes);
        setInvSize(invSize);
        setLevel(level);
    }


    @Override
    public void attack(Characters character1,Characters character2){
        boolean temp=true;
        while (temp){
            character2.setHp((character2.getHp()-character1.getWeapons().getDamage()));
        if(character2.getHp() <= 0){
            System.out.println(character2+ "Has died!");
            character1.setLevel(character1.getLevel());

            temp=false;
        }
        temp=false;
        }
    }

    @Override
    public double calculateDamage(Characters character){
        double v = character.setDamage1(character.getStrength()*character.getWeapons().getDamage());
        return v ;
    }

    @Override
    public void wield(Characters character,Weapons weapons){
        if(character.getIsWielded()){
            System.out.println("***********************");
            System.out.println("Sorry you already wielded a weapon");
            System.out.println("***********************");
        }
        else if(!character.getIsWielded() && weapons.getName()=="Short Sword" || weapons.getName()=="Long Sword" || weapons.getName()=="Scimitar"){
            character.setStrength((int) (weapons.getDamage()*character.getStrength()));
            character.getArrayList().remove(weapons);
            System.out.println("You've wielded the Sword");
            character.setWielded(true);
            character.setWeapons(weapons);
        }
        else if(!character.getIsWielded() && weapons.getName()=="Small Shield" || weapons.getName()=="Buckler" || weapons.getName()=="Tower Shield"){
            character.setVitality((int) (weapons.getDamage()*character.getVitality()));
            character.getArrayList().remove(weapons);
            System.out.println("You've wielded the Shield");
            character.setWielded(true);
            character.setWeapons(weapons);
        }
        else if(!character.getIsWielded() && weapons.getName()=="Bone Wand" || weapons.getName()=="Wood Wand" ){
            character.setIntelligence((int) (weapons.getDamage()*character.getIntelligence()));
            character.getArrayList().remove(weapons);
            System.out.println("You've wielded the Wand");
            character.setWielded(true);
            character.setWeapons(weapons);
        }
    }


    @Override
    public void unWield(Characters character){
        if(!character.getIsWielded()){
            System.out.println("You did not wield anything!");
        }
        else {
            character.setWeapons(null);
        }
    }

    @Override
    public void wear(Characters character,Clothes clothing){
        character.setClothes(clothing);
        character.setHp(character.getHp()+clothing.getProtection());
        System.out.println("You got protection");

    }

    @Override
    public void pick(Characters character,EnemySoldier enemySoldier) {

        character.getArrayList().add(enemySoldier.getWeapons());

    }
    @Override
    public void specialAction(Characters characters, Characters target){

    }

    @Override
    public void examine(Items items) {
        System.out.println("Examine:");
        items.printInfo();
    }

    @Override
    public void listInventory(Characters characters) {
        for (int i=0;i<characters.getArrayList().size();i++){
            System.out.println(characters.getArrayList().get(i).getName());
        }

    }

    public void setVitality(int vitality) {
        Vitality = vitality;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public void setIntelligence(int intelligence) {
        Intelligence = intelligence;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setWielded(boolean wielded) {
        isWielded = wielded;
    }

    public void setArrayList(ArrayList<Items> arrayList) {
        this.inventory = arrayList;
    }

    public void setCalculateDamage(double calculateDamage) {
        this.calculateDamage = calculateDamage;
    }

    public double setDamage1(double damage1) {
        this.damage1 = damage1;
        return damage1;
    }

    public double getInvSize() {
        return invSize;
    }

    public void setInvSize(double invSize) {
        this.invSize = invSize;
    }

    public double getDamage1() {
        return damage1;
    }

    public double getCalculateDamage() {
        return calculateDamage;
    }

    public ArrayList<Items> getArrayList() {
        return inventory;
    }

    public boolean getIsWielded() {
        return isWielded;
    }

    public double getHp() {
        return hp;
    }
    public int getIntelligence() {
        return Intelligence;
    }

    public int getStrength() {
        return Strength;
    }

    public int getVitality() {
        return Vitality;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void printInfo(){
        System.out.println("Vitality of the Character: " + getVitality());
        System.out.println("Strength of the Character: " + getStrength());
        System.out.println("Intelligence of the Character: " +getIntelligence());
        System.out.println("Hp of the Character: " +getHp());
        System.out.println("Wield: "+ getWeapons().getName());
        System.out.println("Armor: "+ getClothes().getName());
        System.out.println("Level: "+ getLevel());
    }
}
