let prompt = require("prompt-sync")({sigint:true})
let frase = prompt("Escriba un número: ")
let frase2 = prompt("Escriba otro número: ")
console.log(Number(frase) + Number(frase2))