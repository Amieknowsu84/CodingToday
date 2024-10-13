type Counter = {
    increment: () => number,
    decrement: () => number,
    reset: () => number,
}

function createCounter(init: number): Counter {
    let counterVal = init;
    let def_val = init;
    return {
    increment: () => ++counterVal,
    decrement: () => --counterVal,
    reset: ()=> {
        counterVal = def_val;
        return def_val;
    }
    };
    
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */