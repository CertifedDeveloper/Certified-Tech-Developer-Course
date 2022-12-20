let encuesta = [
    {
        tema:4,
        votos:4
    },
    {
        tema:5,
        votos:20
    },
    {
        tema:2,
        votos:10
    },
    {
        tema:1,
        votos:9
    },
    {
        tema:3,
        votos:1
    }
]

const encontrarLineal = (array, tema) => {
    for (let i = 0; i < array.length; i++) {
        if (array[i].tema === tema){
            return array[i].votos
        }
        
    }
}
console.log("Lineal")
let votosTema = encontrarLineal(encuesta, 2)
console.log(votosTema)


console.log("=================================")
console.log("Binario")

const encontrarBinario = (array, tema) => {
    bubbleB(array, "tema")
    let votos = binaryB(array, tema)
    return votos
}

const bubbleB = (array, tema) => {
    let temp
    for (let i = 0; i < array.length; i++) {
        for (let j = 0; j < array.length - 1; j++) {
            if (array[j][tema] > array[j + 1][tema]){
                temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
        
    }
}

const binaryB = (arrayObjetos, item) => {
    let low = 0
    let high = arrayObjetos.length - 1
    let mid
    let guess
    while (low <= high){
        mid = Math.floor((low + high) / 2)
        guess = arrayObjetos[mid].tema
        if (guess === item){
            return arrayObjetos[mid].votos
        }
        if (guess > item){
            high = mid - 1
        } else{
            low = mid + 1
        }
    }
    return null
}

let votosTemaB = encontrarBinario(encuesta, 2)
console.log(votosTemaB)