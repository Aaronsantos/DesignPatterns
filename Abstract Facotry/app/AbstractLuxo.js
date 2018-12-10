
class AbstractLuxo {

    constructor() {

        if(this.constructor === AbstractLuxo) {
            throw new TypeError('Abstract class "AbstractLuxo" cannot be instaciated')
        }
    }


}

exports = AbstractLuxo