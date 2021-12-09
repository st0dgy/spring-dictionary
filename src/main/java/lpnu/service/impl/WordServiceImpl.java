package lpnu.service.impl;

import lpnu.dto.WordDTO;
import lpnu.entity.Word;
import lpnu.exception.ServiceException;
import lpnu.mapper.WordToWordDTOMapper;
import lpnu.repository.WordRepository;
import lpnu.service.WordService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordServiceImpl implements WordService {
    private final WordToWordDTOMapper wordMapper;
    private final WordRepository wordRepository;

    public WordServiceImpl(final WordToWordDTOMapper wordMapper, final WordRepository wordRepository) {
        this.wordMapper = wordMapper;
        this.wordRepository = wordRepository;
    }

    @Override
    public List<WordDTO> getAllWords() {
        return wordRepository.getAllWords().stream()
                .map(wordMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public WordDTO getWordById(final Long id) {
        return wordMapper.toDTO(wordRepository.getWordById(id));
    }

    @Override
    public void deleteWordById(final Long id) {
        wordRepository.deleteWordById(id);
    }

    @Override
    public WordDTO updateWord(final WordDTO wordDTO) {
        if (wordDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }

        final Word word = wordMapper.toEntity(wordDTO);
        return wordMapper.toDTO(wordRepository.updateWord(word));
    }

    @Override
    public WordDTO saveWord(final WordDTO wordDTO) {
        if (wordDTO.getId() != null) {
            throw new ServiceException(400, "id not null");
        }

        if (wordRepository.getAllWords().stream().anyMatch(wordMapper.toEntity(wordDTO)::equals)) {
            throw new ServiceException(400, "word is already saved");
        }

        final Word word = wordMapper.toEntity(wordDTO);

        wordRepository.saveWord(word);
        return wordMapper.toDTO(word);
    }
}
