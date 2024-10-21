type Fn = (...params: any[]) => Promise<any>;

function timeLimit(fn: Fn, t: number): Fn {
    
    return async function(...args) {
        return new Promise((resolve, reject) => {
            // Create a timeout that rejects after t milliseconds
            const timeoutId = setTimeout(() => {
                reject("Time Limit Exceeded");
            }, t);

            // Call the original async function
            fn(...args)
                .then((result) => {
                    clearTimeout(timeoutId); // Clear the timeout if fn resolves in time
                    resolve(result);         // Resolve with the original function result
                })
                .catch((error) => {
                    clearTimeout(timeoutId); // Clear the timeout if fn rejects in time
                    reject(error);           // Reject with the original function error
                });
        });
    }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */