package sk.fei.tp.ease.dto.domain;

import java.util.List;
import java.util.Objects;

public final class EDiagramDto {
    private final Long id;
    private final EPackageDto tPackage;
    private final List<EObjectDto> objects;
    private final String name;
    private final String author;
    private final Integer version;

    public EDiagramDto(Long id,
                       EPackageDto tPackage,
                       List<EObjectDto> objects,
                       String name,
                       String author,
                       Integer version) {
        this.id = id;
        this.tPackage = tPackage;
        this.objects = objects;
        this.name = name;
        this.author = author;
        this.version = version;
    }

    public Long id() {
        return id;
    }

    public EPackageDto tPackage() {
        return tPackage;
    }

    public List<EObjectDto> objects() {
        return objects;
    }

    public String name() {
        return name;
    }

    public String author() {
        return author;
    }

    public Integer version() {
        return version;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (EDiagramDto) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.tPackage, that.tPackage) &&
                Objects.equals(this.objects, that.objects) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.author, that.author) &&
                Objects.equals(this.version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tPackage, objects, name, author, version);
    }

    @Override
    public String toString() {
        return "EDiagramDto[" +
                "id=" + id + ", " +
                "tPackage=" + tPackage + ", " +
                "objects=" + objects + ", " +
                "name=" + name + ", " +
                "author=" + author + ", " +
                "version=" + version + ']';
    }

}
