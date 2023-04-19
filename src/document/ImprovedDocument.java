package document;

public class ImprovedDocument extends Document
{
    public ImprovedDocument(String text) {
        super(text);
    }

    @Override
    public int getNumSyllables() {
        return 0;
    }

    @Override
    public int getNumSentences() {
        return 0;
    }

    @Override
    public int getNumWords() {
        return 0;
    }

    public static void main(String args[]) {

    }
}

