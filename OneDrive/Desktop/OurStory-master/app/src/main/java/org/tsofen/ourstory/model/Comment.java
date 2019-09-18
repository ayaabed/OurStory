package org.tsofen.ourstory.model;
import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.tsofen.ourstory.model.Memory;
import org.tsofen.ourstory.model.api.User;

import java.io.Serializable;

public class Comment implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("createDate")
    @Expose
    private String createDate;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("user")
    @Expose
    private User user;    @SerializedName("memory")
    @Expose
    private Memory memory;
    private final static long serialVersionUID = -3866631551094469441L;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCreateDate() {
        return createDate;
    }
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
        public Memory getMemory() {
        return memory;
    }
    public void setMemory(Memory memory) {
        this.memory = memory;
    }

}