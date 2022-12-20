let prompt = require("prompt-sync")({sigint:true})
let sueldo = prompt("Ingrese su sueldo mensual: ")
const conversor = sueldo => sueldo / 40 
console.log(conversor(sueldo))