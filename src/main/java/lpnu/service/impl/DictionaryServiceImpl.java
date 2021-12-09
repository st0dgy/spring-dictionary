package lpnu.service.impl;

import lpnu.dto.DictionaryDTO;
import lpnu.entity.Dictionary;
import lpnu.exception.ServiceException;
import lpnu.mapper.DictionaryToDictionaryDTOMapper;
import lpnu.repository.DictionaryRepository;
import lpnu.service.DictionaryService;

import java.util.List;
import java.util.stream.Collectors;

public class DictionaryServiceImpl implements DictionaryService{
    private final DictionaryRepository dictionaryRepository;
    private final DictionaryToDictionaryDTOMapper dictionaryMapper;

    public DictionaryServiceImpl(final DictionaryRepository dictionaryRepository,
                                 final DictionaryToDictionaryDTOMapper dictionaryMapper) {
        this.dictionaryRepository = dictionaryRepository;
        this.dictionaryMapper = dictionaryMapper;
    }

    @Override
    public List<DictionaryDTO> getAllDictionaries() {
        return dictionaryRepository.getAllDictionaries().stream()
                .map(dictionaryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DictionaryDTO getDictionaryById(final Long id) {
        return dictionaryMapper.toDTO(dictionaryRepository.getDictionaryById(id));
    }

    @Override
    public void deleteDictionaryById(final Long id) {
        dictionaryRepository.deleteDictionaryById(id);
    }

    @Override
    public DictionaryDTO updateDictionary(final DictionaryDTO dictionaryDTO) {
        if (dictionaryDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }

        return dictionaryMapper.toDTO(dictionaryRepository.
                updateDictionary(dictionaryMapper.toEntity(dictionaryDTO)));
    }

    @Override
    public DictionaryDTO saveDictionary(final DictionaryDTO dictionaryDTO) {
        if (dictionaryDTO.getId() != null) {
            throw new ServiceException(400, "id not null");
        }

        if (dictionaryRepository.getAllDictionaries().stream().anyMatch(dictionaryMapper.toEntity(dictionaryDTO)::equals)) {
            throw new ServiceException(400, "dictionary is already saved");
        }

        dictionaryRepository.saveDictionary(dictionaryMapper.toEntity(dictionaryDTO));
        return dictionaryMapper.toDTO(dictionaryMapper.toEntity(dictionaryDTO));
    }
}
