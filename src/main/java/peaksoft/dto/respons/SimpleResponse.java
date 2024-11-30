package peaksoft.dto.respons;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record SimpleResponse(
        HttpStatus status,
        String message
) {
}
