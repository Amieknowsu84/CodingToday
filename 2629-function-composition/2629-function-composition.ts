type F = (x: number) => number;

function compose(functions: F[]): F {
    return function(x) {
        if(functions.length == 0){
            return x;
        }
        let res = x;
        for(let i=functions.length-1; i >= 0 ; i--){
            res = functions[i](res);
        }
        return res;
    }
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */