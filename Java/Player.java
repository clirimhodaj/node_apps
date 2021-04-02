import java.util.ArrayList;

public class Player {
    private String handleName;
    private int lives;
    private int level;
    private int score;
    private Weapon weapon;
    ArrayList<Loot> inventory; 

    public Player(){
        setHandleName("Unknown player");
        setLives(3);
        setLevel(1);
        setScore(0);
        setDefaultWeapon();
        inventory = new ArrayList<>();
    }

    public ArrayList<Loot> getInventory() {
        return inventory;
    }

    // public void setInventory(ArrayList<Loot> inventory) {
    //     this.inventory = inventory;
    // }

    public void pickUpLoot(Loot loot){
        inventory.add(loot);
    }

    public boolean dropLoot(Loot loot){
        if(this.inventory.contains(loot)){
            inventory.remove(loot);
            return true;
        }
        return false;
    }

    public Player(String emri, int level){
        setHandleName(emri);
        setLives(3);
        setLevel(level);
        setScore(0);
        setDefaultWeapon();
        inventory = new ArrayList<>();
    }

    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public void setDefaultWeapon(){
        this.setWeapon(new Weapon("Sword", 10, 20));
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setHandleName(String handleName) {
        if(handleName.length()<3){
            System.out.println("The name " + handleName + " should be greater than 3 characters");
            return;
        }
        else
        this.handleName = handleName;
    }
    public String getHandleName(){
        return handleName;
    }
    public void showInventory(){
        for(Loot item : inventory){
            System.out.println(item.getName());
        }
        System.out.print("======================");
    }

    
}
