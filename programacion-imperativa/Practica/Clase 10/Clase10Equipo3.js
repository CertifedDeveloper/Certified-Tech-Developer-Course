/*

EQUIPO 3

 - GRAS PALOMA
 - JUAN TADINI
 - MATIAS RAUL NOGUERA
 - GRETEL BRUNIG
 - ARTURO HERNANDEZ
 
 */

let numbers =[22, 33, 54, 66, 72]
console.log(numbers[numbers.length])


let str = 'un string cualquiera'
let arrayAleatorio= ["Digital", "House", 'true', "string", "123","false", '54', str ]
console.log(arrayAleatorio[arrayAleatorio.length - 1])

let arrayPeliculas = ["star wars", "totoro", "rocky", "pulp fiction", "la vida es bella"];
let arrayEnMayuscula = [];
let arrayPeliculas2 = ["toy story", "finding Nemo", "kung-fu panda", "wally", "fortnite"];

const convertirMayus = (argumento) => {

    for(let i = 0; i < argumento.length; i++){
        movieMayus = argumento[i].toUpperCase();
        arrayEnMayuscula.push(movieMayus);
    }
    return arrayEnMayuscula;
}

const pelisEnMayus = convertirMayus(arrayPeliculas);
console.log(pelisEnMayus);

const unirArrays = (array1, array2) => {
    for( let i = 0; i < array2.length; i++){
        movieMayus = array2[i].toUpperCase();
        array1.push(movieMayus);
    }
    return array1;
}

const arraysUnidos = unirArrays(pelisEnMayus, arrayPeliculas2);
console.log(arraysUnidos);

const eliminandoElemento = arraysUnidos.pop();
console.log(eliminandoElemento)
console.log(arraysUnidos)

const asiaScores = [8, 10, 6, 9, 10, 6, 6, 8, 4];
const euroScores = [8, 10, 6, 8, 10, 6, 7, 9, 5];

const compararArrays = (a, b) => {

    for(i = 0; i < a.length; i++){
        if(a[i] === b[i]){
            console.log('coinciden')
        }else{
            console.log('no coincide')
        }
    }
}

compararArrays(asiaScores, euroScores);


