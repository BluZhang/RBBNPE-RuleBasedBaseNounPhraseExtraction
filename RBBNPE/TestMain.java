package RBBNPE;

import java.util.ArrayList;

public class TestMain {

	public TestMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exampleText = "This text includes some noun phrases and some other phrases. I am only interested in the phrases, which are useful to my project.";
        
		POSBasedBaseNounPhraseExtractor extractor = new POSBasedBaseNounPhraseExtractor("english-left3words-distsim.tagger");
        extractor.extractBaseNounPhrasesFromText(exampleText);
    
        ArrayList<BaseNounPhrase> baseNounPhrases = extractor.getBaseNounPhrases();
        System.out.println(baseNounPhrases);
	}
	

}
