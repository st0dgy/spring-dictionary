package lpnu.controller;

import lpnu.dto.ExplanationDTO;
import lpnu.dto.ReaderDTO;
import lpnu.dto.WordDTO;
import lpnu.service.ReaderService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1")
@RestController
public class ReaderController {
    private final ReaderService readerService;

    public ReaderController(final ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/readers")
    public ResponseEntity<List<ReaderDTO>> getAllReaders() {
        return ResponseEntity.ok().body(readerService.getAllReaders());
    }

    @GetMapping("/readers/{id}")
    public ResponseEntity<ReaderDTO> getReaderById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(readerService.getReaderById(id));
    }

    @PostMapping("/readers")
    public ResponseEntity<ReaderDTO> saveReader(@Validated @RequestBody final ReaderDTO readerDTO) {
        return ResponseEntity.ok().body(readerService.saveReader(readerDTO));
    }

    @PutMapping("/readers")
    public ResponseEntity<ReaderDTO> updateReader(@Validated @RequestBody final ReaderDTO readerDTO) {
        return ResponseEntity.ok().body(readerService.updateReader(readerDTO));
    }

    @PutMapping("/readers-dictionary")
    public ResponseEntity<ReaderDTO> updateReader(@Validated @RequestBody final Map<WordDTO, ExplanationDTO> mapDTO, @PathVariable final Long id) {
        return ResponseEntity.ok().body(readerService.addNewWordsToDictionary(mapDTO, id));
    }

    @DeleteMapping("/readers/{id}")
    public ResponseEntity deleteReaderById(@PathVariable final Long id) {
        readerService.deleteReaderById(id);
        return ResponseEntity.ok().build();
    }
}
