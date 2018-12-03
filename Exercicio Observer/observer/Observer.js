class Observer {

    constructor () {

        if(this.constructor === Observer) 
            throw new TypeError('Abstract class "Observer" cannot be instaciated')
    
    }

    notify(subject) {
    }
}