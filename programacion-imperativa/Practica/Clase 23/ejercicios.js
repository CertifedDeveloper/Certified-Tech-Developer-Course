// Lugar y números

let list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11];

const binary = (array, item) => {
    let low = 0
    let high = array.length - 1
    let mid
    let guess
    while (low <= high){
        mid = Math.floor((low + high) / 2)
        guess = array[mid]
        if (guess === item){
            return mid
        }
        if (guess > item){
            high = mid - 1
        } else{
            low = mid + 1
        }
    }
    return null
}

let numeroEncontrado = binary(list, 1)
console.log(numeroEncontrado)

// Desafío extra: orden, lugar y números
console.log("==================================")
console.log("Extra")
let listB = [12,3,5,7,1,22,47,100];

const encontrar = (array, item) => {
    let arrayObjetos = []
    
    for (let i = 0; i < array.length; i++) {
        let objeto = {}
        objeto.numero = array[i]
        objeto.indice = i
        arrayObjetos.push(objeto) 
    }
    bubbleB(arrayObjetos, "numero")
    let indice = binaryB(arrayObjetos, item, "numero")
    return indice
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

const binaryB = (arrayObjetos, item, numero) => {
    let low = 0
    let high = arrayObjetos.length - 1
    let mid
    let guess
    while (low <= high){
        mid = Math.floor((low + high) / 2)
        guess = arrayObjetos[mid][numero]
        if (guess === item){
            return arrayObjetos[mid]["indice"]
        }
        if (guess > item){
            high = mid - 1
        } else{
            low = mid + 1
        }
    }
    return null
}

let indiceEncontrado = encontrar(listB, 12)
console.log(indiceEncontrado)