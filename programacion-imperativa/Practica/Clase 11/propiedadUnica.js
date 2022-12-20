const propiedadUnica = (arreglo, texto) => {
    let propiedad = []
    for (let i = 0; i < arreglo.length; i++){
        for (let j = 0; j < Object.keys(arreglo[i]).length; j++){
            let pr = Object.keys(arreglo[i])
            let entradas = Object.entries(arreglo[i])
            if ((entradas[j][0]) === texto){
                let objeto = {}
                objeto[entradas[j][0]] = entradas[j][1]
                propiedad.push(objeto)
            }
        }
    }
    console.log(propiedad)
}

let array = [ { nombre: "Lean", edad: 27 }, { nombre: "Eze", edad: 49} ]
propiedadUnica(array, "edad") //debe retornar [ { edad: 27 }, { edad: 49 } ]
propiedadUnica(array, "nombre") //debe retornar [ { nombre: “Lean”}, { nombre: “Eze”} ]