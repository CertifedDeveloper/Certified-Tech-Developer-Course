let prompt = require("prompt-sync")({sigint:true})
let estatura = prompt("Ingrese su estatura en metros: ")
let peso = prompt("Ingrese su peso en kilogramos: ")
const calculadorIMC = (estatura, peso) => peso / Math.pow(estatura,2) 
console.log(calculadorIMC(estatura, peso))