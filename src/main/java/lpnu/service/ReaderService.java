package lpnu.service;

import lpnu.dto.ExplanationDTO;
import lpnu.dto.ReaderDTO;
import lpnu.dto.WordDTO;

import java.util.List;
import java.util.Map;

public interface ReaderService {
    ReaderDTO saveReader(final ReaderDTO readerDTO);
    List<ReaderDTO> getAllReaders();
    ReaderDTO getReaderById(final Long id);
    ReaderDTO updateReader(final ReaderDTO readerDTO);
    void deleteReaderById(final Long id);
    ReaderDTO addNewWordsToDictionary(final Map<WordDTO, ExplanationDTO> mapDTO, final Long id);
}
