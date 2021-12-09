package lpnu.service;

import lpnu.dto.DictionaryBookDTO;

import java.util.List;

public interface DictionaryBookService {
    DictionaryBookDTO saveDictionaryBook(final DictionaryBookDTO dictionaryDTO);
    List<DictionaryBookDTO> getAllDictionaryBooks();
    DictionaryBookDTO getDictionaryBookById(final Long id);
    DictionaryBookDTO updateDictionaryBook(final DictionaryBookDTO dictionaryDTO);
    void deleteDictionaryBookById(final Long id);
}
