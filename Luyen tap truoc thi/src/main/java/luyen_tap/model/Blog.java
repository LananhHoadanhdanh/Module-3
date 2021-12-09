package luyen_tap.model;

public class Blog {
    private int id;
    private String name;
    private String content;
    private int categoryId;

    public Blog() {
    }

    public Blog(String name, String content, int categoryId) {
        this.name = name;
        this.content = content;
        this.categoryId = categoryId;
    }

    public Blog(int id, String name, String content, int categoryId) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
