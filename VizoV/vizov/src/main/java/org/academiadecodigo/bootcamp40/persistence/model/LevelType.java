package org.academiadecodigo.bootcamp40.persistence.model;

public enum LevelType {

    LEVEL_1("Citizen", 1, 3),
    LEVEL_2("Comrade", 4, 6),
    LEVEL_3("KGB", 7, 9);

    private String name;
    private int min;
    private int max;

    LevelType(String name, int min, int max){
        this.name = name;
        this.min = min;
        this.max = max;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public String getName() {
        return name;
    }
}
