package com.github.tr1cks.tasker.domain;

import com.google.common.base.Objects;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Project implements DomainObj {
    @NotNull @Size(min = 32, max = 32)
    private String id;

    @NotNull @Size(min = 3, max = 30)
    private String name;
    @Size(min = 10, max = 200)
    private @Nullable String description;

    public Project() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public @Nullable String getDescription() { return description; }
    public void setDescription(@Nullable String description) { this.description = description; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;

        Project project = (Project) o;

        if (description != null ? !description.equals(project.description) : project.description != null) return false;
        if (!id.equals(project.id)) return false;
        if (!name.equals(project.name)) return false;

        return true;
    }

    @Override public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("description", description)
                .toString();
    }
}