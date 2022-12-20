let alumno = {
    nombre: "Nombre",
    numero_legajo: 1,
    lista_notas : [1, 2, 3]
}

const promedio = (alumno, nota_aprobacion) => {
    let suma = 0
    for (let i = 0; i < alumno.lista_notas.length; i++){
        suma += alumno.lista_notas[i]
    }
    let pr = suma / alumno.lista_notas.length
    if (pr >= nota_aprobacion){
        console.log(`El alumno ${alumno.nombre} aprobó con ${pr}.`)
    }else{
        console.log(`El alumno ${alumno.nombre} desaprobó.`)
    }
}
promedio(alumno, 2)