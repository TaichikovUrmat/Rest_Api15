package peaksoft.dto.respons;

import lombok.Builder;
import org.springframework.http.HttpStatus;
@Builder
public record GetUpdateLibrary(
        HttpStatus status,
        String message,
        String name,
        String address

) {
}
