let prompt = require("prompt-sync")({sigint:true})
const sumar = (numA, numB) => numA + numB 
const promedio = (suma, N) => suma / N
let N = prompt("Ingrese el número de notas a ingresar: ")
let array = []
let suma = 0
for (i = 0; i <= N - 1; i++){
    array[i] = prompt(`Ingrese la nota número ${i + 1}: `)
    suma = sumar(suma, Number(array[i]))
}
let prd = promedio(suma, N)
console.log(prd)