package sk.fei.tp.ease.dto.domain.search;

import java.util.Objects;

public final class GeneralSearchResultDto {
    private final EntityType type;
    private final String name;
    private final Long packageId;

    public GeneralSearchResultDto(EntityType type, String name, Long packageId) {
        this.type = type;
        this.name = name;
        this.packageId = packageId;
    }

    public EntityType type() {
        return type;
    }

    public String name() {
        return name;
    }

    public Long packageId() {
        return packageId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (GeneralSearchResultDto) obj;
        return Objects.equals(this.type, that.type) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.packageId, that.packageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, packageId);
    }

    @Override
    public String toString() {
        return "GeneralSearchResultDto[" +
                "type=" + type + ", " +
                "name=" + name + ", " +
                "packageId=" + packageId + ']';
    }

}
