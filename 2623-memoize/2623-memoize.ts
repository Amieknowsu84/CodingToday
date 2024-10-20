type Fn = (...params: number[]) => number

function memoize(fn: Fn): Fn {
    let callCount = 0;
    const cache = new Map<string, number>();
    return function(...args) {
        let key: string= args.join(",");
        if(!cache.has(key)){
            callCount++;
            cache.set(key,fn(...args));
        }
        return cache.get(key);
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