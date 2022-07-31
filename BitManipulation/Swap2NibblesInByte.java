package BitManipulation;

public class Swap2NibblesInByte {

    static int swapNibbles(int N) {
    
        // these values are for extracting lower 4-bits and higher 4-bits
        int lower = 15;
        int highr = 240;
        
        // now extract lower 4-bits and higher-4 bits.
        int temp1 = N & lower;
        int temp2 = N & highr;
        
        // left shift temp1 4 times
        // right shift temp2 4 times
        temp1 = temp1<<4;
        temp2 = temp2 >> 4;
        
        return temp1|temp2;
        
    }
    
}
