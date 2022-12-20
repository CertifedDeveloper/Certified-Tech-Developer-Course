const factorial = (numero) => {
    let factor = 1
    for (i = 1; i <= numero; i++){
        factor *= i
    }
    return factor
}
let factor = factorial(3)
console.log(factor)