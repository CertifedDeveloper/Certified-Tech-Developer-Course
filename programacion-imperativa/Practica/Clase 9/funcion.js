const elemento = parametro => {
    if (parametro.length >= 3){
        return parametro[2]
    }else{
        return -1
    }
}
array = ["1", "2", "3"]
console.log(elemento(array))