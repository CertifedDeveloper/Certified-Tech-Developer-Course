const { suma, resta, multiplicacion, division } = require("../calc")

describe('Pruebas de salida de datos', () => {
    test('Prueba suma de dos números', () => {
        const sumaDeNumeros = suma(1, 2)
        expect(sumaDeNumeros).toBe(3)
    })
    test('Prueba resta de dos números', () => {
        const restaDeNumeros = resta(2, 1)
        expect(restaDeNumeros).toBe(1)
    })
    test('Prueba multiplicacion de dos números', () => {
        const multiplicacionDeNumeros = multiplicacion(2, 3)
        expect(multiplicacionDeNumeros).toBe(6)
    })
    test('Prueba división de dos números', () => {
        const divisionDeNumeros = division(2, 2)
        expect(divisionDeNumeros).toBe(1)
    })
    describe('Prueba valores de entrada', () => {
        test('Prueba de entrada de valores null', () => {
            const entradaSuma = suma(2, null)
            expect(entradaSuma).toBe(0)
        })
        test('Prueba de entrada sin valores', () => {
            const entradaSuma = suma()
            expect(entradaSuma).toBe(0)
        })
        test('Prueba de entrada de valores no enteros', () => {
            const entradaSuma = suma(2.3, 1)
            expect(entradaSuma).toBe(0)
        })
    })
})