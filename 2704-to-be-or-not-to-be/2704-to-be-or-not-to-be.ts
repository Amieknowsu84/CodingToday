type ToBeOrNotToBe = {
    toBe: (val: any) => boolean;
    notToBe: (val: any) => boolean;
};

function expect(val: any): ToBeOrNotToBe {
   return {
     toBe: (otherVal: any): boolean => {
       if (val === otherVal) return true;
       throw new Error("Not Equal");
     },
     notToBe: (otherVal: any): boolean => {
       if (val !== otherVal) return true;
       throw new Error("Equal");
     }
   };
}

/**
 * Example usage:
 * 
 * expect(5).toBe(5);       // true
 * expect(5).notToBe(5);    // throws "Equal"
 */
