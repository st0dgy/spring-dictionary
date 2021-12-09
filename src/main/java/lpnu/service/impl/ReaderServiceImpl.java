package lpnu.service.impl;

import lpnu.dto.ReaderDTO;
import lpnu.entity.Reader;
import lpnu.exception.ServiceException;
import lpnu.mapper.ReaderToReaderDTOMapper;
import lpnu.repository.ReaderRepository;
import lpnu.service.ReaderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReaderServiceImpl implements ReaderService {
    private final ReaderToReaderDTOMapper readerMapper;
    private final ReaderRepository readerRepository;

    public ReaderServiceImpl(final ReaderToReaderDTOMapper readerMapper,
                             final ReaderRepository readerRepository) {
        this.readerMapper = readerMapper;
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

        final Reader reader = readerMapper.toEntity(readerDTO);
        return readerMapper.toDTO(readerRepository.updateReader(reader));
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
