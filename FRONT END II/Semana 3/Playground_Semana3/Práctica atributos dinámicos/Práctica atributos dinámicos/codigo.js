//1- Agregar a la tarjeta, el atributo "class" con el valor "card"
let card = document.querySelector("#tarjeta")
card.classList.add("card")

//2- Agregar a la imagen, el atributo "src" con el valor "https://www.youtube.com/img/desktop/yt_1200.png"
let imagen = document.querySelector("img")
imagen.setAttribute("src", "https://www.youtube.com/img/desktop/yt_1200.png")

//3- Quitarle al titulo la clase que le está dando un formato feo
let titulo = document.querySelector("h1")
titulo.removeAttribute("class","titulo-feo")

//4- Chequear si el link a youtube posee o no el atributo href
let link = document.querySelector("li #link_youtube")
console.log(link.hasAttribute("href"))

//5- Obtener el href del link a wikipedia y mostrarlo por consola
let link_wiki = document.querySelector("li #link_wikipedia")
console.log(link_wiki.getAttribute("href"))
