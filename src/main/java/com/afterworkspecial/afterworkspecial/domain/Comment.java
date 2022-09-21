package com.afterworkspecial.afterworkspecial.domain;

import javax.persistence.*;

@Entity(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @OneToOne
    private User _user;

    public Comment() {

    }
    public Comment(String text, User _user) {
        this.text = text;
        this._user = _user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User get_user() {
        return _user;
    }

    public void set_user(User _user) {
        this._user = _user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;

        Comment comment = (Comment) o;

        if (id != null ? !id.equals(comment.id) : comment.id != null) return false;
        if (text != null ? !text.equals(comment.text) : comment.text != null) return false;
        return _user != null ? _user.equals(comment._user) : comment._user == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (_user != null ? _user.hashCode() : 0);
        return result;
    }
}
