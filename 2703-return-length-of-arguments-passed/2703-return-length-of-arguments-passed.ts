type JSONValue = null | boolean | number | string | JSONValue[] | { [key: string]: JSONValue };

function argumentsLength(...args: JSONValue[]): number {
    let count = 0;
    for(let i=0;i<args.length;i++){
         const arg = args[i];

        if (arg === null || typeof arg === "boolean" || typeof arg === "number" || typeof arg === "string" || Object.values(arg).length == 0) {
            count += 1;
        } else if (Array.isArray(arg)) {
            // If the argument is an array, recursively count the elements
            count += 1;
        } else if (typeof arg === "object") {
            // If the argument is an object, recursively count the values
            count += argumentsLength(...Object.values(arg));
        }
    }
    return count;
};

/**
 * argumentsLength(1, 2, 3); // 3
 */