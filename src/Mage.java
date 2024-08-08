public class Mage {
    private String name;
    private int level;
    private int damage;
    private String type;

    public Mage(String name, int level, int damage, String type) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.type = type;
    }
    public String getInfo() {
        StringBuilder res = new StringBuilder();
        res.append(name).append(", ").append(level).append(", ").append(damage).append(", ").append(type);
        return res.toString();
    }
    public String fight (Mage mage) {
        if (mage.type.equals("fire") && type.equals("ice")) {
            return mage.name;
        } else if (mage.type.equals("fire") && type.equals("earth")) {
            return name;
        }
        if (mage.type.equals("ice") && type.equals("earth")) {
            return mage.name;
        }
        else if(mage.type.equals("ice") && type.equals("fire")){
            return name;
        }
        if (mage.type.equals("earth") && type.equals("fire")) {
            return mage.name;
        }
        else if(mage.type.equals("earth") && type.equals("ice")){
            return name;
        }
        if(mage.type.equals(type) && mage.level > level) {
            return mage.name;
        }
        else if (mage.type.equals(type) && mage.level < level){
            return name;
        }
        if (mage.level == level && mage.damage > damage) {
            return mage.name;
        }
        else if (mage.level == level && mage.damage < damage) {
            return name;
        }
        else {
            return "draw";
        }
    }
}

//
//поле name (имя, строка);
//поле level (уровень мага, число);
//поле damage (урон, число);
//поле type (тип магии, строка, может быть равен fire, ice, earth);
//конструктор, инициализирующий данные поля (name, level, damage, type);
//метод getInfo(), возвращающий строку вида {name, level, damage, type};
//метод fight(Mage mage), этот метод должен вернуть имя мага-победителя. Кто из них победит решается следующем образом:
//⚡ Маг огня побеждает мага льда, но проигрывает магу земли.
//⚡ Маг льда побеждает мага земли, но проигрывает магу огня.
//⚡ Маг земли побеждает мага огня, но проигрывает магу льда.
//⚡Если же стихия магов одинаковая, то выигрывает более высокоуровневый маг, если же и уровни одинаковы, то тот, у которого больший урон, если же и урон одинаковый, то вернуть строку draw (ничья).