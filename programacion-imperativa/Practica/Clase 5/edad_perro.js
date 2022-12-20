let prompt = require("prompt-sync")({sigint:true})
let edad = prompt("Ingrese una edad perruna: ")
const conversor = edad => edad * 7 
console.log(conversor(edad))