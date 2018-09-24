module.exports = class Carta {

    constructor(naipe, num) {
        this._naipe = Carta.naipeFromIndex(naipe)
        this._num = Carta.numFromIndex(num)
    }

    getNaipe(){
    
        return this._naipe 
    }

    getNumero(){
    
        return this._num
    }

    setNaipe(naipe){
        
        this._naipe = naipe 
    }

    setNumero(numero){

        this._num = numero 
    }

    static naipeFromIndex(i){
        return Carta._getNaipes()[i-1]
    }

    static indexFromNaipe(naipe) {
        return Carta._getNaipes().indexOf(naipe) +1
    }

    static numFromIndex(i) {
        return Carta._getNums()[i-1]
    }

    static indexFromNum(num) {
        return Carta._getNums().indexOf(num)+1
    }

    static _getNaipes() {
        return ['paus', 'espadas', 'copas', 'ouros']
    }

    static _getNums() {
        return ['A', '1','2','3','4','5','6','7','8','9','10','J','Q','K']
    }
}
