// EJERCICIO EXTRA
// La Siguiente matriz representa un mes 
// calendario, se ncesita determinar los 
// dias trabajados en diferentes sucursales 
// de una empresa, las sucursales pueden ser 
// de tipo shopping o no, esto determina que 
// trabajan todos los dias de la semanas  


// 1 - Representar la matriz para poder 
// manipular en JS
let matriz = [
    [0, 0, 0, 0, 1, 2, 3],
    [4, 5, 6, 7, 8, 9, 10],
    [11, 12, 13, 14, 15, 16, 17],
    [18, 19, 20, 21, 22, 23, 24],
    [25, 26, 27, 28, 0, 0, 0]
]

// 2 - Desarrollar una funcion que reciba la 
// matriz y el tipo de sucursal (mes, tipoSuc)
//   - 'shopping'   => trabajan todos los dias 
//   de la semana
//   - 'NoShopping' => trabaja de lunes a 
//   viernes
// la función deberá retornar la cantidad de 
// dias trabajados, según el tipo de sucursal 
const diasSucursal = (mes, tipoSuc) => {
    tipoSuc = tipoSuc.toLowerCase()
    if(tipoSuc === "shopping"){
        let count = 0
        for (let i = 0; i < mes.length; i++) {
            for (let j = 0; j < mes[i].length; j++) {
                if (mes[i][j] !== 0){
                    count++
                }
            }
            
        }
        return count
    } else if (tipoSuc === "noshopping"){
        let count = 0
        for (let i = 0; i < mes.length; i++) {
            for (let j = 0; j < mes[i].length; j++) {
                if (j !== 0 && j !== 6 && mes[i][j] !== 0){
                    count++
                }
            }
            
        }
        return count
    }
}
let cantidadDias = diasSucursal(matriz, "shopping")
console.log(cantidadDias)