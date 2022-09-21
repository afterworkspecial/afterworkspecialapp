package com.afterworkspecial.afterworkspecial.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "whatsup")
public class Whatsup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;
    private String text;
    private int likes;
    private LocalDateTime createdDate;
    @OneToMany
    private List<Comment> commentsList;

    public Whatsup() {

    }
    public Whatsup(User user, String text, int likes, LocalDateTime createdDate) {
        this.user = user;
        this.text = text;
        this.likes = likes;
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<Comment> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Whatsup)) return false;

        Whatsup whatsup = (Whatsup) o;

        if (likes != whatsup.likes) return false;
        if (id != null ? !id.equals(whatsup.id) : whatsup.id != null) return false;
        if (user != null ? !user.equals(whatsup.user) : whatsup.user != null) return false;
        if (text != null ? !text.equals(whatsup.text) : whatsup.text != null) return false;
        if (createdDate != null ? !createdDate.equals(whatsup.createdDate) : whatsup.createdDate != null) return false;
        return commentsList != null ? commentsList.equals(whatsup.commentsList) : whatsup.commentsList == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + likes;
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (commentsList != null ? commentsList.hashCode() : 0);
        return result;
    }
}
