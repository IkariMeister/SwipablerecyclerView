package com.ineco.nfc.entities;

public abstract class Card {
    protected int id;
    protected float money;
    protected String name;
    protected String owner;

    public Card(int id, float money, String name, String owner) {
        this.id = id;
        this.money = money;
        this.name = name;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public float getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }
}
