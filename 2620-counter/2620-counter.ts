 
function createCounter(n: number): () => number {
    let num: number = null;
    return function() {
        if(num == null){
            num = n;
            return num;
        }else{
            num = num+1;
            return num;
        }
    }
}


/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */