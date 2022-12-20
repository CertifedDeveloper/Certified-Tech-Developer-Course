const fibonacci = (parametro) => {
    if (parametro === 0){
        console.log(0)
    }else{
        let valor = 0
        let tempA = 0
        let tempB = 1
        console.log(0)
        console.log(1)
        while((tempA + tempB) <= parametro){
            valor = tempA + tempB
            tempA = tempB
            tempB = valor
            console.log(valor)
        }
    }
}
fibonacci(10)