public class MultLetter extends Filler {
    private int wordMult = 1;
    private int letterMult = super.magnitude;

    public MultLetter(int amt){
        super(amt);
    }

    public int getWordMult() {
        return wordMult;
    }

    public int getLetterMult() {
        return letterMult;
    }
}
