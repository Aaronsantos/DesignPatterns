const Jogo = require("./Jogo.js")
const Baralho = require("./Baralho.js")
const Carta = require("./Carta.js")

module.exports = class JogoCartas extends Jogo {

    constructor(numPartidas) {

        super()

        this._partidasRestantes = numPartidas
        
        this._pontosJogador1 = 0
        this._pontosJogador2 = 0 
        
        this._baralho = new Baralho()
        this._baralho.embaralhar()        
    }
    
    retirarCartas() {
        if(this.isGameFinished() ) 
            return false
        else {
            this._partidasRestantes--
            return [this._baralho.retirarCartaTopo(), this._baralho.retirarCartaTopo()]
        }
    }
    
    calcularPontos(cartas) {
        

        let cartaJogador1, cartaJogador2
        [cartaJogador1,cartaJogador2] = cartas

        return [ ( Carta.indexFromNaipe(cartaJogador1.getNaipe()) * Carta.indexFromNum(cartaJogador1.getNumero()) ),
        (Carta.indexFromNaipe(cartaJogador2.getNaipe()) * Carta.indexFromNum(cartaJogador2.getNumero()) )]      
    }

    getPontosJogador1(){
        
        return this._pontosJogador1
    }

    getPontosJogador2() {
        
        return this._pontosJogador2
    }

    addPontosJogador1(pontos) {

        this._pontosJogador1 += pontos 
        return this.getPontosJogador1()
    }

    addPontosJogador2(pontos) {
        
        this._pontosJogador2 += pontos 
        return this.getPontosJogador2()
    }

    getVencedor() {

        if(this.getPontosJogador1() > this.getPontosJogador2())
            return "Jogador 1"
        else if (this.getPontosJogador1() < this.getPontosJogador2())
            return "Jogador 2"
        else 
            return "Empate"
    }

    getPartidasRestantes() {
        return this._partidasRestantes
    }

    isGameFinished() {
        return this._partidasRestantes < 1 
    }

}

