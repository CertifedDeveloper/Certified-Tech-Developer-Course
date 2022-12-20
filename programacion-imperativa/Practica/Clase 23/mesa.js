let personas = [
    {
      id: 1,
      nombre: "Ale",
      edad: 15
    },
    {
      id: 2,
      nombre: "Javi",
      edad: 83
    },
    {
      id: 3,
      nombre: "Luis",
      edad: 26
    },
    {
      id: 4,
      nombre: "Dan",
      edad: 16
    },
    {
      id: 5,
      nombre: "Tito",
      edad: 22
    },
    {
      id: 6,
      nombre: "Marina",
      edad: 76
    },
    {
      id: 7,
      nombre: "Susy",
      edad: 35
    },
    {
      id: 8,
      nombre: "John",
      edad: 25
    },
   ]
   

const buscarNombre = (array, item) => {
    let arrayObjetos = []
    bubbleB(array, "edad")
    let nombre = binaryB(array, item, "edad")
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
            return arrayObjetos[mid]["nombre"]
        }
        if (guess > item){
            high = mid - 1
        } else{
            low = mid + 1
        }
    }
    return null
}

let nombreEncontrado = buscarNombre(personas, 25)
console.log(nombreEncontrado)