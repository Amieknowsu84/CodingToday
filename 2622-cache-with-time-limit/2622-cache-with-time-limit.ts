class TimeLimitedCache {
    private keyValueStore: Map<number,  { value: number, timeoutId: NodeJS.Timeout }>;

    constructor() {
        this.keyValueStore = new Map<number,{ value: number, timeoutId: NodeJS.Timeout }>();
    }
    
    set(key: number, value: number, duration: number): boolean {
        const exist: boolean = this.keyValueStore.has(key);
        
        if(exist){
            clearTimeout(this.keyValueStore.get(key).timeoutId);
        }
        
        const timeoutId = setTimeout(()=>{
            this.keyValueStore.delete(key);
        }, duration);
        
        this.keyValueStore.set(key, {value,timeoutId});
        
        return exist;
    }
    
    get(key: number): number {
         return this.keyValueStore.has(key)? this.keyValueStore.get(key).value: -1;
    }
    
    count(): number {
        return this.keyValueStore.size;
    }

}

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */