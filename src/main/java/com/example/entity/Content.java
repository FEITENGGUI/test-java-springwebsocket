package com.example.entity;

public class Content {
    private Integer contentId;
    private String contentName;
    private String content;
    private String createDate;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Content{");
        sb.append("contentId=").append(contentId);
        sb.append(", contentName='").append(contentName).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", createDate='").append(createDate).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getContentId() {
        return contentId;
    }

    public Content setContentId(Integer contentId) {
        this.contentId = contentId;
        return this;
    }

    public String getContentName() {
        return contentName;
    }

    public Content setContentName(String contentName) {
        this.contentName = contentName;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Content setContent(String content) {
        this.content = content;
        return this;
    }

    public String getCreateDate() {
        return createDate;
    }

    public Content setCreateDate(String createDate) {
        this.createDate = createDate;
        return this;
    }
}
