const fs = require("fs")
document.body.innerHTML = fs.readFileSync("./calculadora.html")
//const rewire = require("rewire")
const { init , limpiar, resetear, resolver} = require("../funcionalidad.js")

describe('Función init()', () => {
    test('Ingresar número', () => {
        init()
        uno.onclick()
        expect(resultado.textContent).toBe("1")       
    })
})
describe('Función limpiar()', () => {
    test('limpiar', () => {
        init()
        uno.onclick()
        limpiar()
        expect(resultado.textContent).toBe("")
    })
})
describe('Función resetear()', () => {
    test('resetear resultado', () => {
        init()
        uno.onclick()
        suma.onclick()
        uno.onclick()
        resetear()
        expect(resultado.textContent).toBe("")
    })
})
describe('Función resolver()', () => {
    test('resolver suma', () => {
        init()
        uno.onclick()
        suma.onclick()
        uno.onclick()
        igual.onclick()
        expect(resultado.textContent).toBe("2")
    })
    test('resolver suma operandos 0', () => {
        init()
        uno.onclick()
        suma.onclick()
        uno.onclick()
        igual.onclick()
        resolver()
        expect(resultado.textContent).toBe("0")
    })
    test('resolver resta', () => {
        init()
        dos.onclick()
        resta.onclick()
        uno.onclick()
        igual.onclick()
        expect(resultado.textContent).toBe("1")
    })
})