console.log("=============")
console.log("Loop de pares")
const loopDePares = numero => {
    for (let i = 0; i <= 100 ; i++){
        console.log(i)
        let suma = i + numero
        if (suma % 2 === 0){
            console.log(`El número ${suma} es par`)
        }
    }
}
// loopDePares(1)

console.log("=============")
console.log("Loop de impares")
const loopDeImpares = (numero, palabra) => {
    for (let i = 0; i <= 100 ; i++){
        console.log(i)
        let suma = i + numero
        if (suma % 2 !== 0){
            console.log(palabra)
        }
    }
}
// loopDeImpares(1, "hola")

console.log("=============")
console.log("Sumatoria")
const sumatoria = numero => {
    count = 0
    for (let i = 1; i <= numero; i++){
        count += i
    }
    return count
}
// let suma = sumatoria(8)
// console.log(suma)

console.log("=============")
console.log("Nuevo arreglo")
const nuevoArreglo = numero => {
    arr = []
    for (let i = 0; i < numero; i++){
        arr.push(i + 1)
    }
    return arr
}
// let arreglo = nuevoArreglo(10)
// console.log(arreglo)

console.log("=============")
console.log("Similar String.split()")
const splitString = texto => {
    arr = []
    for (let i = 0; i < texto.length; i++){
        arr.push(texto[i])
    }
    return arr
}
// let splitArreglo = splitString("hola")
// console.log(splitArreglo)

console.log("=============")
console.log("Manejando dos arreglos")
const arrayHandler = (a, b) => {
    for (let i = 0; i < a.length; i++){
        console.log(`Soy ${a[i]} y yo soy ${b[i]}`)
    }
}
// let a = [1, 2, 3, 4]
// let b = ["h", "o", "l", "a"]
// arrayHandler(a, b)

console.log("=============")
console.log("Palíndromo")
const palindromo = palabra => {
    palabra = palabra.toLowerCase()
    for (let i = 0; i < palabra.length; i++){
        if (palabra[i] != palabra[palabra.length - i - 1]){
            return false
        }
    }
    return true
}
// let palabraPalindroma = palindromo("Ana")
// console.log(palabraPalindroma)