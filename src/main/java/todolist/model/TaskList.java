package todolist.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    @Column(name = "tasklist_name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    @Cascade(CascadeType.DELETE)
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
