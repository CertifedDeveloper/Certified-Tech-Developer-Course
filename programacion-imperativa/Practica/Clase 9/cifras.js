let prompt = require("prompt-sync")({sigint:true})
let numero = prompt("Escriba un número natural de hasta dos cifras: ")
const resultado = (numero) => {
    if (Math.round(Number(numero)) != numero){
        return "Ingrese un número natural"
    }else if (numero.length > 3){
        return "Ingrese un número menor o igual a dos cifras"
    }else{
        return 3 - numero.length
    }
}
console.log(resultado(numero))