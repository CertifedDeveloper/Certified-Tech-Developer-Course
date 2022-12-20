let prompt = require("prompt-sync")({sigint:true})
let radio = prompt("Ingrese el radio del círculo: ")
const conversor = radio => 2 * Math.PI * radio 
console.log(conversor(radio))