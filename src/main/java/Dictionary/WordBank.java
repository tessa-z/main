package Dictionary;

import java.util.Locale;
import exception.WordUpException;

import exception.NoWordFoundException;
import command.OxfordCall;
import storage.Storage;

import java.util.Map;
import java.util.TreeMap;

public class WordBank {
    private TreeMap<String, Word> wordBank;

    public WordBank(Storage storage) {
        wordBank = storage.loadFile();
    }

    public WordBank(TreeMap<String, Word> wordBank) {
        this.wordBank = wordBank;
    }

    public TreeMap<String, Word> getWordBank() {
        return wordBank;
    }

    public Word getWordAndMeaning(String word) {
        return wordBank.get(word);
    }

    public void addWord(Word word) {
        this.wordBank.put(word.getWord(), word);
    }

    /**
     * Looks up for meaning of a specific word
     * @param word word to be searched for its meaning
     * @return a string represents meaning of that word
     * @throws NoWordFoundException if the word doesn't exist in the word bank
     */
    public String searchForMeaning(String word){ //throws NoWordFoundException {
        word = word.toLowerCase();
        if (!(wordBank.containsKey(word))){
            System.out.println("Unable to locate "+word+" in local dictionary. Looking up Oxford Dictionary\n");
            String result = OxfordCall.onlineSearch(word);
            Word temp = new Word(word,result);
            wordBank.put(word,temp);
        }
        return wordBank.get(word).getMeaning();
    }

    /**
     * Updates the meaning of a specific word
     * @param wordToBeEdited word whose meaning is updated
     * @param newMeaning new meaning of the word
     * @throws NoWordFoundException if the word doesn't exist in the word bank
     */
    public void editMeaning(String wordToBeEdited, String newMeaning) throws NoWordFoundException{
        if (wordBank.containsKey(wordToBeEdited)) {
            wordBank.get(wordToBeEdited).editMeaning(newMeaning);
        }
        else {
            throw new NoWordFoundException(wordToBeEdited);
        }
    }

    public Word getAndDelete(String word) throws NoWordFoundException {
        if (wordBank.containsKey(word)) {
            return wordBank.remove(word);
        }
        else {
            throw new NoWordFoundException(word);
        }
    }

    /**
     * Adds a tag to a specific word in word bank
     * @param wordToBeAddedTag word that the tag is set for
     * @param tag new tag input by user
     * @throws NoWordFoundException if the word doesn't exist in the word bank
     */
    public void addTag(String wordToBeAddedTag, String tag) throws NoWordFoundException {
        if (wordBank.containsKey(wordToBeAddedTag)) {
            wordBank.get(wordToBeAddedTag).addTag(tag);
        }
        else {
            throw new NoWordFoundException(wordToBeAddedTag);
        }
    }

    public String getBankData() {
        StringBuilder data = new StringBuilder();
        for (Map.Entry<String, Word> entry : wordBank.entrySet()) {
            data.append(entry.getValue() + "\n");
        }
        return data.toString();
    }
}
