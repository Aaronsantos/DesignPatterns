const JogoCartas = require('./model/JogoCartas.js')

let numPartida = 1, cartas
let jogo = new JogoCartas(numPartida)

while(cartas = jogo.retirarCartas()) {
    
    let pontosJogador1, pontosJogador2, carta1, carta2 
    [carta1, carta2] = cartas 

    console.table({"Carta Jogador 1": carta1, "Carta Jogador 2" : carta2 })
    
    let pontos = jogo.calcularPontos(cartas)
    pontosJogador1 = pontos[0]
    pontosJogador2 = pontos[1]

    jogo.addPontosJogador1(pontosJogador1)
    jogo.addPontosJogador2(pontosJogador2)

    console.table(jogo)

}
console.log("FIM DE JOGO!")
console.log(jogo.getVencedor() + " É o vencedor!")