package org.launchcode.dndproject.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Objects;


@Entity
public class DndCharacter extends AbstractEntity{
    //from abstractEntity it's getting id and name fields


    @Size(min=3 , max= 250, message = "Please enter a character name between 3 and 250 characters" )
    private String charClass;
    private String background;
    private String charRace;
    private String alignment;
    private String xp;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;

    public DndCharacter() {
    }
//TODO: learn how to write a function in Java and then finish this.
//    public ArrayList<Integer> rollAbilityScores(){
//        ArrayList<Integer> d6Rolls = null;
//        return d6Rolls;
//    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    public DndCharacter(String charClass, String background, String charRace, String alignment, String xp, Integer strength, Integer dexterity, Integer constitution, Integer intelligence, Integer wisdom, Integer charisma) {
        this.charClass = charClass;
        this.background = background;
        this.charRace = charRace;
        this.alignment = alignment;
        this.xp = xp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getCharRace() {
        return charRace;
    }

    public void setCharRace(String charRace) {
        this.charRace = charRace;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getXp() {
        return xp;
    }

    public void setXp(String xp) {
        this.xp = xp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DndCharacter that = (DndCharacter) o;
        return Objects.equals(charClass, that.charClass) && Objects.equals(background, that.background) && Objects.equals(charRace, that.charRace) && Objects.equals(alignment, that.alignment) && Objects.equals(xp, that.xp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(charClass, background, charRace, alignment, xp);
    }


}
