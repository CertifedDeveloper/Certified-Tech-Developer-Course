let prompt = require("prompt-sync")({sigint:true})
let texto = prompt("Ingrese un string: ")
const conversor = texto => `¡¡¡${texto}!!!` 
console.log(conversor(texto))