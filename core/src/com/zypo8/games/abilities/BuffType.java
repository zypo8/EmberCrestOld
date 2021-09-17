package com.zypo8.games.abilities;

public enum BuffType {
    Magic("magic"),
    Curse("curse"),
    Poison("poison"),
    Disease("disease"),
    Other(" ");


    public String getString(){
        return string;
    }
    private final String string;
    BuffType(String string){
        this.string = string;
    }
}
