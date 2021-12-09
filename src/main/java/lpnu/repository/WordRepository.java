package lpnu.repository;

import lpnu.entity.Word;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WordRepository {
    private final List<Word> words = new ArrayList<>();
    private long id = 1;

    public List<Word> getAllWords() {
        return new ArrayList<>(words);
    }

    public void deleteWordById(final Long id) {
        for (final Word word : words) {
            if (word.getId().equals(id)) {
                words.remove(word);
                break;
            }
        }
    }

    public Word updateWord(final Word word) {
        final Word savedWord = getWordById(word.getId());

        savedWord.setWord(word.getWord());
        savedWord.setPartOfSpeech(word.getPartOfSpeech());

        return savedWord;
    }

    public void saveWord(final Word word) {
        word.setId(id);
        ++id;
        words.add(word);
    }

    public Word getWordById(final Long id) {
        return words.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "word with id " + id + " not found"));
    }
}
