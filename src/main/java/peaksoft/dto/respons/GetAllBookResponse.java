package peaksoft.dto.respons;

import lombok.Builder;

import java.time.LocalDate;
@Builder
public record GetAllBookResponse(
        Long id,
        String bookName,
        String author,
        LocalDate publicationYear,      /// Год издания
        String description,             ///  Описание:
        int price
) {
}
