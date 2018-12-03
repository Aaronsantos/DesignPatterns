
class Subject {

    constructor(){

        if(this.constructor === Subject) 
            throw new TypeError('Abstract class "Subject" cannot be instaciated')
        
        this._observerCollection  = []
    }

     registerObserver(observer){

    }

    unregisterObserver(observer) {

    }

    notifyObservers(){

    }
}