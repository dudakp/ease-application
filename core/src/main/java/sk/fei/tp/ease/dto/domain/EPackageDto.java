package sk.fei.tp.ease.dto.domain;

import java.util.Objects;

public final class EPackageDto {
    private final Long id;
    private final String name;
    private final EPackageDto parent;
    private final Integer version;

    public EPackageDto(Long id,
                       String name,
                       EPackageDto parent,
                       Integer version) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.version = version;
    }

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public EPackageDto parent() {
        return parent;
    }

    public Integer version() {
        return version;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (EPackageDto) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.parent, that.parent) &&
                Objects.equals(this.version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, parent, version);
    }

    @Override
    public String toString() {
        return "EPackageDto[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "parent=" + parent + ", " +
                "version=" + version + ']';
    }

}
