class Solution {
    
    static String[] hundreds = 
    {
        "OneHundred",
        "TwoHundred",
        "ThreeHundred",
        "FourHundred",
        "FiveHundred",
        "SixHundred",
        "SevenHundred",
        "EightHundred",
        "NineHundred"
    };

    static String[] elevenFamily = 
    {
        "Ten",
        "Eleven",
        "Twelve",
        "Thirteen",
        "Fourteen",
        "Fifteen",
        "Sixteen",
        "Seventeen",
        "Eighteen",
        "Nineteen"
    };

    static String[] tens = 
    {
        "Twenty",
        "Thirty",
        "Forty",
        "Fifty",
        "Sixty",
        "Seventy",
        "Eighty",
        "Ninety"
    };

    static String[] ones = 
    {
        "One",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine"
    };

    public String numberToWords(int num) {

        int[] number = new int[12] ;
        int temp = num ;
        int index = 0 ;
        while(temp > 0)
        {
            number[index] = temp % 10 ;
            temp = (temp - temp%10)/10 ;
            index ++ ;
        }

        //printArray(number) ;
        //System.out.println(toWord(number,2)) ;
        //int[] testing = {0,0,0} ;
        //System.out.println(toWord(testing,2)) ;

        StringBuilder result = new StringBuilder() ;

        if(!toWord(number,11).equals("Zero"))
        {
            result.append(toWord(number,11)) ;
            result.append("Billion") ;
        }

        if(!toWord(number,8).equals("Zero"))
        {
            result.append(toWord(number,8)) ;
            result.append("Million") ;
        }

        if(!toWord(number,5).equals("Zero"))
        {
            result.append(toWord(number,5)) ;
            result.append("Thousand") ;
        }

        if(!toWord(number,2).equals("Zero"))
        {
            result.append(toWord(number,2)) ;
        }

        if(result.isEmpty()) return "Zero" ;
        return addSpaces(result.toString()) ;
        
    }

    String toWord(int[] number, int index)
    {
        StringBuilder sb = new StringBuilder() ;

        if(number[index] != 0)
        {
            sb.append(hundreds[number[index]-1]);
        }

        index-- ;

        if(number[index] != 0)
        {
            if(number[index] == 1)
            {
                sb.append(elevenFamily[number[--index]]) ;
                return sb.toString() ;
            }
            {
                sb.append(tens[number[index]-2]);
            }
        }

        index-- ;

        if(number[index] != 0)
        {
            sb.append(ones[number[index]-1]) ;
        }

        if(sb.isEmpty()) return "Zero" ;

        return sb.toString() ;  
    }

        public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
        public static String addSpaces(String input) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (Character.isUpperCase(c) && i > 0) {
                sb.append(' ');
            }

            sb.append(c);
        }

        return sb.toString();
    }
}