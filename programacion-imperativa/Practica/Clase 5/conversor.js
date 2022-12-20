let prompt = require("prompt-sync")({sigint:true})
let pulgadas = prompt("Ingrese número en pulgadas: ")
const conversor = pulgadas => pulgadas * 2.54 
console.log(conversor(pulgadas))