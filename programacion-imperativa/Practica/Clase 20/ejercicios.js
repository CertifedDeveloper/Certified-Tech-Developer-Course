// Ejercicio 1

console.log("Ejercicio 1")
let likes = [3, 15, 4, 10, 7, 9, 2, 14, 6, 1, 5, 11, 8, 12, 0]

const bubble = array => {
    let temp
    for (let i = 0; i < array.length; i++) {
        for (let j = 0; j < array.length - 1; j++) {
            if (array[j] > array[j + 1]){
                temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
        
    }    
}

console.log(likes)
bubble(likes)
console.log(likes)


console.log("==============================")
console.log("Ejercicio 2")

// Ejercicio 2
let temperaturas = [
    {
        dia: 1,
        mes: 12,
        tempMax: 30,
        tempMin: 10
    },
    {
        dia: 2,
        mes: 3,
        tempMax: 36,
        tempMin: 20
    },
    {
        dia: 7,
        mes: 4,
        tempMax: 25,
        tempMin: 2
    }
]

console.log(temperaturas)
console.log("Parte A")
const bubbleB = array => {
    let temp
    for (let i = 0; i < array.length; i++) {
        for (let j = 0; j < array.length - 1; j++) {
            if (array[j].tempMin > array[j + 1].tempMin){
                temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
        
    }    
}

bubbleB(temperaturas)
console.log(temperaturas)


console.log("Parte B")
const bubbleC = array => {
    let temp
    for (let i = 0; i < array.length; i++) {
        for (let j = 0; j < array.length - 1; j++) {
            if (array[j].tempMax < array[j + 1].tempMax){
                temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
        
    }    
}

bubbleC(temperaturas)
console.log(temperaturas)