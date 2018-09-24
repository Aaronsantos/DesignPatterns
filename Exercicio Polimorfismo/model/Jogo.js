
module.exports = class Jogo {

    constructor() {
        if(this.constructor === Jogo) {
            throw new TypeError('Abstract Class "Jogo" cannot be instaciated')
        }

        if(this.retirarCartas === undefined ) 
            throw new TypeError('Classes extending the "Jogo" abstract class have to implement the method "retirarCartas" ' )

        if(this.calcularPontos === undefined ) 
            throw new TypeError('Classes extending the "Jogo" abstract class have to implement the method "calcularPontos" ' )
    }
}