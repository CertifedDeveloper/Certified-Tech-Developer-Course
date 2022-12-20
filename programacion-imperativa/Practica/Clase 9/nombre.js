let prompt = require("prompt-sync")({sigint:true})
let frase = prompt("Escriba un nombre: ")
console.log(`Hola ${frase}!`)