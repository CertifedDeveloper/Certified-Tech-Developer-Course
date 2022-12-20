const edades = [11, 12, 15, 18, 25, 22, 10, 33, 18, 5];

console.log("PARTE I")
// a.	Obtener en un nuevo array las edades menores a 18.
console.log("=============================")
console.log("ejercicio A")
const edadAgrupar = array => {
    let nuevoArray = []
    for (let i = 0; i < array.length; i++){
        if (array[i] < 18){
            nuevoArray.push(array[i])
        }
    }
    return nuevoArray
}
let edadesGrupoA = edadAgrupar(edades)
console.log(edadesGrupoA)

// b.	Obtener en un nuevo array las edades mayor o igual a 18.
console.log("=============================")
console.log("ejercicio B")
const edadAgruparB = array => {
    let nuevoArray = []
    for (let i = 0; i < array.length; i++){
        if (array[i] >= 18){
            nuevoArray.push(array[i])
        }
    }
    return nuevoArray
}
let edadesGrupoB = edadAgruparB(edades)
console.log(edadesGrupoB)

// c.	Obtener en un nuevo array las edades igual a 18.
console.log("=============================")
console.log("ejercicio C")
const edadAgruparC = array => {
    let nuevoArray = []
    for (let i = 0; i < array.length; i++){
        if (array[i] === 18){
            nuevoArray.push(array[i])
        }
    }
    return nuevoArray
}
let edadesGrupoC = edadAgruparC(edades)
console.log(edadesGrupoC)

// d.	Obtener el menor.
console.log("=============================")
console.log("ejercicio D")
const menor = array => {
    let menorValor = array[0]
    for (let i = 0; i < array.length; i++){
        if (array[i] < menorValor){
            menorValor = array[i]
        }
    }
    return menorValor
}
let edadMenor = menor(edades)
console.log(edadMenor)

// e.	Obtener el mayor.
console.log("=============================")
console.log("ejercicio E") 
const mayor = array => {
    let mayorValor = array[0]
    for (let i = 0; i < array.length; i++){
        if (array[i] > mayorValor){
            mayorValor = array[i]
        }
    }
    return mayorValor
}
let edadMayor = mayor(edades)
console.log(edadMayor)

// f.	Obtener el promedio de edades.
console.log("=============================")
console.log("ejercicio F")
const promedio = array => {
    let suma = 0
    for (let i = 0; i < array.length; i++){
        suma += array[i]
    }
    return suma / array.length
}
let promedioEdades = promedio(edades)
console.log(promedioEdades)

// g.	Incrementar en 1 todas las edades.
console.log("=============================")
console.log("ejercicio G")
const incremento = array => {
    let nuevoArray = []
    for (let i = 0; i < array.length; i++){
        nuevoArray.push(array[i] + 1)
    }
    return nuevoArray
}
let incrementoEdades = incremento(edades)
console.log(incrementoEdades)

const arrayCuentas =
[
    {
      titular: "Arlene Barr",
      estaHabilitada: false,
      saldo: "$3,253.40",
      edadTitular: 33,
      tipoCuenta: "sueldo"
    },
    {
      titular: "Roslyn Torres",
      estaHabilitada: false,
      saldo: "$3,229.45",
      edadTitular: 27,
      tipoCuenta: "sueldo"
    },
    {
      titular: "Cleo Lopez",
      estaHabilitada: true,
      saldo: "$1,360.19",
      edadTitular: 34,
      tipoCuenta: "corriente"
    },
    {
      titular: "Daniel Malone",
      estaHabilitada: false,
      saldo: "$3,627.12",
      edadTitular: 30,
      tipoCuenta: "sueldo"
    },
    {
      titular: "Ethel Leon",
      estaHabilitada: true,
      saldo: "$1,616.52",
      edadTitular: 34,
      tipoCuenta: "sueldo"
    },
    {
      titular: "Harding Mitchell",
      estaHabilitada: true,
      saldo: "$1,408.68",
      edadTitular: 25,
      tipoCuenta: "corriente"
    }
  ]

console.log("=============================")
console.log("PARTE II")
// a.	Obtener un nuevo array de cuentas cuyas edades sean menores a 30.
console.log("=============================")
console.log("ejercicio A")
const funcionA = array =>{
    let nuevoArray = []
    for (let i = 0; i < array.length; i++){
        if (array[i].edadTitular < 30){
            nuevoArray.push(array[i])
        }
    }
    return nuevoArray
}
let nuevoArrayEdadA = funcionA(arrayCuentas)
console.log(nuevoArrayEdadA)

// b.	Obtener un nuevo array de cuentas cuyas edades sean mayor o igual a 30.
console.log("=============================")
console.log("ejercicio B")
const funcionB = array =>{
    let nuevoArray = []
    for (let i = 0; i < array.length; i++){
        if (array[i].edadTitular >= 30){
            nuevoArray.push(array[i])
        }
    }
    return nuevoArray
}
let nuevoArrayEdadB = funcionB(arrayCuentas)
console.log(nuevoArrayEdadB)

// c.	Obtener un nuevo array de cuentas cuyas edades sean igual a 30.
console.log("=============================")
console.log("ejercicio C")
const funcionC = array =>{
    let nuevoArray = []
    for (let i = 0; i < array.length; i++){
        if (array[i].edadTitular === 30){
            nuevoArray.push(array[i])
        }
    }
    return nuevoArray
}
let nuevoArrayEdadC = funcionC(arrayCuentas)
console.log(nuevoArrayEdadC)

// d.	Obtener la cuenta con el titular de la misma más joven.
console.log("=============================")
console.log("ejercicio D")
const funcionD = array =>{
    let menorEdad = array[0]
    for (let i = 0; i < array.length; i++){
        if (array[i].edadTitular < menorEdad.edadTitular){
            menorEdad = array[i] 
        }
    }
    return menorEdad
}
let menorEdad = funcionD(arrayCuentas)
console.log(menorEdad)

// e.	Obtener un nuevo array por cada tipo de cuenta.
console.log("=============================")
console.log("ejercicio E")
const funcionE = array =>{
    let cuentaSueldo = []
    let cuentaCorriente = []
    for (let i = 0; i < array.length; i++){
        if (array[i].tipoCuenta === "sueldo"){
            cuentaSueldo.push(array[i])
        } else if (array[i].tipoCuenta === "corriente"){
            cuentaCorriente.push(array[i])
        }
    }
    return {cuentasSueldos : cuentaSueldo, cuentasCorrientes: cuentaCorriente}
}
let nuevosArrays = funcionE(arrayCuentas)
console.log(nuevosArrays)

// f.	Obtener un nuevo array con las cuentas habilitadas.
console.log("=============================")
console.log("ejercicio F")
const funcionF = array =>{
    let cuentasHabilitadas = []
    for (let i = 0; i < array.length; i++){
        if (array[i].estaHabilitada === true){
            cuentasHabilitadas.push(array[i])
        } 
    }
    return cuentasHabilitadas
}
let cuentasHabilitadas = funcionF(arrayCuentas)
console.log(cuentasHabilitadas)

// g.	Obtener un nuevo array con las cuentas deshabilitadas.
console.log("=============================")
console.log("ejercicio G")
const funcionG = array =>{
    let cuentasDeshabilitadas = []
    for (let i = 0; i < array.length; i++){
        if (array[i].estaHabilitada === false){
            cuentasDeshabilitadas.push(array[i])
        } 
    }
    return cuentasDeshabilitadas
}
let cuentasDeshabilitadas = funcionG(arrayCuentas)
console.log(cuentasDeshabilitadas)

// h.	Obtener la cuenta con el menor saldo.
console.log("=============================")
console.log("ejercicio H")
const funcionH = array =>{
    let menorSaldo = array[0]
    for (let i = 0; i < array.length; i++){
        if (array[i].saldo < menorSaldo.saldo){
            menorSaldo = array[i] 
        }
    }
    return menorSaldo
}
let menorSaldo = funcionH(arrayCuentas)
console.log(menorSaldo)

// i.	Obtener la cuenta con el mayor saldo.
console.log("=============================")
console.log("ejercicio I")
const funcionI = array =>{
    let mayorSaldo = array[0]
    for (let i = 0; i < array.length; i++){
        if (array[i].saldo > mayorSaldo.saldo){
            mayorSaldo = array[i] 
        }
    }
    return mayorSaldo
}
let mayorSaldo = funcionI(arrayCuentas)
console.log(mayorSaldo)

// Extras
console.log("=============================")
console.log("Extras")
console.log("=============================")

// 1. Desarrollar una función llamada generarID que reciba como parámetro el array
// de cuentas y agregue a cada elemento (objeto literal) una propiedad llamada id
// con un valor Numérico
console.log("ejercicio A")
const funcionExtraA = array =>{
    for (let i = 0; i < array.length; i++){
        array[i].id = i + 1
    }
}
funcionExtraA(arrayCuentas)
console.log(arrayCuentas)

// 2. Desarrollar una función llamada buscarPorId que reciba como parámetro el
// array de cuentas y un id, en caso de encontrar retornar la cuenta (él objeto
// literal completo), caso contrario retornar null
console.log("=============================")
console.log("ejercicio B")
const buscarPorId = (array, id) =>{
    for (let i = 0; i < array.length; i++){
        if (array[i].id === id){
            return array[i] 
        }
    }
    return null
}
let encontrado = buscarPorId(arrayCuentas, 1)
console.log(encontrado)

// 3. Desarrollar una función llamada filtrarPorSaldos que reciba como parámetro el
// array de cuentas y un saldo (Number), deberá retornar un array que se cuyas
// cuentas se encuentren por debajo del saldo enviado por parámetro
console.log("=============================")
console.log("ejercicio C")
const filtrarPorSaldos = (array, saldo) =>{
    let cuentas = []
    for (let i = 0; i < array.length; i++){
        if (array[i].saldo < saldo){
            cuentas.push(array[i])
        }
    }
    return cuentas
}
let saldoCuentas = filtrarPorSaldos(arrayCuentas, "$2000.00")
console.log(saldoCuentas)

// 4. Desarrollar una función llamada incrementarSaldo que reciba como parámetro
// el array de cuentas, un id y un saldo, deberá incrementar él saldo de la cuenta,
// en caso de encontrar, caso contrario retornar undefined
// a. Reutilizando la función buscarPorId
console.log("=============================")
console.log("ejercicio D")
const incrementarSaldo = (array, id, saldo) =>{
    let cuenta = buscarPorId(array, id)
    if (cuenta !== null){
        let temp = cuenta.saldo.slice(1)
        temp = parseFloat(temp.replace(",", ""))
        let suma = temp + saldo
        suma = `$${suma.toFixed(2)}`
        cuenta.saldo = suma
        return array
    } else{
        return undefined
    }
}
incrementarSaldo(arrayCuentas, 1, 2000)
console.log(arrayCuentas)
