//Dejo Desafío para quien quiera practicar,                                                                                                                                                                                                                                                                           - En caso de resolverlo sin problemas reaccionar con :white_check_mark: ,                                                                                                                                                                                                                        - Caso  contrario,  consultar en este canal la duda acompañada con algo  código, *`Buen código`*```js

// A - Nivel 1
console.log("A - Nivel 1")
console.log("======================")

console.log("ejercicio A")
// 1 - Desarrollar una función que reciba 2 numeros y retorne la suma de ambos
const suma = (a, b) => {
    return a + b
}
let sumaNumeros = suma(1, 2)
console.log(sumaNumeros)

// 2 - Desarrollar una función que reciba 2 numeros y 
//      retorne la suma de ambos, si el primer parametro es mayor, 
//      caso contrario retornar la resta.
console.log("======================")
console.log("ejercicio B")
const sumaB = (a, b) => {
    if (a > b){
        return a + b
    } else{
        return a - b
    }
}
let sumaNumerosB = sumaB(2, 1)
console.log(sumaNumerosB)


// 3 - Desarrollar una función que reciba 4 numeros y calcular la suma de total
//      si el el resultado es mayor o igual a 7, retornar 'Aprobado', 
//      caso contrario retornar 'otra chance '.
console.log("======================")
console.log("ejercicio C")
const sumaC = (a, b, c, d) => {
    let suma = a + b + c + d
    if (suma >= 7){
        return "Aprobado"
    } else{
        return "otra chance"
    }
}
let sumaNumerosC = sumaC(2, 1, 1, 3)
console.log(sumaNumerosC)

// 4 - Desarrollar una función que reciba 4 numeros y calcular la suma de total
//      si el el resultado es par, retornar la mitad del total,  
//      caso contrario retornar el doble del total.
console.log("======================")
console.log("ejercicio D")
const sumaD = (a, b, c, d) => {
    let suma = a + b + c + d
    if (suma % 2 === 0){
        return suma / 2
    } else{
        return suma * 2
    }
}
let sumaNumerosD = sumaD(1, 1, 1, 2)
console.log(sumaNumerosD)


// B  Nivel 2
// - Declarar 3 arrays de edades por ejemplo -> [10, 9, 8, 22, 55, 80, 5, 63, 29, 9] , luego desarrollar las siguientes funciones:
console.log("======================")
console.log("B  Nivel 2")

// 1 - Funcion que reciba un array de edades y retorne el promedio 
console.log("======================")
console.log("ejercicio A")
const promedio = a => {
    let suma = 0
    for (let i = 0; i < a.length; i++){
        suma += a[i]
    }
    return suma / a.length
}
let promedioNumeros = promedio([1, 2, 3])
console.log(promedioNumeros)

// 2 - Funcion que reciba un array de edades y retorne el mayor elemento // 80
console.log("======================")
console.log("ejercicio B")
const mayor = a => {
    let mayor = a[0]
    for (let i = 0; i < a.length; i++){
        if (a[i] > mayor){
            mayor = a[i]
        }
    }
    return mayor
}
let mayorNumeros = mayor([1, 2, 3])
console.log(mayorNumeros)

// 3 - Funcion que reciba un array de edades y retorne el menor elemento // 5
console.log("======================")
console.log("ejercicio C")
const menor = a => {
    let menor = a[0]
    for (let i = 0; i < a.length; i++){
        if (a[i] < menor){
            menor = a[i]
        }
    }
    return menor
}
let menorNumeros = menor([1, 2, 3])
console.log(menorNumeros)

// 4 - Funcion que reciba un array de edades y retorne true si encuentra algun elemento repetido o false caso contrario
console.log("======================")
console.log("ejercicio D")
const repetido = a => {
    let menor = a[0]
    for (let i = 0; i < a.length; i++){
        for (let j = i + 1; j < a.length - i; j++){
            if (a[i] === a[j]){
                return true
            }
        }
    }
    return false
}
let numeroRepetido = repetido([1, 2, 1])
console.log(numeroRepetido)

// 5 - Funcion que reciba un array de edades y una edada buscar, retorne el primer índice si encuentra coincidencia o null caso contrario
console.log("======================")
console.log("ejercicio E")
const encontrar = (array, numero) => {
    for (let i = 0; i < array.length; i++){
        if (array[i] === numero){
            return i
        }
        
    }
    return null
}
let numeroEncontrado = encontrar([1, 2, 1], 2)
console.log(numeroEncontrado)

// 6 - Funcion que reciba un array de edades y retorne un objeto literal con dos propiedades que contengan un array
//    {
//       edadesMenor : "// edades menor a 18",  
//       edadesMayor : "// edades menor a 18"
//    }
console.log("======================")
console.log("ejercicio F")
const tipoEdades = a => {
    let edadesMenor = []
    let edadesMayor = []
    for (let i = 0; i < a.length; i++){
        if (a[i] < 18){
            edadesMenor.push(a[i])
        } else if(a[i] > 18){
            edadesMayor.push(a[i])
        }
    }
    return {edadesMenor: edadesMenor, edadesMayor: edadesMayor}
}
let tipoEdad = tipoEdades([1, 2, 3, 24, 25])
console.log(tipoEdad)

// C  Nivel 3
console.log("======================")
console.log("C  Nivel 3")
// 1 - Desarrollar un objeto literal que contenga 5 propiedades que sean del siguiente tipo:
//    - 2 String   
//    - 1 Boolean
//    - 1 Number
//    - 1 Array
//    - 1 Metodo que retorne un saludito
//     * por ejemplo:
    
//      let canHijo = {
//        nombre : 'Negrito',
//        color  : 'Negrito',
//        estaVacunado : true,
//        edad : 10,
//        vacunas : ['Leptospirosis', 'Hepatitis', 'Parvovirus'],
//        saludo: function(){
//            return 'wouf wouf wouf..'
//        } 
//      }

//   - Luego desarrollar una funcion que liste individualmente los elementos de la propiedad del tipo Array 
console.log("======================")
console.log("ejercicio A")
let canHijo = {
           nombre : 'Negrito',
           color  : 'Negrito',
           estaVacunado : true,
           edad : 10,
           vacunas : ['Leptospirosis', 'Hepatitis', 'Parvovirus'],
           saludo: function(){
               return 'wouf wouf wouf..'
           } 
         }
const nombrarPropiedad = parametro =>{
    let claves = Object.keys(parametro)
    let valor = Object.values(parametro)
    let numeroClaves = claves.length
    for (let i = 0; i < numeroClaves; i++){
        console.log(valor[i])
    }
}
nombrarPropiedad(canHijo)

// 2 - Dado el Siguiente array de personas desarrollar funciones:
console.log("======================")
console.log("ejercicio B")
const personas = [
    {
      "id": 0,
      "isProgrammer": true,
      "age": 28,
      "name": "Harrington Curry",
      "company": "TRANSLINK",
      "favoriteFruit": "strawberry"
    },
    {
      "id": 1,
      "isProgrammer": false,
      "age": 38,
      "name": "Greta Morton",
      "company": "PYRAMI",
      "favoriteFruit": "apple"
    },
    {
      "id": 2,
      "isProgrammer": false,
      "age": 32,
      "name": "Hester Bowen",
      "company": "TURNABOUT",
      "favoriteFruit": "apple"
    },
    {
      "id": 3,
      "isProgrammer": false,
      "age": 25,
      "name": "Melendez Mcfarland",
      "company": "XSPORTS",
      "favoriteFruit": "strawberry"
    },
    {
      "id": 4,
      "isProgrammer": false,
      "age": 31,
      "name": "Kimberly Matthews",
      "company": "KNOWLYSIS",
      "favoriteFruit": "banana"
    },
    {
      "id": 5,
      "isProgrammer": false,
      "age": 36,
      "name": "Hardin Sims",
      "company": "SEALOUD",
      "favoriteFruit": "banana"
    },
    {
      "id": 6,
      "isProgrammer": false,
      "age": 29,
      "name": "Natalia Huff",
      "company": "ENERSOL",
      "favoriteFruit": "apple"
    }
  ]
//   - Funcion que reciba el array de personas y liste el nombre de cada una. 
console.log("======================")
console.log("punto A")
const listar = array =>{
    let lista = []
    for (let i = 0; i < array.length; i++) {
        lista.push(array[i].name)
        
    }
    return lista
}
let lista = listar(personas)
console.log(lista)

//   - Funcion que reciba el array de personas y retorne en un array los que son programadores.
console.log("======================")
console.log("punto B")
const listarB = array =>{
    let lista = []
    for (let i = 0; i < array.length; i++) {
        if (array[i].isProgrammer === true){
            lista.push(array[i].name)
        }
    }
    return lista
}
let listaB = listarB(personas)
console.log(listaB)

//   - Funcion que reciba el array de personas y un id a buscar, 
//        retorne la persona en caso de encontrar, 
//        caso contrario retorne null
console.log("======================")
console.log("punto C")
const encontrarB = (array, id) =>{
    for (let i = 0; i < array.length; i++) {
        if (array[i].id === id){
            return array[i].name
        }
    }
    return null
}
let encontradoB = encontrarB(personas, 6)
console.log(encontradoB)

//   - Funcion que reciba el array de personas y un id a buscar, 
//        retorne la persona en caso de encontrar, 
//        caso contrario retorne null 




// Tips

// * Es para que practiquen sintaxis ademas del pensamiento computacional, piensen tipo de datos posibles.
// * Desarrollen y lean enunciados en voz alta, utilicen abstracción, vean las alternativas de llegar al mismo resultado de diferentes formas


// nota : Se recomienda utilizar estructuras y conceptos vistos en la materia
// ```