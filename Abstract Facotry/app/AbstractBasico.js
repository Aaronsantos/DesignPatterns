
class AbstractBasico {

    constructor() {

        if(this.constructor === AbstractBasico) {
            throw new TypeError('Abstract class "AbstractBasico" cannot be instaciated')
        }
    }


}

exports = AbstractBasico