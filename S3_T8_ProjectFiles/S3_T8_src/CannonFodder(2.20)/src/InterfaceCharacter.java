import java.util.ArrayList;

public interface InterfaceCharacter {

        void pick(Characters character, EnemySoldier enemySoldier);
        void specialAction(Characters characters,Characters target);
        void examine(Items items);
        void listInventory(Characters characters);
        void wear(Characters character,Clothes clothing);
        void attack(Characters character1,Characters character2);
        void unWield(Characters character);
        void wield(Characters character,Weapons weapons);
        double calculateDamage(Characters character);
    }
