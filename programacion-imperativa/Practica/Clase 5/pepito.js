let prompt = require("prompt-sync")({sigint:true})
let texto = prompt("Ingrese un string: ")
const conversor = texto => `http://www.${texto}.com` 
console.log(conversor(texto))