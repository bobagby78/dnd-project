package org.launchcode.dndproject.models;

import javax.persistence.GeneratedValue;
import javax.validation.Valid;
import javax.validation.constraints.Size;

public class BaseCharacter {
    //@GeneratedValue
    private Integer id;

    @Size(min=3 , max= 250, message = "Please enter a character name between 3 and 250 characters" )
    private String name;


    /*TODO make the base character class an abstract class for all the rest. start by building each subclass.
     What fields does it need in the abstract class and what methods can we make to put into an interface?
     */

}
