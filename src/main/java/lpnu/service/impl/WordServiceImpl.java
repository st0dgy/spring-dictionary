package lpnu.service.impl;

import lpnu.dto.WordDTO;
import lpnu.exception.ServiceException;
import lpnu.mapper.WordToWordDTOMapper;
import lpnu.repository.WordRepository;
import lpnu.service.WordService;

import java.util.List;
import java.util.stream.Collectors;

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
    public WordDTO updateWord(final WordDTO explanationDTO) {
        if (explanationDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }

        return wordMapper.toDTO(wordRepository.updateWord(wordMapper.toEntity(explanationDTO)));
    }

    @Override
    public WordDTO saveWord(final WordDTO explanationDTO) {
        if (explanationDTO.getId() != null) {
            throw new ServiceException(400, "id not null");
        }

        if (wordRepository.getAllWords().stream().anyMatch(wordMapper.toEntity(explanationDTO)::equals)) {
            throw new ServiceException(400, "word is already saved");
        }

        wordRepository.saveWord(wordMapper.toEntity(explanationDTO));
        return wordMapper.toDTO(wordMapper.toEntity(explanationDTO));
    }
}
