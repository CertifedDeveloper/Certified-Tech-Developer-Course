const listado = [{
        nombre: 'Juan',
        edad: 32
    },
    {
        nombre: 'Lucía',
        edad: 45
    },
    {
        nombre: 'Nicolas',
        edad: 22
    }
];

const nodoUl = document.querySelector('ul');

function mostrarPesonas(lista) {

    lista.forEach(item => {
    nodoUl.innerHTML += `<li><strong>${item.nombre}</stron> (${item.edad} años)</li>`        
    });
}

//mostrarPesonas(listado);

/* -------------------------------- Consigna -------------------------------- */
// Realizar el mismo proceso de renderizar en pantalla pero utilizando la función .map()
// Detalles:
// . indagar en la documentacion de MDN -> https://developer.mozilla.org/es/docs/Web/JavaScript/Reference/Global_Objects/Array/map
// . comentar la función anterior y ejecutar esta para probar el resultado 👇

function mostrarPesonasConMap(lista) {

    let template = lista.map(item => {
        return `<li><strong>${item.nombre}</stron> (${item.edad} años)</li>`
    }).join('');
    nodoUl.innerHTML = template
}

mostrarPesonasConMap(listado)