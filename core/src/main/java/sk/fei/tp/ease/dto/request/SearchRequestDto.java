package sk.fei.tp.ease.dto.request;

import lombok.Data;

@Data
public final class SearchRequestDto {
    private String name;
    private int pageSize = 10;
    private int page = 0;
}
