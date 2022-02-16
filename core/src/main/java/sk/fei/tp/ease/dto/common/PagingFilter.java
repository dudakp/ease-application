package sk.fei.tp.ease.dto.common;

import lombok.Data;
import org.springframework.lang.Nullable;
import sk.fei.tp.ease.dto.request.GeneralSearchOrderKey;

@Data
public class PagingFilter {
    private int pageSize = 10;
    private int page;
    private boolean descending;

    @Nullable
    private GeneralSearchOrderKey orderKey;
}
