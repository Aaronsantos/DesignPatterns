const Carta = require('./Carta.js')

module.exports = class Baralho{

    constructor(){
        
        this._cartas = []
        for( let naipeCont = 1; naipeCont < 5; naipeCont++ ) {
            
            for(let cartaNum = 1; cartaNum < 15; cartaNum++ )

                this._cartas.push(new Carta(naipeCont, cartaNum ))
            
        }

    }

    embaralhar() {

        for(let indice = this._cartas.length; indice; indice--) {

            let indiceAleatorio = Math.floor(Math.random() * indice) 
            
            let cartaAtual = this._cartas[indice-1]
            this._cartas[indice-1] = this._cartas[indiceAleatorio]
            this._cartas[indiceAleatorio] = cartaAtual 
        }
    }

    retirarCartaTopo() {
        return this._cartas.pop()
    }

    retirarCartaFim() {
        return this._cartas.splice(0,1)[0]
    }

    retirarCartaAleatoria() {
        return this._cartas.splice( (Math.floor(Math.random() * this._cartas.length)),1)[0]
    }
}
