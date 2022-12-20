let personas = [
    {
        nombre: "A",
        apellido: "B",
        edad: 10,
        estadoCivil: "casado"
    },
    {
        nombre: "B",
        apellido: "C",
        edad: 5,
        estadoCivil: "casado"
    },
    {
        nombre: "C",
        apellido: "A",
        edad: 9,
        estadoCivil: "soltero"
    }
]

const buscarApellido = (array, item) => {
    let arrayObjetos = []
    bubbleB(array, "apellido")
    let nombre = binaryB(array, item, "apellido")
    return nombre
}

const bubbleB = (array, numero) => {
    let temp
    for (let i = 0; i < array.length; i++) {
        for (let j = 0; j < array.length - 1; j++) {
            if (array[j][numero] > array[j + 1][numero]){
                temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
        
    }
}

const binaryB = (arrayObjetos, item, clave) => {
    let low = 0
    let high = arrayObjetos.length - 1
    let mid
    let guess
    while (low <= high){
        mid = Math.floor((low + high) / 2)
        guess = arrayObjetos[mid][clave]
        if (guess === item){
            return arrayObjetos[mid]
        }
        if (guess > item){
            high = mid - 1
        } else{
            low = mid + 1
        }
    }
    return null
}

console.log("Parte A")
let personaEncontrada = buscarApellido(personas, "B")
console.log(personaEncontrada)

console.log("==============================================")
console.log("Parte B")

const encontrarEstado = (array, estado) => {
    let arrayNuevo = []
    for (let i = 0; i < array.length; i++) {
        if (array[i].estadoCivil === estado){
            arrayNuevo.push(array[i])
        }
    }
    return arrayNuevo
}

let estadoPersonas = encontrarEstado(personas, "casado")
console.log(estadoPersonas)