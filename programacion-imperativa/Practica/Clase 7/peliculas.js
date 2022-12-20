const valoracion = opinion => {
    switch(opinion){
        case "Muy mala":
            return "Calificaste la película como Muy mala.  Lo lamentamos mucho.\nGracias por la visita."
        case "Mala":
            return "Calificaste la película como Mala.  Lo lamentamos.\nGracias por la visita."
        case "Mediocre":
            return "Calificaste la película como Mediocre.\nGracias por la visita."
        case "Buena":
            return "Calificaste la película como Buena.  Nos alegramos.\nGracias por la visita."
        case "Muy buena":
            return "Calificaste la película como Muy buena.  Nos alegramos mucho.\nGracias por la visita."
        default:
            return "Ingresaste un valor inválido."
    }
}
let valor = valoracion("Buena")
console.log(valor)