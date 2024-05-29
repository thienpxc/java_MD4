package rikkeis.academys.model;

public class Category {
    private Integer id;
    private String name;
    private boolean status;

    public Category() {

    }
    public Category(Integer id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
    //SET VA GET
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
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
