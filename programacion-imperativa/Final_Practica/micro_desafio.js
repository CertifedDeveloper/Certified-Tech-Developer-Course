// ● Desarrollar una matriz de Strings 
// llamada mice que represente la imagen.
let mice = [
    ["lucas", "camila", "pedro"],
    ["juan", "luisa", null]
]
// ● Mostrar a luisa.
console.log(mice[1][1])
// ● Cambiar él valor null por Jerry
mice[1][2] = "jerry"
console.log(mice)
// ● Crear una función que reciba por 
// parámetro la matriz creada e imprimir por 
// consola
// él saludo de cada elemento:
// ○ Hola soy lucas
// ○ Hola soy camila
// ○ ….
const saludo = mat => {
    for (let i = 0; i < mat.length; i++) {
        for (let j = 0; j < mat[i].length; j++) {
            console.log(`Hola soy ${mat[i][j]}`)
        }
        
    }
}
saludo(mice)