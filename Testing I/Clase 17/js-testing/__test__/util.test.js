const { generateText, validateInput, createElement } = require('../util.js');

describe('Pruebas de salida de datos', () => {
    test('Salida con datos', () =>{
        const text = generateText('Daniel',30);
        expect(text).toBe('Daniel (30 years old)');
    });
      
    test('Salida con datos vacios', () =>{
        const text = generateText('',null);
        expect(text).toBe(' (null years old)');    
    });
    
    test('Salida sin datos', () =>{
        const text = generateText();
        expect(text).toBe('undefined (undefined years old)');    
    });
})

describe('Pruebas de entrada de datos', () => {
    test('Entrada con datos', () => {
        const value = validateInput("Hello", true, false);
        expect(value).toBeTruthy();
    });
    test('Entrada con datos numéricos', () => {
        const value = validateInput("123", false, true);
        expect(value).toBeTruthy();
    });
    test('Entrada con input vacío', () => {
        const value = validateInput("  ",true,true);
        expect(value).toBeFalsy();
    });
    test('Entrada con input no numérico', () => {
        const value = validateInput("abc", true, true);
        expect(value).toBeFalsy();
    });
    test('Entrada con input null', () => {
        const value = validateInput(null, true, true);
        expect(value).toBeFalsy();
    });
});
describe('Creación de elementos', () => {
    test('Tipo de elemento', () => {
        const value = createElement('li', "hello", 'user-item');
        expect(value.nodeName).toBe('LI')
    });
    test('Texto', () => {
        const value = createElement('li', "hello", 'user-item');
        expect(value.textContent).toBe('hello')
    });
    test('Class', () => {
        const value = createElement('li', "hello", 'user-item');
        expect(value.className).toBe('user-item')
    })
});
