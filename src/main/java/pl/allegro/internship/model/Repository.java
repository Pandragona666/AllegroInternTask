package pl.allegro.internship.model;

import java.time.LocalDateTime;

public class Repository {

    private long id;
    private String name;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private LocalDateTime pushed_at;

    public Repository() {
    }

    public Repository(long id, String name, LocalDateTime created_at, LocalDateTime updated_at, LocalDateTime pushed_at) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.pushed_at = pushed_at;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", pushed_at=" + pushed_at +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public LocalDateTime getPushed_at() {
        return pushed_at;
    }

    public void setPushed_at(LocalDateTime pushed_at) {
        this.pushed_at = pushed_at;
    }
}
