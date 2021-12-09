package lpnu.service;

import lpnu.dto.ReaderDTO;

import java.util.List;

public interface ReaderService {
    ReaderDTO saveReader(final ReaderDTO readerDTO);

    List<ReaderDTO> getAllReaders();

    ReaderDTO getReaderById(final Long id);

    ReaderDTO updateReader(final ReaderDTO readerDTO);

    void deleteReaderById(final Long id);
}
