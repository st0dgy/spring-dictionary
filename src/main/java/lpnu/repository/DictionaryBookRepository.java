package lpnu.repository;

import lpnu.entity.DictionaryBook;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DictionaryBookRepository {
    private final List<DictionaryBook> dictionaryBooks = new ArrayList<>();
    private long id = 1;

    public List<DictionaryBook> getAllDictionaryBooks() {
        return new ArrayList<>(dictionaryBooks);
    }

    public void deleteDictionaryBookById(final Long id) {
        for (final DictionaryBook dictionaryBook : dictionaryBooks) {
            if (dictionaryBook.getId().equals(id)) {
                dictionaryBooks.remove(dictionaryBook);
                break;
            }
        }
    }

    public DictionaryBook updateDictionaryBook(final DictionaryBook dictionaryBook) {
        final DictionaryBook savedDictionaryBook = getDictionaryBookById(dictionaryBook.getId());

        savedDictionaryBook.setWord(dictionaryBook.getWord());
        savedDictionaryBook.setExplanation(dictionaryBook.getExplanation());

        return savedDictionaryBook;
    }

    public void saveDictionary(final DictionaryBook dictionaryBook) {
        dictionaryBook.setId(id);
        ++id;
        dictionaryBooks.add(dictionaryBook);
    }

    public DictionaryBook getDictionaryBookById(final Long id) {
        return dictionaryBooks.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "reader with id " + id + " not found"));
    }
}
