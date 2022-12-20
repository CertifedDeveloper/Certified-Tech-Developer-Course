let prompt = require("prompt-sync")({sigint:true})
const sumar = (numA, numB) => numA + numB 
let N = prompt("Ingrese el número límite: ")
let suma = 0
for (i = 1; i <= N; i++){
    suma = sumar(suma, i)
}
console.log(suma)