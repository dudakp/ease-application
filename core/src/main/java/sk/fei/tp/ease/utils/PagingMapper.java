package sk.fei.tp.ease.utils;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;
import sk.fei.tp.ease.dto.common.PagedResult;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PagingMapper {

    private final DozerBeanMapper mapper;

    public <T, D> PagedResult<D> mapPagedResultToDto(PagedResult<T> res, Class<D> dtoClass) {
        List<D> dtoResult = res.getResults().stream()
                .map(r -> mapper.map(r, dtoClass))
                .collect(Collectors.toList());

        return new PagedResult<>(dtoResult, res);
    }
}
