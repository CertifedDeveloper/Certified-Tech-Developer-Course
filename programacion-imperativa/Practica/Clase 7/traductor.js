const traductor = palabra => {
    switch(palabra){
        case "casa":
            return "house"
        case "perro":
            return "dog"
        case "pelota":
            return "ball"
        case "árbol":
            return "tree"
        case "genio":
            return "genius"
        default:
            return "La palabra ingresada no es correcta"
    }
}
let traduccion = traductor("casa")
console.log(traduccion)