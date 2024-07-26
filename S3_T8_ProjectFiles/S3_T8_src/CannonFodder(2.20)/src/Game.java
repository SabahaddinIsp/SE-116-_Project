
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        boolean temp=true;


        ArrayList<Items> inventory = new ArrayList<>();
        ArrayList<Weapons> weaponsList=new ArrayList<>();
        ArrayList<Clothes> clothesList=new ArrayList<>();
        ArrayList<Tank>tanks=new ArrayList<>();
        ArrayList<Healer>healers=new ArrayList<>();
        ArrayList<EnemySoldier>enemySoldierArrayList=new ArrayList<>();
        ArrayList<Characters> fighters=new ArrayList<>();

        Weapons longSword=new LongSword();
        Weapons shortSword=new ShortSword();
        Weapons boneWand=new BoneWand();
        Weapons buckler=new Buckler();
        Weapons scimitar=new Scimitar();
        Weapons smallShield=new SmallShield();
        Weapons towerShield=new TowerShield();
        Weapons woodWand=new WoodWand();

        Clothes hardArmor=new HardArmor();
        Clothes lightArmor=new LightArmor();
        Clothes mediumArmor=new MediumArmor();

        weaponsList.add(longSword);
        weaponsList.add(shortSword);
        weaponsList.add(boneWand);
        weaponsList.add(buckler);
        weaponsList.add(scimitar);
        weaponsList.add(smallShield);
        weaponsList.add(towerShield);
        weaponsList.add(woodWand);

        clothesList.add(hardArmor);
        clothesList.add(lightArmor);
        clothesList.add(mediumArmor);

        Characters fighter1=new Fighter();
        fighter1.setWeapons(weaponsList.get(random.nextInt(8)));
        fighter1.setClothes(clothesList.get(random.nextInt(3)));
        fighters.add(fighter1);
        fighter1.getArrayList().add(fighter1.getWeapons());
        fighter1.getArrayList().add(fighter1.getClothes());

        Healer healer1=new Healer();
        healer1.setWeapons(weaponsList.get(random.nextInt(8)));
        healer1.setClothes(clothesList.get(random.nextInt(3)));
        healers.add(healer1);
        healer1.getArrayList().add(healer1.getWeapons());
        healer1.getArrayList().add(healer1.getClothes());


        Tank tank1=new Tank();
        tank1.setWeapons(weaponsList.get(random.nextInt(8)));
        tank1.setClothes(clothesList.get(random.nextInt(3)));
        tanks.add(tank1);
        tank1.getArrayList().add(tank1.getWeapons());
        tank1.getArrayList().add(tank1.getClothes());

        EnemySoldier enemySoldier=new EnemySoldier();
        enemySoldier.setHp(5);
        enemySoldier.setWeapons(weaponsList.get(random.nextInt(8)));
        enemySoldier.setClothes(clothesList.get(random.nextInt(3)));
        enemySoldierArrayList.add(enemySoldier);
        enemySoldier.getArrayList().add(enemySoldier.getWeapons());
        enemySoldier.getArrayList().add(enemySoldier.getClothes());

        System.out.println("Hello, please enter your name: ");
        String playerName=scanner.nextLine();
        System.out.println(playerName+ " welcome.");



        fighter1.printInfo();
        System.out.println();
        healer1.printInfo();
        System.out.println();
        tank1.printInfo();
        System.out.println();


        while (temp){
            printMenu();
            int choice=scanner.nextInt();
            System.out.println(enemySoldierArrayList.size());
            EnemySoldier tempEnemy = enemySoldierArrayList.get(0);
            for(int i = 0 ; i< enemySoldierArrayList.size(); i++){
                if(enemySoldierArrayList.get(i)!=null) {
                    tempEnemy =enemySoldierArrayList.get(i);
                    break;
                }
            }
            if(choice==1){
                try {
                    tempEnemy.setWeapons(weaponsList.get(random.nextInt(8)));
                    System.out.println("Enemy Soldier's HP: "+tempEnemy.getHp());
                    fighter1.attack(fighter1,tempEnemy);
                    System.out.println("Enemy Soldier's HP: "+tempEnemy.getHp());

                    fighter1.printInfo();
                    healer1.printInfo();
                    if(tempEnemy.getHp()<=0){
                        System.out.println("Enemy Died!!");
                        inventory.add(tempEnemy.getWeapons());
                        enemySoldierArrayList.remove(tempEnemy);
                        if(enemySoldierArrayList.size()==0){
                            healer1.setLevel(1+healer1.getLevel());
                            fighter1.setLevel(1+fighter1.getLevel());
                            tank1.setLevel(1+tank1.getLevel());
                            enemyNumber(healer1,enemySoldierArrayList);
                        }
                        System.out.println(enemySoldierArrayList.size());
                        fighter1.printInfo();
                    }
                    else if(tempEnemy.getHp()>0) {
                        System.out.println("Now, Enemy's turn!!");
                        if(tank1.getHp()>0){
                            tempEnemy.attack(tempEnemy,tank1);
                            System.out.println("Tank's HP: "+ tank1.getHp());
                            if(tank1.getHp()<=0){
                                tanks.remove(tank1);
                            }
                        }
                        else if(fighter1.getHp()>0){
                            tempEnemy.attack(tempEnemy,fighter1);
                            if(fighter1.getHp()<=0){
                                fighters.remove(fighter1);
                            }
                        }
                        else if(healer1.getHp()>0){
                            tempEnemy.attack(tempEnemy,healer1);
                            if(healer1.getHp()<=0){
                                healers.remove(healer1);
                                System.out.println("Game over");
                                temp=false;
                            }
                        }
                    }

                }
                catch (Exception e){
                    System.out.println("Please enter available options");
                }

            }
            else if(choice==2){
                try {
                    System.out.println("Wield Part");

                    System.out.println("Choose your character to wield");
                    System.out.println("Enter 1 for fighter");
                    System.out.println("Enter 2 for tank");
                    System.out.println("Enter 3 for healer");
                    int choice7 = scanner.nextInt();
                    if (choice7==1){
                        System.out.println("If you want to take enemy's weapon enter to 1 ");
                        System.out.println("If you want to take random weapon enter to 2");
                        int choice2=scanner.nextInt();
                        if(choice2==1){
                            fighter1.printInfo();
                            fighter1.pick(fighter1,enemySoldier);
                            fighter1.wield(fighter1,enemySoldierArrayList.get(0).getWeapons());
                            fighter1.printInfo();
                        }
                        else if(choice2==2){
                            fighter1.printInfo();
                            fighter1.wield(fighter1,weaponsList.get(random.nextInt(8)));
                            fighter1.printInfo();}
                        else{
                            continue;
                        }
                    }
                    else if(choice7==2){
                        System.out.println("If you want to take enemy's weapon enter to 1 ");
                        System.out.println("If you want to take random weapon enter to 2");
                        int choice2=scanner.nextInt();
                        if(choice2==1){
                            tank1.printInfo();
                            tank1.pick(tank1,enemySoldier);
                            tank1.wield(tank1,enemySoldierArrayList.get(0).getWeapons());
                            tank1.printInfo();
                        }
                        else if(choice2==2){
                            tank1.printInfo();
                            tank1.wield(tank1,weaponsList.get(random.nextInt(8)));
                            tank1.printInfo();}
                        else{
                            continue;
                        }
                    }
                    else if(choice7==3){
                        System.out.println("If you want to take enemy's weapon enter to 1 ");
                        System.out.println("If you want to take random weapon enter to 2");
                        int choice2=scanner.nextInt();
                        if(choice2==1){
                            healer1.printInfo();
                            healer1.pick(healer1,enemySoldier);
                            healer1.wield(healer1,enemySoldierArrayList.get(0).getWeapons());
                            healer1.printInfo();
                        }
                        else if(choice2==2){
                            healer1.printInfo();
                            healer1.wield(healer1,weaponsList.get(random.nextInt(8)));
                            healer1.printInfo();}
                        else{
                            continue;
                        }
                    }

                }
                catch (Exception e){
                    System.out.println("Please enter available options ");
                }
            }
            else if(choice==3){
                try {
                    System.out.println("Armor Part");

                    System.out.println("Choose your character to Wear");
                    System.out.println("Enter 1 for Fighter");
                    System.out.println("Enter 2 for Tank");
                    System.out.println("Enter 3 for Healer");
                    int input= scanner.nextInt();

                    if(input==1){
                        System.out.println("If you want to take enemy's armor enter to 1 ");
                        System.out.println("If you want to take random weapon enter to 2");
                        int choice3=scanner.nextInt();
                        System.out.println(fighter1.getHp());
                        if(choice3==1){
                            fighter1.wear(fighter1,enemySoldierArrayList.get(0).getClothes());
                            clothesList.add(enemySoldierArrayList.get(0).getClothes());
                            System.out.println(fighter1.getHp());
                        }
                        else if(choice3==2){
                            fighter1.wear(fighter1,clothesList.get(random.nextInt(3)));
                            System.out.println(fighter1.getHp());
                        }
                        else{
                            continue;
                        }
                    }
                    else if(input==2){
                        System.out.println("If you want to take enemy's armor enter to 1 ");
                        System.out.println("If you want to take random weapon enter to 2");
                        int choice3=scanner.nextInt();
                        System.out.println(tank1.getHp());
                        if(choice3==1){
                            tank1.wear(tank1,enemySoldierArrayList.get(0).getClothes());
                            clothesList.add(enemySoldierArrayList.get(0).getClothes());
                            System.out.println(tank1.getHp());
                        }
                        else if(choice3==2){
                            tank1.wear(tank1,clothesList.get(random.nextInt(3)));
                            System.out.println(tank1.getHp());
                        }
                        else{
                            continue;
                        }
                    }
                    else if(input==3){
                        System.out.println("If you want to take enemy's armor enter to 1 ");
                        System.out.println("If you want to take random weapon enter to 2");
                        int choice3=scanner.nextInt();
                        System.out.println(healer1.getHp());
                        if(choice3==1){
                            healer1.wear(healer1,enemySoldierArrayList.get(0).getClothes());
                            clothesList.add(enemySoldierArrayList.get(0).getClothes());
                            System.out.println(healer1.getHp());
                        }
                        else if(choice3==2){
                            healer1.wear(healer1,clothesList.get(random.nextInt(3)));
                            System.out.println(healer1.getHp());
                        }
                        else{
                            continue;
                        }
                    }

                }
                catch (Exception e){
                    System.out.println("Please enter available options");
                }

            }
            else if(choice==4){
                try {
                    System.out.println("Choose a character to see its items");
                    System.out.println("Enter 1 to use Fighter's inventory");
                    System.out.println("Enter 2 to use Tank's inventory");
                    System.out.println("Enter 3 to use Healer's inventory");
                    int choice5 = scanner.nextInt();
                    if(choice5==1){
                        System.out.println("------Inventory of Fighter-------");
                        fighter1.listInventory(fighter1);
                    }
                    else if(choice5==2){
                        System.out.println("------Inventory of Tank-------");
                        tank1.listInventory(tank1);
                    }
                    else if(choice5==3){
                        System.out.println("------Inventory of Healer--------");
                        healer1.listInventory(healer1);
                    }

                }
                catch (Exception e){
                    System.out.println("Please enter available options.");
                }
            }
            else if(choice==5){
                try {
                    System.out.println("Examine");
                    System.out.println("Enter 1 to examine fighter's items");
                    System.out.println("Enter 2 to examine healer's items");
                    System.out.println("Enter 3 to examine tank's items");
                    int choice6 = scanner.nextInt();
                    if (choice6==1) {
                        fighter1.examine(fighter1.getWeapons());
                        fighter1.examine(fighter1.getClothes());
                    }
                    else if(choice6==2){
                        healer1.examine(healer1.getWeapons());
                        healer1.examine(healer1.getClothes());
                    }
                    else if(choice6==3){
                        tank1.examine(tank1.getWeapons());
                        tank1.examine(tank1.getClothes());
                    }

                }
                catch (Exception e){
                    System.out.println("Please enter available options.");
                }
            }
            else if (choice == 6){
                try {
                    System.out.println("Choose a character to use its special power");
                    System.out.println("Enter 1 to use Fighter's special action");
                    System.out.println("Enter 2 to use Tank's special action");
                    System.out.println("Enter 3 to use Healer's special action");

                    int choice3 = scanner.nextInt();

                    if(choice3 == 1){
                        System.out.println(tempEnemy.getHp());
                        fighter1.specialAction(fighter1,tempEnemy);
                        System.out.println(tempEnemy.getHp());
                    }
                    else if(choice3 == 2){
                        System.out.println(tank1.getHp());
                        System.out.println("Tank has used its special power");
                        tank1.specialAction(tank1,tank1);
                        System.out.println(tank1.getHp());
                    }
                    else if(choice3 == 3){
                        System.out.println("Enter 1 to heal fighter");
                        System.out.println("Enter 2 to heal Tank");
                        System.out.println("Enter 3 to heal itself");
                        int choice4 = scanner.nextInt();
                        if(choice4==1){
                            System.out.println(fighter1.getHp());
                            healer1.specialAction(healer1,fighter1);
                            System.out.println("Healer has used its special power");
                            System.out.println(fighter1.getHp());
                        }
                        else if(choice4==2){
                            System.out.println(tank1.getHp());
                            healer1.specialAction(healer1,tank1);
                            System.out.println("Healer has used its special power");
                            System.out.println(tank1.getHp());
                        }
                        else if(choice4==3){
                            System.out.println(healer1.getHp());
                            healer1.specialAction(healer1,healer1);
                            System.out.println("Healer has used its special power");
                            System.out.println(healer1.getHp());
                        }
                    }
                }
                catch (Exception e){
                    System.out.println("Please enter available options.");
                }
            }

            else if(choice==7){
                try {
                    System.out.println("Exit....");
                    temp=false;
                }
                catch (Exception e){
                    System.out.println("Please enter available options.");
                }
            }
            else{
                continue;

            }
        }
    }

    public static void printMenu(){
        System.out.println("Please enter 1 to attack to enemy soldier.");
        System.out.println("Please enter 2 to wield.");
        System.out.println("Please enter 3 to armor");
        System.out.println("Please enter 4 to see inventory");
        System.out.println("Please enter 5 to see examine");
        System.out.println("Please enter 6 to use special action");
        System.out.println("Please enter 7 to exit");
    }

    public static void enemyNumber(Characters characters,ArrayList arrayList) {
        if (characters.getLevel() != 0) {
            for(int i = 0; i<(characters.getLevel()*2) ;i++){
                EnemySoldier enemySoldier = new EnemySoldier();
                enemySoldier.setHp(characters.getLevel()*5+10);
                arrayList.add(enemySoldier);
                enemySoldier.setHp((characters.getLevel()+1)*5);
            }
        }
    }
}