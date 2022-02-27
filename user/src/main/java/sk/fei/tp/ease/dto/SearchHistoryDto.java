package sk.fei.tp.ease.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SearchHistoryDto {
        private Long id;
        private String user;
        private LocalDateTime time;
        private String searchedExpression;
}
