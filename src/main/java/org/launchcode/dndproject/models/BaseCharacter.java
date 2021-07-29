package org.launchcode.dndproject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity
public class BaseCharacter {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=3 , max= 250, message = "Please enter a character name between 3 and 250 characters" )
    private String charName;
    private String charClass;
    private String background;
    private String charRace;
    private String alignment;
    private String xp;

    public BaseCharacter() {}

    public BaseCharacter(Integer id, String charName, String charClass, String background, String charRace, String alignment, String xp) {
        this.id = id;
        this.charName = charName;
        this.charClass = charClass;
        this.background = background;
        this.charRace = charRace;
        this.alignment = alignment;
        this.xp = xp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
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
        BaseCharacter that = (BaseCharacter) o;
        return Objects.equals(id, that.id) && Objects.equals(charName, that.charName) && Objects.equals(charClass, that.charClass) && Objects.equals(background, that.background) && Objects.equals(charRace, that.charRace) && Objects.equals(alignment, that.alignment) && Objects.equals(xp, that.xp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, charName, charClass, background, charRace, alignment, xp);
    }


}
