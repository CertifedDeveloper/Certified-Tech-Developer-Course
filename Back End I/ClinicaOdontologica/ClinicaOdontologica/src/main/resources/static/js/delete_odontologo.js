window.addEventListener('load', function(){
    let botones = document.querySelectorAll('#odontologoTable tbody button')
    console.log(botones)
    botones.forEach(boton =>{
        boton.addEventListener('click', function(event){
            console.log(event)
            const id = event.target.innerText
            console.log(id)
            let confirmacion = confirm("¿Desea eliminar el odontólogo con id: "+ id + "?")
            if (confirmacion){
                const url =`/odontologos/${id}`
                const settings = {
                    method: 'DELETE',
                    headers:{
                        "Content-type": "application/json"
                    }
                }
                fetch(url, settings)
                .then(response => {
                    console.log(response.status)
                })
                .catch(function(e){
                    alert("ERROR: ", e)
                    console.log("ERROR: ", e)
                })
            }
        })
    })
})