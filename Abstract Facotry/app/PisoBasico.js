const AbstractBasico = require('./AbstractBasico')

class PisoBasico extends AbstractBasico {

    constructor() {
        super()
        console.log("Criado um Piso Basico")
    }

}

exports = PisoBasico