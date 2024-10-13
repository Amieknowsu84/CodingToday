type Counter = {
    increment: () => number,
    decrement: () => number,
    reset: () => number,
}

function createCounter(init: number): Counter {
    let counterVal = init;
    return {
    increment: () => ++counterVal,
    decrement: () => --counterVal,
    reset: ()=> counterVal = init
        
    };
    
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */