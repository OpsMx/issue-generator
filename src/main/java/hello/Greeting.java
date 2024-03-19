package hello;

public class Greeting {
    

    private final long id;
    private final String content;

    public Greeting(long id, String content) {  
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
