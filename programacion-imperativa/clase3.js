const prompt = require("prompt-sync")({signit:true})
// VARIABLES (let o const) = espacios en memoria o una cajita

let nombre = prompt("Por favor ingrese su nombre: ")
console.log("Hola " + nombre + " cómo estas?")