package org.launchcode.dndproject.models;

import javax.persistence.GeneratedValue;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Objects;

public class BaseCharacter {

    @GeneratedValue
    private Integer id;

    @Size(min=3 , max= 250, message = "Please enter a character name between 3 and 250 characters" )
    private String name;
    private String charClass;
    private String background;
    private String race;
    private String alignment;
    private String xp;

    public BaseCharacter() {}

    public BaseCharacter(Integer id, String name, String charClass, String background, String race, String alignment, String xp) {
        this.id = id;
        this.name = name;
        this.charClass = charClass;
        this.background = background;
        this.race = race;
        this.alignment = alignment;
        this.xp = xp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
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
        BaseCharacter that = (BaseCharacter) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(charClass, that.charClass) && Objects.equals(background, that.background) && Objects.equals(race, that.race) && Objects.equals(alignment, that.alignment) && Objects.equals(xp, that.xp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, charClass, background, race, alignment, xp);
    }


}
