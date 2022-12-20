const alicia = [10, 80, 75]
const bob = [90, 20, 25]
let Concurso = {
    etapas: [],
    ganador: "",
    encontrarGanador: function(a,b){
        let puntosPrimerParticipante = 0
        let puntosSegundoParticipante = 0
        let array = ["ganador_primera_etapa", "ganador_segunda_etapa", "ganador_tercera_etapa"]
        for (let i = 0; i < 3; i++){
            objeto = {}
            if (a[i] > b[i]){
                puntosPrimerParticipante += 1
                objeto[array[i]] = "Primer Participante"
                this.etapas.push(objeto)    
            } else if (a[i] < b[i]){
                puntosSegundoParticipante += 1
                objeto[array[i]] = "Segundo Participante"
                this.etapas.push(objeto)
            }

        }
        if (puntosPrimerParticipante > puntosSegundoParticipante){
            this.ganador = "Primer"
        } else if (puntosSegundoParticipante > puntosPrimerParticipante){
            this.ganador = "Segundo"
        }
    },
    exportarResultados: function(){
        return JSON.stringify(this.etapas)
    }
}
Concurso.encontrarGanador(alicia, bob)
console.log("Etapas: ", Concurso.etapas)
console.log(`El ganador es: ${Concurso.ganador} participante`)
console.log(Concurso.exportarResultados())