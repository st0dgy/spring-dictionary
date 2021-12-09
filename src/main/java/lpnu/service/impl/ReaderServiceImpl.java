package lpnu.service.impl;

import lpnu.dto.ExplanationDTO;
import lpnu.dto.ReaderDTO;
import lpnu.dto.WordDTO;
import lpnu.entity.Explanation;
import lpnu.entity.Reader;
import lpnu.entity.Word;
import lpnu.exception.ServiceException;
import lpnu.mapper.ExplanationToExplanationDTOMapper;
import lpnu.mapper.ReaderToReaderDTOMapper;
import lpnu.mapper.WordToWordDTOMapper;
import lpnu.repository.ReaderRepository;
import lpnu.service.ReaderService;

import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    private final ReaderToReaderDTOMapper readerMapper;
    private final WordToWordDTOMapper wordMapper;
    private final ExplanationToExplanationDTOMapper explanationMapper;
    private final ReaderRepository readerRepository;

    public ReaderServiceImpl(final ReaderToReaderDTOMapper readerMapper, final WordToWordDTOMapper wordMapper,
                             final ExplanationToExplanationDTOMapper explanationMapper, final ReaderRepository readerRepository) {
        this.readerMapper = readerMapper;
        this.wordMapper = wordMapper;
        this.explanationMapper = explanationMapper;
        this.readerRepository = readerRepository;
    }

    @Override
    public List<ReaderDTO> getAllReaders() {
        return readerRepository.getAllReaders().stream()
                .map(readerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReaderDTO getReaderById(final Long id) {
        return readerMapper.toDTO(readerRepository.getReaderById(id));
    }

    @Override
    public void deleteReaderById(final Long id) {
        readerRepository.deleteReaderById(id);
    }

    @Override
    public ReaderDTO updateReader(final ReaderDTO readerDTO) {
        if (readerDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }

        return readerMapper.toDTO(readerRepository.updateReader(readerMapper.toEntity(readerDTO)));
    }

    @Override
    public ReaderDTO saveReader(final ReaderDTO readerDTO) {
        if (readerDTO.getId() != null) {
            throw new ServiceException(400, "id not null");
        }

        if (readerRepository.getAllReaders().stream().anyMatch(readerMapper.toEntity(readerDTO)::equals)) {
            throw new ServiceException(400, "reader is already saved");
        }

        final Reader reader = readerMapper.toEntity(readerDTO);

        readerRepository.saveReader(reader);
        return readerMapper.toDTO(reader);
    }
}
