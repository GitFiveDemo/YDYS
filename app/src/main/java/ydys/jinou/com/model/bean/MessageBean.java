package ydys.jinou.com.model.bean;

public class MessageBean {
    private String id,title,url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MessageBean(String id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }
}
