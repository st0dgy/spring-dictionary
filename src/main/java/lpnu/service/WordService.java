package lpnu.service;

import lpnu.dto.WordDTO;

import java.util.List;

public interface WordService {
    WordDTO saveWord(final WordDTO wordDTO);
    List<WordDTO> getAllWords();
    WordDTO getWordById(final Long id);
    WordDTO updateWord(final WordDTO wordDTO);
    void deleteWordById(final Long id);
}
