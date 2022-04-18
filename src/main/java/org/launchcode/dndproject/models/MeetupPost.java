package org.launchcode.dndproject.models;


import javax.persistence.Entity;

@Entity
public class MeetupPost extends AbstractEntity{

    String postTitle;
    String postBody;

    public MeetupPost() {
    }

    public MeetupPost(String postTitle, String postBody) {
        this.postTitle = postTitle;
        this.postBody = postBody;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }
}
