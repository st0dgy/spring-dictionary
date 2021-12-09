package lpnu.service.impl;

import lpnu.dto.DictionaryBookDTO;
import lpnu.exception.ServiceException;
import lpnu.mapper.DictionaryBookToDictionaryBookDTOMapper;
import lpnu.repository.DictionaryBookRepository;
import lpnu.service.DictionaryBookService;

import java.util.List;
import java.util.stream.Collectors;

public class DictionaryBookServiceImpl implements DictionaryBookService {
    private final DictionaryBookRepository dictionaryBookRepository;
    private final DictionaryBookToDictionaryBookDTOMapper dictionaryBookMapper;

    public DictionaryBookServiceImpl(DictionaryBookRepository dictionaryBookRepository, DictionaryBookToDictionaryBookDTOMapper dictionaryBookMapper) {
        this.dictionaryBookRepository = dictionaryBookRepository;
        this.dictionaryBookMapper = dictionaryBookMapper;
    }

    @Override
    public List<DictionaryBookDTO> getAllDictionaryBooks() {
        return dictionaryBookRepository.getAllDictionaryBooks().stream()
                .map(dictionaryBookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DictionaryBookDTO getDictionaryBookById(final Long id) {
        return dictionaryBookMapper.toDTO(dictionaryBookRepository.getDictionaryBookById(id));
    }

    @Override
    public void deleteDictionaryBookById(final Long id) {
        dictionaryBookRepository.deleteDictionaryBookById(id);
    }

    @Override
    public DictionaryBookDTO updateDictionaryBook(final DictionaryBookDTO dictionaryDTO) {
        if (dictionaryDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }

        return dictionaryBookMapper.toDTO(dictionaryBookRepository.
                updateDictionaryBook(dictionaryBookMapper.toEntity(dictionaryDTO)));
    }

    @Override
    public DictionaryBookDTO saveDictionaryBook(final DictionaryBookDTO dictionaryDTO) {
        if (dictionaryDTO.getId() != null) {
            throw new ServiceException(400, "id not null");
        }

        if (dictionaryBookRepository.getAllDictionaryBooks().stream().anyMatch(dictionaryBookMapper.toEntity(dictionaryDTO)::equals)) {
            throw new ServiceException(400, "dictionary is already saved");
        }

        dictionaryBookRepository.saveDictionary(dictionaryBookMapper.toEntity(dictionaryDTO));
        return dictionaryBookMapper.toDTO(dictionaryBookMapper.toEntity(dictionaryDTO));
    }
}
