
class AbstractConforto {

    constructor() {

        if(this.constructor === AbstractConforto) {
            throw new TypeError('Abstract class "AbstractBasico" cannot be instaciated')
        }
    }


}

exports = AbstractConforto