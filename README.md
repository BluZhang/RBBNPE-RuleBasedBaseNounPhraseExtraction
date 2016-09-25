## Synopsis

The RBBNPE (Rule based base noun phrase extraction) system extracts base noun phrases from a given text using hand-crafted syntactic rules.
It is written in JAVA and can be easily included in Natural Language Processing (NLP) projects. Evaluation on section 20 of the WSJ data set, taken from the CoNLL-2000 shared task, shows an F1-score of 89.5%

## Code Example

Example of extraction from text and output as a List of BaseNounPhrase objects:

```java
   String exampleText = "This text includes some noun phrases and some other phrases. I am only interested in the phrases, which are useful to my project.";
   POSBasedBaseNounPhraseExtractor extractor = new POSBasedBaseNounPhraseExtractor("english-left3words-distsim.tagger");
   extractor.extractBaseNounPhrasesFromText(text);
   ArrayList<BaseNounPhrase> baseNounPhrases = extractor.getBaseNounPhrases();
   System.out.println(baseNounPhrases);
```
Example of extraction from CoNLL data file and saving to CoNLL data file:

```java
   POSBasedBaseNounPhraseExtractor extractor = new POSBasedBaseNounPhraseExtractor("english-left3words-distsim.tagger");
   extractor.extractBaseNounPhrasesFromCoNLLData("data/test.txt");
   extractor.writeBaseNounPhrasesAsCoNLLFile("output/extractedNPsCoNLL.txt");
```

## Motivation
I created this project as part of my Bachelor's thesis about base noun phrase extraction using hand-crafted rules.
It shows the practicality of a very simple system using only a small amount of rules and provided as a very simple JAVA interface.
The performance target was set to match other simple [hand crafted rule systems](https://www.ltg.ed.ac.uk/software/lt-ttt2/), while providing greater insight and beeing easy to integrate into existing JAVA projects.
Although the rules are adapted to the English language, the can easily be modified for other languages.

## Installation

Installation of the Stanford NLP project required.
- Add all Stanford NLP jars to your project
- Add all jars required by the Stanford NLP project to your project
- Import Classes

## API Reference

Usage of the system is divided between input and output operations. The results of the extraction are saved internally until the user initiates an output. Two methods exist for each operation

**Initialisation:**

The system has to be initialized with a path to a Stanford NLP POS Tagger trained model. Choose the appropriate one based on target language and intended purpose of application
```java
    POSBasedBaseNounPhraseExtractor(String pathToStanfordModel)
```
**Input:**

The method expects an input text as a string, preferably with whitespaces after each sentence. The text can span multiple sentences
```java
    void extractBaseNounPhrasesFromText(String text)
```
The method expects the absolute path to a file in the CoNLL format.
Tokens are in the first column. All other columns are ignored. There should be one empty line after each sentence.

```java
    void extractBaseNounPhrasesFromCoNLLData(String path) throws IOException
```

**Output:**

Returns the extracted base noun phrases as a List of BaseNounPhrase objects. These include convenience methods and other information
```java
    ArrayList<BaseNounPhrase> getBaseNounPhrases()
```
Writes the previously extracted base noun phrases to the given absolute path in the CoNLL Format
- 1. Column entails the tokens
- 2. Column entails the identified POS Tags
- 3. Column entails the chunk tags in the IOB2 format, only with baseNP information (Only B, I and O)

The POS tags are the same as in the [PennTreebank](https://www.ling.upenn.edu/courses/Fall_2003/ling001/penn_treebank_pos.html)
```java
    void writeBaseNounPhrasesAsCoNLLFile(String pathToWrite) throws FileNotFoundException, UnsupportedEncodingException
```
**Base Noun Phrase**

This method returns the string of the token, which the system considers to be the head of the noun phrase. Uses the rules provided by [Collins, Michael. "Head-driven statistical models for natural language parsing." Computational linguistics 29.4 (2003): 589-637.](http://www.mitpressjournals.org/doi/pdfplus/10.1162/089120103322753356)
```java
    String getHead()
```
Convenience Methods:
```java
    String getPhraseString()
    String getPhraseStringWithPOSTags()
    
    int getEndOffset()
    int getStartOffset()
```
Return the POS tag of the last token in the phrase as a String
```java
    String getPosTag()
```
## Contributors

Contributions to the system are greatly appreciated.

## License

The RBBNPE code is written in Java and licensed under the GNU General Public License (v3 or later). Note that this is the full GPL, which allows many free uses, but not its use in proprietary software that you distribute to others.
