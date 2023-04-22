/* --------------------------- NO TOCAR DESDE ACÁ --------------------------- */
let datosPersona = {
  nombre: "",
  edad: 0,
  ciudad: "",
  interesPorJs: "",
};

const listado = [{
    imgUrl: "https://huguidugui.files.wordpress.com/2015/03/html1.png",
    lenguajes: "HTML y CSS",
    bimestre: "1er bimestre",
  },
  {
    imgUrl: "https://jherax.files.wordpress.com/2018/08/javascript_logo.png",
    lenguajes: "Javascript",
    bimestre: "2do bimestre",
  },
  {
    imgUrl: "https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/React.svg/1200px-React.svg.png",
    lenguajes: "React JS",
    bimestre: "3er bimestre",
  },
];

const profileBtn = document.querySelector("#completar-perfil");
const materiasBtn = document.querySelector("#obtener-materias");
const verMasBtn = document.querySelector("#ver-mas");
const cambiarTema = document.querySelector('#cambiar-tema');

profileBtn.addEventListener("click", renderizarDatosUsuario);
materiasBtn.addEventListener("click", recorrerListadoYRenderizarTarjetas);
cambiarTema.addEventListener("click", alternarColorTema);
/* --------------------------- NO TOCAR HASTA ACÁ --------------------------- */

function obtenerDatosDelUsuario() {
  /* --------------- PUNTO 1: Escribe tu codigo a partir de aqui --------------- */
 let nombre = prompt("Ingresa tu nombre")
 let anioNacimiento = parseInt(prompt("Ingresa el año en que naciste"))
 let ciudad = prompt("Ingresa la ciudad donde vives")
 let js = confirm("Te interesa Javascript")
datosPersona.nombre = nombre
datosPersona.edad = 2023 - anioNacimiento
datosPersona.ciudad = ciudad
datosPersona.interesPorJs = js ? "SI" : "NO"

}

function renderizarDatosUsuario() {
  /* ------------------- NO TOCAR NI ELIMINAR ESTA FUNCION. ------------------- */
  obtenerDatosDelUsuario();
  /* --------------- PUNTO 2: Escribe tu codigo a partir de aqui --------------- */
  let nombre = document.getElementById("nombre")
  let edad = document.getElementById("edad")
  let ciudad = document.getElementById("ciudad")
  let javascript = document.getElementById("javascript")

  nombre.innerText = datosPersona.nombre
  edad.innerText = datosPersona.edad
  ciudad.innerText = datosPersona.ciudad
  javascript.innerText = datosPersona.interesPorJs

}


function recorrerListadoYRenderizarTarjetas() {
  /* ------------------ PUNTO 3: Escribe tu codigo desde aqui ------------------ */
  let materias = document.getElementById("fila")
  if (!materias.innerHTML.includes("caja")){
    listado.forEach((elemento) => {
      let template = `<div class="caja">
      <img src="${elemento.imgUrl}" alt="${elemento.lenguajes}"></img>
      <p class="lenguajes">${elemento.lenguajes}</p>
      <p class="bimestre">${elemento.bimestre}</p>
      </div>`
      materias.innerHTML += template
    })
  }
  


}

function alternarColorTema() {
  /* --------------------- PUNTO 4: Escribe tu codigo aqui --------------------- */
 let sitio = document.getElementById("sitio")
 sitio.classList.toggle("dark")
  


}

/* --------------------- PUNTO 5: Escribe tu codigo aqui --------------------- */
window.addEventListener("keydown", (evento) => {
  if (evento.key.toLowerCase() === "f"){
    let sobreMi = document.getElementById("sobre-mi")
    sobreMi.classList.remove("oculto")
  }
})
