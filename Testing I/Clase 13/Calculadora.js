const suma = (a, b) => a + b
const resta = (a, b) => a - b
const multipicacion = (a, b) => a * b
const division = (a, b) => a / b

const calcular = (a, b, operacion) => {
    if (a === undefined || b === undefined || operacion === undefined){
        return "No se pueden dejar campos vacios"
    }
    if (a === null || b === null){
        return "Los números ingresados no pueden ser null"
    }
    if (parseInt(a) !== a || parseInt(b) !== b){
        return "Ingrese dos números enteros"
    }
    if (b === 0 && operacion === "division"){
        return "El divisor no puede ser cero"
    }
    if (operacion === "suma"){
        return suma(a, b)
    } else if (operacion === "resta"){
        return resta(a, b)
    } else if (operacion === "multiplicacion"){
        return multipicacion(a, b)
    } else if (operacion === "division"){
        return division(a, b)
    }
}

let operacionSuma = calcular(2, null, "suma")
//console.log(operacionSuma)
let operacionResta = calcular("a", 3, "resta")
//console.log(operacionResta)
let operacionMultiplicacion = calcular(5, 2.3, "multiplicacion")
//console.log(operacionMultiplicacion)
let operacionDivision = calcular(20, 0, "division")
//console.log(operacionDivision)
let operacionSinDatos = calcular()
//console.log(operacionSinDatos)
let nuevaSuma = calcular(1, 1, "suma")
//console.log(nuevaSuma)
let nuevaResta = calcular(2, 1, "resta")
//console.log(nuevaResta)
let nuevaMultiplicacion = calcular(2, 1, "multiplicacion")
//console.log(nuevaMultiplicacion)
let nuevaDivision = calcular(2, 1, "division")
//console.log(nuevaDivision)