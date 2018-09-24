const JogoCartas = require('./JogoCartas.js')

module.exports = class JogoCartasTopoFim extends JogoCartas {

    constructor(numPartidas) {
        super(numPartidas)
    }

    retirarCartas() {
        if(this.isGameFinished() ) 
            return false
        else {
            this._partidasRestantes--
            let cartas = [this._baralho.retirarCartaAleatoria(), this._baralho.retirarCartaAleatoria()]
            return cartas 
        }
    }
    
}