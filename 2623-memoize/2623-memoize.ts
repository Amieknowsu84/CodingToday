type Fn = (...params: number[]) => number

function memoize(fn: Fn): Fn {
    let callCount = 0;
    let myMap = new Map<string, number>();
    let myFunc = fn;
    return function(...args) {
        let key: string= args.join(",");
        if(!myMap.has(key)){
            callCount++;
            myMap.set(key,myFunc(...args));
        }
        return myMap.get(key);
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */