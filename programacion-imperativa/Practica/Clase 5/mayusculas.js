let prompt = require("prompt-sync")({sigint:true})
let texto = prompt("Ingrese un texto: ")
const mayusculas = texto => texto.toUpperCase() 
console.log(mayusculas(texto))