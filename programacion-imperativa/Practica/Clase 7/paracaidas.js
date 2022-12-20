const abrirParacaidas = (velocidad, altura) => abrir = velocidad < 1000 && altura >= 2000 && altura < 3000 ? "Se abre el paracaídas" : "No se abre el paracaídas"
let caso = abrirParacaidas(500, 2500)
console.log(caso)