class Solution {
    
    int maxScore;
    
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        maxScore = 0;
        maxScoreWords(words, letters, score, 0,0);
        return maxScore;
    }
    
    
    void maxScoreWords(String[] words, char[] letters, int[] scores, int index,int score){
        if(index >= words.length){
            maxScore = Math.max(maxScore, score);
            return;
        }
        
        char[] lettersCopy = new char[letters.length];
        System.arraycopy(letters, 0,lettersCopy, 0, letters.length); 
        
        int currentScore = calculateScore(words[index],letters,scores);
        if(currentScore > 0){
            maxScoreWords(words, letters, scores, index+1, currentScore+score);
        }
        System.arraycopy(lettersCopy, 0,letters, 0, letters.length);
        maxScoreWords(words, letters, scores, index+1, score);
    }
    
    int calculateScore(String word,char[] letters, int[] scores){
        int score = 0;
        for(int i=0;i<word.length();i++){
            char current = word.charAt(i);
            boolean allocated = false;
            for(int j=0; j<letters.length;j++){
                if(letters[j] == current){
                   int indexOfChar = current-'a'; 
                   score+=scores[indexOfChar];
                   allocated = true; 
                   letters[j] = '-';
                   break;
                }
            }
            if(!allocated){
                return 0;
            }
        }
        
       return score; 
    }
    
}