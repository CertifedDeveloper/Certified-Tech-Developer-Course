// 👇Acá vemos que el document nos dá acceso a todo el DOM, ese arbol que contiene todos los nodos de nuestro sitio
console.log(document);

// Ahora vamos a utilizar 2 métodos propios de document que nos facilitan "pescar" elementos en el sitio:
// - querySelector()
// - querySelectorAll()

// Obtenemos el titulo principal
const titulo = document.querySelector('h1');
// Ahora vayamos a la consola y despleguemos la flecha que nos muestra todas las propiedades del nodo
console.log(titulo);

// nos traemos ahora un listado de nodos 👇
const itemsMenu = document.querySelectorAll('li');
console.log(itemsMenu);

// hacemos un selector más específico👇
const infoExtra = document.querySelector('.info .clima')
console.log(infoExtra);

/* ------------------------------- Practicando ------------------------------ */
// Seleccionamos la lista de noticias y revisamos su informacion interna.
// Aprovechamos que la NodeList es un ITERABLE, entonces podemos recorrerla.
// 🚩 No es un Array.
const articulos = document.querySelectorAll('article');

for (let i = 0; i < articulos.length; i++) {
    console.log(articulos[i]);
}

// Ahora hacemos la misma practica pero con ForEach, y accedemos a propiedades de los nodos.
articulos.forEach( articulo =>{
    const titulo = articulo.querySelector('h2').innerText;
    console.log(titulo);
    // 💡 si quisieramos,acá podemos mutar los nodos, o cambiar algunas de sus propiedades
});


/* -------------------------------------------------------------------------- */
/*                          CONSIGNA MESA DE TRABAJO                          */
/* -------------------------------------------------------------------------- */
// 1 - Escribir un selector para cada elemento del sitio.
// 2 - Plasmarlo en un diagrama de árbol como la consigna: https://docs.google.com/document/d/15nGvKkEcbrRgwqV50ISh0QYZ_TO67vmWQaLfNpUxqjs/preview

/*body*/
let body = document.querySelector("body")

/*header*/
let header = document.querySelector("header")
let h1 = document.querySelector("header h1")
let nav = document.querySelector("header nav")
let navUl = document.querySelector("header nav ul")
let navUlLi = document.querySelectorAll("header nav ul li")
let tema = document.querySelector("header .tema")
let temaButton = document.querySelector("header .tema button")
let info = document.querySelector("header .info")
let infoClima = document.querySelector("header .info .clima")
let infoDolar = document.querySelector("header .info .dolar")
/*console.log(temaButton)*/

/*main*/
let main = document.querySelector("main")
let articles = document.querySelectorAll("article")
let articuloA = articles[0]
let articuloAH2 = articuloA.querySelector("h2")
let articuloAImg = articuloA.querySelector("img")
let articuloAP = articuloA.querySelector("p")
let articuloB = articles[1]
let articuloBH2 = articuloA.querySelector("h2")
let articuloBImg = articuloA.querySelector("img")
let articuloBP = articuloA.querySelector("p")
let articuloC = articles[2]
let articuloCH2 = articuloA.querySelector("h2")
let articuloCImg = articuloA.querySelector("img")
let articuloCP = articuloA.querySelector("p")
/*console.log(articuloAP)*/

/*footer*/
let footer = document.querySelector("footer")