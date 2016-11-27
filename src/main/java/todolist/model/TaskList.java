package todolist.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by employee on 11/18/16.
 */
@Entity
@Table(name = "lists")

public class TaskList {
    @Id
    @Column(name = "list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "list_name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "listOfTasks")
    private List<Task> coupledTasks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getCoupledTasks() {
        return coupledTasks;
    }

    public void setCoupledTasks(List<Task> coupledTasks) {
        this.coupledTasks = coupledTasks;
    }
}
