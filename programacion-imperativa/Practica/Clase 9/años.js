let prompt = require("prompt-sync")({sigint:true})
let año = prompt("Escriba su año de nacimiento: ")
const calculo = año =>{
    let currentTime = new Date()
    let year = currentTime.getFullYear()
    return year - año
}
let resultado = calculo(año)
console.log(`Tienes ${resultado} años`)