public class Weapon {
    private String name;
    private int damageInflicted;
    private int hitPoints;
    
    public Weapon(String name, int damageInflicted, int hitPoints) {
        this.setName(name);
        this.setDamageInflicted(damageInflicted);
        this.setHitPoints(hitPoints);
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    public int getDamageInflicted() {
        return damageInflicted;
    }
    public void setDamageInflicted(int damageInflicted) {
        this.damageInflicted = damageInflicted;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
