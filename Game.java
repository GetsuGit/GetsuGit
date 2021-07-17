class Player {
    String name;
    double health;
    int level;
    
    //object member
    Weapon weapon;
    Armor  armor;
    
    //get the player name and HP
    Player(String name, double health){
        this.name = name;
        this.health = health;
    }
    
    void attack(Player opponent){
        double attackPower = this.weapon.attackPower;
        System.out.println(this.name + " attacking " + opponent.name);
        // memasukan attck ke defence
        opponent.defence(attackPower);
    }
    
    void defence(double attackPower){
        //get damage
        double damage;
        if (this.armor.defencePower < attackPower){
            damage = attackPower - this.armor.defencePower;
        } else {
            damage = 0;
        }
        
        this.health -= damage;
        System.out.println(this.name + " get damage " + damage);
    }
    
    // Weapon and Armor
    void equipWeapon(Weapon weapon){
        this.weapon = weapon;
    } 
    
    void equipArmor(Armor armor){
        this.armor = armor;
    }
    
    void display(){
        System.out.println("\nName : " + this.name);
        System.out.println("Health : " + this.health + " hp");
        this.weapon.display();
        this.armor.display();
    }
    
}

//senjata
class Weapon {
    String name;
    double attackPower;
    
    //get attackPower 
    Weapon(String name, double attackPower){
        this.name = name;
        this.attackPower = attackPower;
    }
    
    void display(){
        System.out.println("Weapon : " + this.name + ", Attack : " + this.attackPower);
    }
}

//armor 
class Armor {
    String name;
    double defencePower;
    
    //get deffense
    Armor(String name, double defencePower){
        this.name = name;
        this.defencePower = defencePower;
    }
    
     void display(){
        System.out.println("Armor : " + this.name + ", Defence : " + this.defencePower);
    }
}

public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hallo Getsu");
        
        //making player object
        Player user1 = new Player("Getsu",100);
        Player user2 = new Player("Kakang",50);
        
        //making player weapon 
        Weapon sword = new Weapon("sword",15);
        Weapon arrow = new Weapon("arrow",14);
        
        //making player armor
        Armor chainArmor = new Armor("chainArmor",10); 
        Armor shield = new Armor("shield",10);
        
        // player weapon and armor to
        user1.equipWeapon(sword) ;
        user1.equipArmor(chainArmor);
        user1.display();
        
        user2.equipWeapon(arrow);
        user2.equipArmor(shield);
        user2.display();
        
        System.out.println("\nFIGHTING");
        System.out.println("\nEpisode 1");
        user1.attack(user2);
        user1.display();
        user2.display();
        System.out.println("\nEpisode 2");
        user2.attack(user1);
        user1.display();
        user2.display();
    }
    
}
 