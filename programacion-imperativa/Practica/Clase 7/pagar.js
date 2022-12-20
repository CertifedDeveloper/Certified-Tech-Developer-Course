const totalAPagar = (vehiculo, litrosConsumidos) => {
    let extra
    if (litrosConsumidos >= 0 && litrosConsumidos <= 25){
        extra = 50
    }
    else if (litrosConsumidos > 25){
        extra = 25
    }
    if (vehiculo === "coche"){
        return litrosConsumidos * 86 + extra
    }
    else if (vehiculo === "moto"){
        return litrosConsumidos * 70 + extra
    }
    else if (vehiculo === "autobús"){
        return litrosConsumidos * 55 + extra
    }
}
let vehiculo = "coche"
let litrosConsumidos = 25
resultado = totalAPagar(vehiculo, litrosConsumidos)
console.log(resultado)