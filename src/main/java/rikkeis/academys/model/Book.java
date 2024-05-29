package rikkeis.academys.model;

public class Book {
    private Integer id;
    private Integer category_id;
    private String name;
    private double price;
    private int stock;
    private int totalPages;
    private int yearCrated;
    private String author;
    private boolean status;

    public Book(Integer id, Integer categoryId, String name, double price, int stock, int totalPages, int yearCrated, String author, boolean status) {
        this.id = id;
        this.category_id = categoryId;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.totalPages = totalPages;
        this.yearCrated = yearCrated;
        this.author = author;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getYearCrated() {
        return yearCrated;
    }

    public void setYearCreated(int yearCrated) {
        this.yearCrated = yearCrated;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", totalPages=" + totalPages +
                ", yearCrated=" + yearCrated +
                ", author='" + author + '\'' +
                ", status=" + status +
                '}';
    }
}
