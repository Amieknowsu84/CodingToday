type Fn = (n: number, i: number) => any

function filter(arr: number[], fn: Fn): number[] {
    let result: number[] = [];
    for (const [index, num] of arr.entries()) {
        if(fn(num,index))
            result.push(num);
    }
    return result;
};