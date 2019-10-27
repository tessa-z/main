package dictionary;


import java.util.HashSet;

/**
 * Represents words stored in the Word Bank.
 */

public class Word {
    private String word;
    private String meaning;
    private HashSet<String> tags;
    private HashSet<String> synonyms;

    /**
     * Number of times that a word is searched.
     */
    private int numberOfSearches;

    /**
     * String represents the closest time that user search for a specific word.
     */
    private String closetSearch;

    /**
     * Initializes a word without tags.
     * @param word description of the word
     * @param meaning meaning of the word
     */
    public Word(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
        this.tags = new HashSet<>();
        this.synonyms = new HashSet<>();
        this.numberOfSearches = 0;
    }

    /**
     * Initializes a word with tags.
     * @param word description of the word
     * @param meaning meaning of the word
     * @param tags hash set containing tags that are added to word
     */

    public Word(String word, String meaning, HashSet<String> synonyms) {
        this.word = word;
        this.meaning = meaning;
        this.synonyms = synonyms;
        this.numberOfSearches = 0;
    }

    public void setClosetSearch(String closetSearch) {
        this.closetSearch = closetSearch;
    }

    public String getWord() {
        return word;
    }

    public int getNumberOfSearches() {
        return numberOfSearches;
    }

    public void incrementNumberOfSearches() {
        this.numberOfSearches += 1;
    }

    public String getClosetSearch() {
        return closetSearch;
    }

    public String getMeaning() {
        return meaning;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public void editMeaning(String newMeaning) {
        this.meaning = newMeaning;
    }

    public HashSet<String> getSynonyms() { return synonyms;}

    public void addSyn(String synonym){ this.synonyms.add(synonym); }

    @Override
    public String toString() {
        return word + ": " + meaning;
    }
}
