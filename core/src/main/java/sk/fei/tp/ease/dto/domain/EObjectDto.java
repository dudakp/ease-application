package sk.fei.tp.ease.dto.domain;

import sk.fei.tp.ease.model.enums.ObjectType;

import java.util.Objects;

public final class EObjectDto {
    private final Long id;
    private final ObjectType type;
    private final String name;
    private final String alias;
    private final String author;
    private final Integer version;
    private final EPackageDto ePackage;

    public EObjectDto(
            Long id,
            ObjectType type,
            String name,
            String alias,
            String author,
            Integer version,
            EPackageDto ePackage
    ) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.alias = alias;
        this.author = author;
        this.version = version;
        this.ePackage = ePackage;
    }

    public Long id() {
        return id;
    }

    public ObjectType type() {
        return type;
    }

    public String name() {
        return name;
    }

    public String alias() {
        return alias;
    }

    public String author() {
        return author;
    }

    public Integer version() {
        return version;
    }

    public EPackageDto ePackage() {
        return ePackage;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (EObjectDto) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.type, that.type) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.alias, that.alias) &&
                Objects.equals(this.author, that.author) &&
                Objects.equals(this.version, that.version) &&
                Objects.equals(this.ePackage, that.ePackage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, alias, author, version, ePackage);
    }

    @Override
    public String toString() {
        return "EObjectDto[" +
                "id=" + id + ", " +
                "type=" + type + ", " +
                "name=" + name + ", " +
                "alias=" + alias + ", " +
                "author=" + author + ", " +
                "version=" + version + ", " +
                "ePackage=" + ePackage + ']';
    }

}
