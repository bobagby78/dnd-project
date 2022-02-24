let input = require('readline-sync');



let dieRoll = (times, sides)=>{
    times = input.question(("How many times are your going to roll? :  "))
    sides = input.question("Which die would you like to roll? d___  ")
    let rolls = [];
    for(let i = 0; i < times; i ++){
        rolls.push(Math.ceil(Math.random() * sides));
    }

        return rolls
}

console.log(dieRoll());