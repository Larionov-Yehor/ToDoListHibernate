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
public class Task {

    private Integer id;
    private String name;
    private String description;
    private Boolean state = false;
    private Date date;
    private Integer listId;

    public Task(){}

    public Task(String name, Date date, Integer listId) {
        this.name = name;
        this.date = date;
        this.listId = listId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "task_name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "task_description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "task_state")
    public Boolean getState() {    return state;}
    public void setState(Boolean state) {
        this.state = state; }

    @Temporal(TemporalType.DATE)
    @Column(name = "task_due_date")
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "list_id")
   // @OneToMany(mappedBy = "list_id", fetch = FetchType.LAZY)
    public Integer getListId() {
        return listId;
    }
    public void setListId(Integer listId) {
        this.listId = listId;
    }
}
