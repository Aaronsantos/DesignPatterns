const AbstractConforto = require('./AbstractConforto')

class PisoConforto extends AbstractConforto {

    constructor() {
        super()
        console.log("Criado um Piso conforto")
    }

}

exports = PisoConforto