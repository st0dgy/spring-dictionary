package lpnu.service.impl;

import lpnu.dto.DictionaryBookDTO;
import lpnu.entity.DictionaryBook;
import lpnu.exception.ServiceException;
import lpnu.mapper.DictionaryBookToDictionaryBookDTOMapper;
import lpnu.repository.DictionaryBookRepository;
import lpnu.service.DictionaryBookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DictionaryBookServiceImpl implements DictionaryBookService {
    private final DictionaryBookRepository dictionaryBookRepository;
    private final DictionaryBookToDictionaryBookDTOMapper dictionaryBookMapper;

    public DictionaryBookServiceImpl(final DictionaryBookRepository dictionaryBookRepository,
                                     final DictionaryBookToDictionaryBookDTOMapper dictionaryBookMapper) {
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
    public DictionaryBookDTO updateDictionaryBook(final DictionaryBookDTO dictionaryBookDTO) {
        if (dictionaryBookDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }

        final DictionaryBook dictionaryBook = dictionaryBookMapper.toEntity(dictionaryBookDTO);
        return dictionaryBookMapper.toDTO(dictionaryBookRepository.updateDictionaryBook(dictionaryBook));
    }

    @Override
    public DictionaryBookDTO saveDictionaryBook(final DictionaryBookDTO dictionaryBookDTO) {
        if (dictionaryBookDTO.getId() != null) {
            throw new ServiceException(400, "id not null");
        }

        if (dictionaryBookRepository.getAllDictionaryBooks().stream().anyMatch(dictionaryBookMapper.toEntity(dictionaryBookDTO)::equals)) {
            throw new ServiceException(400, "dictionary is already saved");
        }

        final DictionaryBook dictionaryBook = dictionaryBookMapper.toEntity(dictionaryBookDTO);

        dictionaryBookRepository.saveDictionary(dictionaryBook);
        return dictionaryBookMapper.toDTO(dictionaryBook);
    }
}
