
class AbstractFactory {


    constructor() {
        
        if(this.constructor === AbstractFactory){

                throw new TypeError('Abstract class "AbstractFactory" cannot be instaciated')
            }
     }

     createBasico() {

     }

     createConforto() {

     }

     createLuxo() {

     }

}

exports = AbstractFactory