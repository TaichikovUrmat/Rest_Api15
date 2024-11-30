package peaksoft.dto.respons;

import lombok.Builder;

import java.util.List;

@Builder
public record GetAllLibraryResponse(
        Long id,
        String name,
        String  address,
        List<GetAllBookResponse> getAllBook
) {
}
