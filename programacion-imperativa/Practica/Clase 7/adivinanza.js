let prompt = require("prompt-sync")({sigint:true})
let num = prompt("Escriba un número: ")
let numrand = Math.random() * 10
numrand = Math.round(numrand)
if (numrand === Number(num)){
    console.log("Felicitaciones, ese era!")
}else{
    console.log("Lo siento, intenta nuevamente!")
    console.log(`El número secreto era el ${numrand}`)
}