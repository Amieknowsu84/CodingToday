function map(arr: number[], fn: (n: number, i: number) => number): number[] {
    let result: number[] = [];
    arr.forEach((number,index) =>{
        result.push(fn(number,index));
    });
    return result;
};