const armadoSandwich = (base, pan, queso, tomate, lechuga, cebolla, mayonesa, mostaza) => {
    let precioSandwich = 0
    if (base === "pollo"){
        precioSandwich += 150
    } else if (base === "carne"){
        precioSandwich += 200
    } else if (base === "veggie"){
        precioSandwich += 100
    }

    if (pan === "blanco"){
        precioSandwich += 50
    } else if (pan === "negro"){
        precioSandwich += 60
    } else if (pan === "s/gluten"){
        precioSandwich += 75
    }

    precioSandwich += queso === true ? 20 : 0
    precioSandwich += tomate === true ? 15 : 0
    precioSandwich += lechuga === true ? 10 : 0
    precioSandwich += cebolla === true ? 15 : 0
    precioSandwich += mayonesa === true ? 5 : 0
    precioSandwich += mostaza === true ? 5 : 0
    return precioSandwich
}

let precioSandwich = armadoSandwich("carne", "blanco", true, false, false, false, false, false)
console.log(precioSandwich)