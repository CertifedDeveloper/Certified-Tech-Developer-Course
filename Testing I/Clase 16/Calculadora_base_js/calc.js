function suma(a,b){
    if (a === null || b === null){
        return 0
    } else if (a === undefined || b === undefined){
        return 0
    } else if (isNaN(parseInt(a)) || isNaN(parseInt(b))){
        return 0
    } else if(parseInt(a) != a || parseInt(b) != b){
        return 0
    } 
    else {
        return a+b;
    }
}

function resta(a,b){
    if (a === null || b === null){
        return 0
    } else if (a === undefined || b === undefined){
        return 0
    } else if (isNaN(parseInt(a)) || isNaN(parseInt(b))){
        return 0
    } else if(parseInt(a) != a || parseInt(b) != b){
        return 0
    } else {
        return a-b;
    }
}

function multiplicacion(a,b){
    if (a === null || b === null){
        return 0
    } else if (a === undefined || b === undefined){
        return 0
    } else if (isNaN(parseInt(a)) || isNaN(parseInt(b))){
        return 0
    } else if(parseInt(a) != a || parseInt(b) != b){
        return 0
    } else{
        return a*b;
    }
}

function division(a,b){
    if (a === null || b === null){
        return 0
    } else if (a === undefined || b === undefined){
        return 0
    } else if (isNaN(parseInt(a)) || isNaN(parseInt(b))){
        return 0
    } else if(parseInt(a) != a || parseInt(b) != b){
        return 0
    } else{
        return a/b;
    }
}

module.exports = {suma, resta, multiplicacion, division};
