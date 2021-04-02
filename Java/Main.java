public class Main{
    
public static void main(String[] args) {
    Player p = new Player();
    p.setHandleName("Li");
    System.out.println(p.getHandleName());
    System.out.println(p.getLevel());
    System.out.println(p.getScore());
    Player tomas = new Player("Tomas",8);
    System.out.println(tomas.getWeapon().getName());

    Weapon myAxe = new Weapon("GoldShine",15,20);
    tomas.setWeapon(myAxe);
    System.out.println(tomas.getWeapon().getName());
    
    Loot redPortion = new Loot("Red portion",LootType.POTION,7);   
    Loot greePortion = new Loot("Green portion",LootType.ARMOR,7);
    tomas.pickUpLoot(redPortion);
    tomas.pickUpLoot(greePortion);
    
    tomas.showInventory();
}
}