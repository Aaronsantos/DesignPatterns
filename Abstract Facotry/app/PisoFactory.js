const AbstractFactory = require("./AbstractFactory")
const PisoBasico = require("./PisoBasico")
const PisoConforto = require("./PisoConforto")
const PisoLuxo = require("./PisoLuxo")

class PisoFactory extends AbstractFactory {

    constructor(){
        
        super()
    }

    createBasico() {
        return (new PisoBasico())
    }

    createConforto() {
        return (new PisoConforto())
    }

    createLuxo() {
        return (new PisoLuxo())
    }
}