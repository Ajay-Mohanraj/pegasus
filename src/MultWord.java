public class MultWord extends Filler {
    private int wordMult = super.magnitude;
    private int letterMult = 1;

    public MultWord(int amt){
        super(amt);
    }

    public int getWordMult() {
        return wordMult;
    }

    public int getLetterMult() {
        return letterMult;
    }
}
