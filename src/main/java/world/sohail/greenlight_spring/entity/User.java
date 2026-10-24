package world.sohail.greenlight_spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private OffsetDateTime createdAt;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(unique = true, nullable = false, columnDefinition = "CITEXT")
    private String email;

    @Column(name = "password_hash", nullable = false)
    private byte[] passwordHash;

    @Column(nullable = false)
    private boolean activated = false;

    @Version
    @Column(nullable = false)
    private Integer version;

    protected User() {}

    public User(String name, String email, byte[] passwordHash, boolean activated){
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.activated = activated;
    }

    public Long getId() {
        return id;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public boolean isActivated() {
        return activated;
    }

    public Integer getVersion() {
        return version;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
