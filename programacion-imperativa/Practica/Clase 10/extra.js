// const imprimirInverso = argumento => {
//     for (let i = argumento.length - 1; i >= 0; i--){
//         console.log(argumento[i])
//     }
// }

// let ejemplo_Array = ["a", "b", "c", "d"]
// imprimirInverso(ejemplo_Array)

// const inversor = argumento => {
//     arrayInvertido = []
//     for (let i = argumento.length - 1; i >= 0; i--){
//         arrayInvertido.push(argumento[i])
//     }
//     return arrayInvertido
// }

// let ejemplo_Array_B = ["a", "b", "c", "d"]
// let resultado = inversor(ejemplo_Array_B)
// console.log(resultado)

// const sumaArray = arreglo => {
//     if (arreglo.length === 3){
//         let suma = 0
//         for (let i = 0; i < arreglo.length; i++){
//             suma += arreglo[i]
//         }
//         return suma
//     }
// }

// let array_numeros = [1, 2, 3]
// let suma = sumaArray(array_numeros)
// console.log(suma)

const arrayJoin = argumento => {
    if (argumento.length === 4){
        let texto = ""
        for (let i = 0; i < argumento.length; i++){
            texto = texto.concat(argumento[i])
        }
        return texto
    }
}

let arrayTexto = ["h", "o", "l", "a"]
let simulacionJoin = arrayJoin(arrayTexto)
console.log(simulacionJoin)