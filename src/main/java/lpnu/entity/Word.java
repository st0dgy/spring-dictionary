package lpnu.entity;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class Word {
    private Long id;

    @NotBlank
    private String word;

    @NotBlank
    private String partOfSpeech;

    public Word(){

    }

    public Word(final Long id, final String word, final String partOfSpeech) {
        this.id = id;
        this.word = word;
        this.partOfSpeech = partOfSpeech;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(final String word) {
        this.word = word;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(final String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word) && Objects.equals(partOfSpeech, word1.partOfSpeech);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, partOfSpeech);
    }
}
