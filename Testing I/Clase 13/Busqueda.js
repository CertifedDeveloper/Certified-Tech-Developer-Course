let objetoJSON = require('./response_ability.json')
function busquedaA(pokemon) {
    for (let i = 0; i < objetoJSON.results.length; i++){
        if (pokemon === objetoJSON.results[i].name){
            return `Se encontró el pokemon\nLa url es: ${objetoJSON.results[i].url}`
        }
    }
    return "No se encontró el pokemon"
}
let resultadoA = busquedaA("drizzle")
//console.log(resultadoA)

const busquedaB = pokemon => {
    const miFuncion = valor => {
        return valor.name === pokemon 
    }
    let pokemonEncontrado = objetoJSON.results.find(miFuncion)
    return `Se encontró el pokemon\nLa url es: ${pokemonEncontrado.url}`
}

let resultadoB = busquedaB("drizzle")
//console.log(resultadoB)