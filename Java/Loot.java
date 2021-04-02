enum LootType { POTION, RING, ARMOR }

public class Loot {
    private String name;
    private LootType type;
    private int value;

    public Loot(String name, LootType type, int value) {
        this.setName(name);
        this.setType(type);
        this.setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LootType getType() {
        return type;
    }

    public void setType(LootType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

