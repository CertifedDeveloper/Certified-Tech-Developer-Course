const sumaArray = arreglo => {
    let suma = 0
    for (let i = 0; i < arreglo.length; i++){
        suma += arreglo[i]
    }
    return suma
}

let array_numeros = [1, 2, 3, 4]
let suma = sumaArray(array_numeros)
console.log(suma)

const arrayJoin = argumento => {
    let texto = ""
    for (let i = 0; i < argumento.length; i++){
        texto = texto.concat(argumento[i])
    }
    return texto
}

let arrayTexto = ["h", "o", "l", "a", "a"]
let simulacionJoin = arrayJoin(arrayTexto)
console.log(simulacionJoin)