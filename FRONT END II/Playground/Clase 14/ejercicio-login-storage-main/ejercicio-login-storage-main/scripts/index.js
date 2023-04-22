// Esta es la base de datos de nuestros usuarios
const baseDeDatos = {
  usuarios: [
    {
      id: 1,
      name: "Steve Jobs",
      email: "steve@jobs.com",
      password: "Steve123",
    },
    {
      id: 2,
      name: "Ervin Howell",
      email: "shanna@melissa.tv",
      password: "Ervin345",
    },
    {
      id: 3,
      name: "Clementine Bauch",
      email: "nathan@yesenia.net",
      password: "Floppy39876",
    },
    {
      id: 4,
      name: "Patricia Lebsack",
      email: "julianne.oconner@kory.org",
      password: "MysuperPassword345",
    },
  ],
};

// ACTIVIDAD

// Paso a paso:

// 1) Al momento de que la persona inicia sesión, si las validaciones que ya tenemos implementadas
// han sido exitosas, deberemos almacenar la información del usuario en el LocalStorage.

// 2) Al mensaje de bienvenida que ya teníamos implementado, deberemos agregarle el nombre de la
// persona y un botón de "Cerrar Sesión".

// 3) Una vez iniciada la sesión, la misma se deberá mantener en ese estado para el caso de que la persona
// recargue la página. Para ello, deberás validar si existe información del usuario al momento en
// que se produce la carga de la página, y en base a dicha condción decidir que elementos mostrar.

// 3) Para el caso de que la persona haga click en el botón "Cerrar Sesión", se deberá eliminar
// la información del usuario, mostrar un mensaje indicando que se ha cerrado la sesión, y recargar
// la página para mostrar nuevamente el formulario de login.

/* 
TIPS:
  - Para lograr los objetivos de este ejercicio, deberás valerte de algunos eventos y métodos que vimos en
    las clases anteriores. Te invitamos a que revises los recursos en caso de que tengas dudas, ya que allí
    encontrarás todas las respuestas que necesitas para completar la actividad.

  - Recuerda que puedes seleccionar y manipular los elementos del archivo index.html, usando los
    recursos que Javascript te ofrece para ello. Además, en el archivo styles.css tiene algunas clases y 
    estilos predefinidos para ayudarte a completar la actividad.

  - Al momento de guardar información del usuario en el navegador, recuerda que debemos almacenar solo la 
    información necesaria, y EN NINGUN CASO DEBEMOS GUARDAR LA CONTRASEÑA. Por ello, deberás seleccionar y
    separar la información que tienes que almacenar, a partir del objeto que contiene la información del 
    usuario.

   ¡Manos a la obra!
 */
   //window.addEventListener("load",() => {
    if(document.readyState === "loading"){
    const main = document.querySelector("main")
    const btnInicio = document.querySelector(".login-btn")
    const campos = document.querySelectorAll(".input-container")
    const form = document.querySelector("form")
    const loader = document.querySelector("#loader")
    const errores = document.querySelector("#error-container")
    errores.innerHTML = `<small>Alguno de los datos ingresados son incorrectos</small>`
    const templateBoton = `<button class="login-btn">Cerrar sesión</button>`
    if (localStorage.length === 0){ 
      btnInicio.addEventListener("click", () => {
        errores.classList.add("hidden")
        loader.classList.remove("hidden")
        setTimeout(() => {
          let email = campos[0].querySelector("[name=email]").value
          let password = campos[1].querySelector("[name=password]").value
          let usuarioJSON = ""
          let usuarioExistente = false
          baseDeDatos.usuarios.forEach((elemento) => {
            if (elemento.email === email && elemento.password === password){
              usuarioExistente = true
              usuarioJSON = JSON.stringify(elemento)
            }
          })
          let regexEmail = new RegExp("^\w+([.-_+]?\w+)*@\w+([.-]?\w+)*(\.\w{2,10})+$")
          if (regexEmail.test(email)){
            loader.classList.add("hidden")
            errores.classList.remove("hidden")
          } else if (password.length < 6){
            loader.classList.add("hidden")
            errores.classList.remove("hidden")
          } else if (!usuarioExistente){
            loader.classList.add("hidden")
            errores.classList.remove("hidden")
          } else {
            localStorage.setItem("user", usuarioJSON)
            console.log(localStorage)
            form.classList.add("hidden")
            main.querySelector("h1").innerHTML = `Bienvenido al sitio 😀 ${JSON.parse(localStorage.getItem("user")).name}`
            main.innerHTML += templateBoton
            let boton = document.querySelectorAll(".login-btn")[1]
            console.log(boton)
            boton.addEventListener("click", () => {
              alert("Se ha cerrado la sesión")
              localStorage.clear()
              window.location.reload()
            })
          }
      }, 3000)
    })
    } else {
      form.classList.add("hidden")
      main.querySelector("h1").innerHTML = `Bienvenido al sitio 😀 ${JSON.parse(localStorage.getItem("user")).name}`
      main.innerHTML += templateBoton
      let boton = document.querySelectorAll(".login-btn")[1]
      console.log(boton)
      boton.addEventListener("click", () => {
        alert("Se ha cerrado la sesión")
        localStorage.clear()
        window.location.reload()
      })
    }
  }
  //})