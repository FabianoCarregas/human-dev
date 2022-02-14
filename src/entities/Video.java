package entities;

import validations.Validation;

public class Video {
    private Long id;
    private String videoUrl;
    private int videoTime;
    private String videoDescription;

    public Video(Long id,
                 String videoUrl,
                 int videoTime,
                 String videoDescription) {
        Validation.notNull("name", "The field name can not be null");
        this.id = id;
        this.videoUrl = videoUrl;
        this.videoTime = videoTime;
        this.videoDescription = videoDescription;
    }

    public Video(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Long getId() {
        return id;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public int getVideoTime() {
        return videoTime;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", videoUrl='" + videoUrl + '\'' +
                ", videoTime=" + videoTime +
                ", videoDescription='" + videoDescription + '\'' +
                '}';
    }
}