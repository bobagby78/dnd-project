package org.launchcode.dndproject.models;

import javax.persistence.Entity;
import java.util.HashMap;

@Entity
public class CharacterSkillAbility extends AbstractEntity{

    private Integer armorClass;
    private Integer initiative;
    private Integer speed;
    private String hitDice;
    private Integer deathSaves;
//    private HashMap<String, String> spellCasting;
//    private HashMap<String, String> attacks;


    public CharacterSkillAbility(){};


    public CharacterSkillAbility(Integer armorClass, Integer initiative, Integer speed, String hitDice, Integer deathSaves, HashMap<String, String> spellCasting, HashMap<String, String> attacks) {
        this.armorClass = armorClass;
        this.initiative = initiative;
        this.speed = speed;
        this.hitDice = hitDice;
        this.deathSaves = deathSaves;
//        this.spellCasting = spellCasting;
//        this.attacks = attacks;
    }
}
