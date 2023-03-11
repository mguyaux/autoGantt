package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Task.
 */
@Entity
@Table(name = "task")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "summary", length = 500, nullable = false)
    private String summary;

    @Column(name = "priority")
    private Integer priority;

    @ManyToOne
    @JsonIgnoreProperties(value = { "tasks" }, allowSetters = true)
    private Project project;

    @ManyToMany
    @JoinTable(
        name = "rel_task__require",
        joinColumns = @JoinColumn(name = "task_id"),
        inverseJoinColumns = @JoinColumn(name = "require_id")
    )
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "project", "requires", "isRequiredBies" }, allowSetters = true)
    private Set<Task> requires = new HashSet<>();

    @ManyToMany(mappedBy = "requires")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "project", "requires", "isRequiredBies" }, allowSetters = true)
    private Set<Task> isRequiredBies = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Task id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return this.summary;
    }

    public Task summary(String summary) {
        this.setSummary(summary);
        return this;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public Task priority(Integer priority) {
        this.setPriority(priority);
        return this;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Task project(Project project) {
        this.setProject(project);
        return this;
    }

    public Set<Task> getRequires() {
        return this.requires;
    }

    public void setRequires(Set<Task> tasks) {
        this.requires = tasks;
    }

    public Task requires(Set<Task> tasks) {
        this.setRequires(tasks);
        return this;
    }

    public Task addRequire(Task task) {
        this.requires.add(task);
        task.getIsRequiredBies().add(this);
        return this;
    }

    public Task removeRequire(Task task) {
        this.requires.remove(task);
        task.getIsRequiredBies().remove(this);
        return this;
    }

    public Set<Task> getIsRequiredBies() {
        return this.isRequiredBies;
    }

    public void setIsRequiredBies(Set<Task> tasks) {
        if (this.isRequiredBies != null) {
            this.isRequiredBies.forEach(i -> i.removeRequire(this));
        }
        if (tasks != null) {
            tasks.forEach(i -> i.addRequire(this));
        }
        this.isRequiredBies = tasks;
    }

    public Task isRequiredBies(Set<Task> tasks) {
        this.setIsRequiredBies(tasks);
        return this;
    }

    public Task addIsRequiredBy(Task task) {
        this.isRequiredBies.add(task);
        task.getRequires().add(this);
        return this;
    }

    public Task removeIsRequiredBy(Task task) {
        this.isRequiredBies.remove(task);
        task.getRequires().remove(this);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Task)) {
            return false;
        }
        return id != null && id.equals(((Task) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Task{" +
            "id=" + getId() +
            ", summary='" + getSummary() + "'" +
            ", priority=" + getPriority() +
            "}";
    }
}
