#encoding:UTF-8
import random

while True: 
    aleatorio = random.randrange(0, 5)
    eligePc = ""
    print("1)Piedra")
    print("2)Papel")
    print("3)Tijera")
    print("4)Lagarto")
    print("5)Spock")
    print("6)Salir del Programa")
    opcion = int(input("Que eliges: "))
    
    if opcion == 1:
        eligeUsuario = "piedra"
    elif opcion == 2:
        eligeUsuario = "papel"
    elif opcion == 3:
        eligeUsuario = "tijera"
    elif opcion == 4:
        eligeUsuario = "lagarto"
    elif opcion == 5:
        eligeUsuario = "spock"
    elif opcion == 6:
        print ("Nos vemos!")
        break
    else:
        print ("Valor Invalido")
        continue
        
    print("Tu eliges: ", eligeUsuario)   
    if aleatorio == 0:
        eligePc = "piedra"
    elif aleatorio == 1:
        eligePc = "papel"
    elif aleatorio == 2:
        eligePc = "tijera"
    elif aleatorio == 3:
        eligePc = "lagarto"
    elif aleatorio == "4":
        eligePc = "spock"
    print("PC eligio: ", eligePc)
    print("...")
    
    if eligePc == "piedra" and eligeUsuario == "papel":
        print("Ganaste, papel envuelve piedra")
    elif eligePc == "papel" and eligeUsuario == "tijera":
        print("Ganaste, tijera corta papel")
    elif eligePc == "tijera" and eligeUsuario == "piedra":
        print("Ganaste, piedra pisa tijera")
    elif eligePc == "lagarto" and eligeUsuario == "piedra":
        print("Ganaste, piedra aplasta lagarto")
    elif eligePc == "spock" and eligeUsuario == "lagarto":
        print("Ganaste, lagarto envenena Spock")
    elif eligePc == "tijera" and eligeUsuario == "spock":
        print("Ganaste, Spock rompe tijera")
    elif eligePc == "spock" and eligeUsuario == "papel":
        print("Ganaste, papel desautoriza Spock")
    elif eligePc == "lagarto" and eligeUsuario == "tijera":
        print("Ganaste, tijera decapita lagarto")
    elif eligePc == "piedra" and eligeUsuario == "spock":
        print("Ganaste, Spock vaporiza piedra")
    elif eligePc == "papel" and eligeUsuario == "lagarto":
        print("Ganaste, lagarto devora papel")
        
    if eligeUsuario == "piedra" and eligePc == "papel":
        print("Perdiste, papel envuelve piedra")
    elif eligeUsuario == "papel" and eligePc == "tijera":
        print("Perdiste, tijera corta papel")
    elif eligeUsuario == "tijera" and eligePc == "piedra":
        print("Perdiste, piedra pisa tijera")
    elif eligeUsuario == "lagarto" and eligePc == "piedra":
        print("Perdiste, piedra aplasta lagarto")
    elif eligeUsuario == "spock" and eligePc == "lagarto":
        print("Perdiste, lagarto envenena Spock")
    elif eligeUsuario == "tijera" and eligePc == "spock":
        print("Perdiste, Spock rompe tijera")
    elif eligeUsuario == "spock" and eligePc == "papel":
        print("Perdiste, papel desautoriza Spock")
    elif eligeUsuario == "lagarto" and eligePc == "tijera":
        print("Perdiste, tijera decapita lagarto")
    elif eligeUsuario == "piedra" and eligeUsuario == "spock":
        print("Perdiste, Spock vaporiza piedra")
    elif eligeUsuario == "papel" and eligePc == "lagarto":
        print("Perdiste, lagarto devora papel")
    elif eligePc == eligeUsuario:
        print("Empate")
    again = input("Jugamos de nuevo? Si/No: ")
    if 'si' in again:
        continue
    elif 'no' in again:
        print("Nos vemos!")
        break
    else:
        print("Valor Invalido")