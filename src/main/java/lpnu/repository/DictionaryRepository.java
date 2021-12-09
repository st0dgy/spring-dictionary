package lpnu.repository;

import lpnu.entity.Dictionary;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DictionaryRepository {
    private final List<Dictionary> dictionaries = new ArrayList<>();
    private long id = 1;

    public List<Dictionary> getAllDictionaries() {
        return new ArrayList<>(dictionaries);
    }

    public void deleteDictionaryById(final Long id) {
        for (final Dictionary dictionary : dictionaries) {
            if (dictionary.getId().equals(id)) {
                dictionaries.remove(dictionary);
                break;
            }
        }
    }

    public Dictionary updateDictionary(final Dictionary dictionary) {
        final Dictionary savedDictionary = getDictionaryById(dictionary.getId());

        savedDictionary.setWord(dictionary.getWord());
        savedDictionary.setExplanation(dictionary.getExplanation());

        return savedDictionary;
    }

    public void saveDictionary(final Dictionary dictionary) {
        dictionary.setId(id);
        ++id;
        dictionaries.add(dictionary);
    }

    public Dictionary getDictionaryById(final Long id) {
        return dictionaries.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "reader with id " + id + " not found"));
    }
}
