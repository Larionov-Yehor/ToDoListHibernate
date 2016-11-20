package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by employee on 11/18/16.
 */

@Entity
@Table (name = "tasks", catalog = "todolist", uniqueConstraints = {
        @UniqueConstraint(columnNames = "task_id")
})
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private Integer id;

    @Column(name = "task_name")
    private String name;

    @Column(name = "task_description")
    private String description;

    @Column(name = "task_state")
    private Boolean state = false;

    @Temporal(TemporalType.DATE)
    @Column(name = "task_due_date")
    private Date dueDate;

    @Column (name = "list_id")
   // @ManyToOne(fetch = FetchType.LAZY)
    private Integer listId;

    public Task(){}

    public Task(String name, Date dueDate, Integer listId) {
        this.name = name;
        this.dueDate = dueDate;
        this.listId = listId;
    }


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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getState() {    return state;}
    public void setState(Boolean state) {
        this.state = state; }

    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date date) {
        this.dueDate = date;
    }

  // @ManyToOne(fetch = FetchType.LAZY, m)
    public Integer getListId() {
        return listId;
    }
    public void setListId(Integer listId) {
        this.listId = listId;
    }
}
