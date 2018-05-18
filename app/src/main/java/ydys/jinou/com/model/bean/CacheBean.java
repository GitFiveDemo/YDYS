package ydys.jinou.com.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * author: 晨光光
 * date : 2018/5/17 20:44
 */
@Entity
public class CacheBean {
    @Id(autoincrement = true)
    private Long id;
    private String json;
    private String name;
    @Generated(hash = 612454876)
    public CacheBean(Long id, String json, String name) {
        this.id = id;
        this.json = json;
        this.name = name;
    }
    @Generated(hash = 573552170)
    public CacheBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getJson() {
        return this.json;
    }
    public void setJson(String json) {
        this.json = json;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
