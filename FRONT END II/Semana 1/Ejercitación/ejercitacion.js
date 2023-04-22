/*Tragamonedas*/
const premioTotal = 2500;
const casilla = 10;
function calcular(aciertos){
    return Math.round(premioTotal * (aciertos / casilla))
}

/*let calculo = calcular(5)
console.log(calculo)*/

/*Loteria*/
function resultadoLoteria(lugar){
    console.log(lugar)
    numeroAletorio = Math.round(Math.random() * 3)
    console.log(numeroAletorio)
    let resultado = 0
    if (numeroAletorio === 0){
        resultado = 1000
    } else if (numeroAletorio === 1){
        resultado = 10000
    } else if (numeroAletorio === 2){
        resultado = 10000
    } else if (numeroAletorio === 3){
        resultado = 100000
    }
    console.log("Usted a ganado " + resultado + " pesos")
}
/*resultadoLoteria("lugar")*/

/*Ruleta*/
const finalRuleta = 25;
function tirarRuleta(){
    numeroAletorio = Math.round(Math.random() * finalRuleta)
    for (let i = 0; i <= finalRuleta; i++){
        if (i === numeroAletorio){
            console.log(`Número ganador: ${i}`)
        } else{
            console.log(i)
        }
    }
}
/*tirarRuleta()*/