let prompt = require("prompt-sync")({sigint:true})
//let dato = prompt("Ingrese un dato: ")
dato = 10
const tipo = dato => typeof dato
console.log(tipo(dato))