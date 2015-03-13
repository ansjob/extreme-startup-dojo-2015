
public class Scrabble {
	public int scrabbleScore(String scrabbleWord) {
        scrabbleWord = scrabbleWord.toUpperCase();
        int score = 0;
        for (int i = 0; i < scrabbleWord.length(); i++){
            char calculatedLetter = scrabbleWord.charAt(i);
            switch (calculatedLetter) {
                case 'A':
                case 'E':
                case 'I':
                case 'L':
                case 'N':
                case 'O':
                case 'R':
                case 'S':
                case 'T':
                case 'U': //Jesus this is fugly
                    score +=1; break;
                case 'D':
                case 'G':
                    score +=2; break;
                case 'B':
                case 'C':
                case 'M':
                case 'P':
                    score +=3; break;
                case 'F':
                case 'H':
                case 'V':
                case 'W':
                case 'Y':
                    score +=4; break;
                case 'K':
                    score +=5; break;
                case 'J':
                case 'X':
                    score +=8; break;
                case 'Q':
                case 'Z':
                    score +=10; break;
                default: break;
            }
        }
        return score;
    }
}
