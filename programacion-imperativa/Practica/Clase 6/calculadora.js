let prompt = require("prompt-sync")({sigint:true})
const sumar = (a, b) => Number(a) + Number(b)
const restar = (a, b) => Number(a) - Number(b)
const multiplicar = (a, b) => Number(a) * Number(b)
const dividir = (a, b) => Number(a) / Number(b)
const cuadradoDeUnNumero = a => multiplicar(Number(a), Number(a))
const promedioDeTresNumeros = (a, b, c) => dividir(sumar(sumar(Number(a), Number(b)),Number(c)), 3)
const calcularPorcentaje = (numero, porcentaje) => multiplicar(Number(numero), dividir(Number(porcentaje), 100))
const generadorDePorcentaje = (a, b) => multiplicar(dividir(Number(a),Number(b)),100)
console.log("-------------- Testeo de Operaciones / Calculadora --------------")

// SUMA
// let sumaA = prompt("Ingrese el primer número a sumar: ")
// let sumaB = prompt("Ingrese el segundo número a sumar: ")
// console.log(sumar(sumaA,sumaB))

// MULTIPLICACIÓN
// let multA = prompt("Ingrese el primer número a multiplicar: ")
// let multB = prompt("Ingrese el segundo número a multiplicar: ")
// console.log(multiplicar(multA,multB))

// DIVISIÓN
// let divA = prompt("Ingrese el numerador: ")
// let divB = prompt("Ingrese el denominador: ")
// console.log(dividir(divA,divB))

// DIVISIÓN POR CERO
// divA = prompt("Ingrese el numerador a dividir por cero: ")
// divB = 0
// console.log(dividir(divA,divB))

// CUADRADO DE UN NÚMERO
// let cuadrado = prompt("Ingrese el número a elevar al cuadrado: ")
// console.log(cuadradoDeUnNumero(cuadrado))

// PROMEDIO DE TRES NÚMEROS
// let prmA = prompt("Ingrese el primer número a promediar: ")
// let prmB = prompt("Ingrese el segundo número a promediar: ")
// let prmC = prompt("Ingrese el segundo número a promediar: ")
// console.log(promedioDeTresNumeros(prmA,prmB,prmC))

// PORCENTAJE DE UN NÚMERO
// let numero = prompt("Ingrese el número a sacar porcentaje: ")
// let porcentaje = prompt("Ingrese el porcentaje(%): ")
// console.log(calcularPorcentaje(numero,porcentaje))

// GENERADOR DE PORCENTAJE
// let numeroA = prompt("Ingrese el primer número del porcentaje: ")
// let numeroB = prompt("Ingrese el segundo número del porcentaje: ")
// console.log(generadorDePorcentaje(numeroA,numeroB))