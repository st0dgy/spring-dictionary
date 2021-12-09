package lpnu.service;

import lpnu.dto.DictionaryDTO;

import java.util.List;

public interface DictionaryService {
    DictionaryDTO saveDictionary(final DictionaryDTO dictionaryDTO);
    List<DictionaryDTO> getAllDictionaries();
    DictionaryDTO getDictionaryById(final Long id);
    DictionaryDTO updateDictionary(final DictionaryDTO dictionaryDTO);
    void deleteDictionaryById(final Long id);
}
