const digitalHouse = (a,b) => {
    for (let i = 1; i <= 100; i++){
        if (Math.round(i / a) === (i / a) && Math.round(i / b) === (i / b)){
            console.log("Digital House")
        } else if (Math.round(i / a) === (i / a)){
            console.log("Digital")
        } else if (Math.round(i / b) === (i / b)){
            console.log("House")
        } else{
            console.log(i)
        }
    }
}
digitalHouse(2,3)