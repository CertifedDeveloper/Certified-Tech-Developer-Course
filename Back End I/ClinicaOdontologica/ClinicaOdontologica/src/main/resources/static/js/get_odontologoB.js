window.addEventListener('load', function(){
    fetch("/odontologos")
    .then(function(response){
        return response.json()
    })
    .then(function(data){
        console.log(data)
        
        let tablaOdontologo = document.querySelector('#odontologoTable tbody')
        tablaOdontologo.innerHTML = ""
        data.forEach(odontologo => {
            let get_More_Info_Btn = `<button
                                    id="btn_id_${odontologo.id}"
                                    type="button" class="btn btn-info btn_id"> 
                                    ${odontologo.id}
                                    </button>` 
                
            let tr_id = `tr${odontologo.id}`
            let odontologoRow = `<tr id="${tr_id}">
                      <td> ${get_More_Info_Btn} </td>
                      <td class="td_first_name"> ${odontologo.nombre.toUpperCase()} </td>
                      <td class="td_last_name"> ${odontologo.apellido} </td>
                      <td class="td_matricula"> ${odontologo.numeroMatricula}</td>
                      </tr>`          
                
            tablaOdontologo.innerHTML += odontologoRow
        })
    })
    .catch(function(e){
        alert("ERROR: ", e)
        console.log("ERROR: ", e)
    }
    )
    
    let pathname = window.location.pathname
    if (pathname == "/odontologos.html") {
        let nav = document.querySelector(".nav .nav-item a:last-of-type")
        nav.classList.add("active")
    }
})