package org.launchcode.dndproject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity
public class BaseCharacter extends AbstractEntity{



    @Size(min=3 , max= 250, message = "Please enter a character name between 3 and 250 characters" )
    private String charClass;
    private String background;
    private String charRace;
    private String alignment;
    private String xp;

    public BaseCharacter() {}

    public BaseCharacter(Integer id, String charName, String charClass, String background, String charRace, String alignment, String xp) {

        this.charClass = charClass;
        this.background = background;
        this.charRace = charRace;
        this.alignment = alignment;
        this.xp = xp;
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
        return Objects.equals(charClass, that.charClass) && Objects.equals(background, that.background) && Objects.equals(charRace, that.charRace) && Objects.equals(alignment, that.alignment) && Objects.equals(xp, that.xp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(charClass, background, charRace, alignment, xp);
    }


}
