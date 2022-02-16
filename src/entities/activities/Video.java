package entities.activities;

import entities.Section;
import validations.CodePatternValidation;

public class Video extends Activity{
    private Long id;
    private String videoUrl;
    private int videoTime;
    private String videoDescription;

    public Video(String title,
                 String code,
                 Section section,
                 String videoUrl,
                 int videoTime,
                 String videoDescription) {
        super(title, code, section);
        CodePatternValidation.isValidUrl(videoUrl, "The code pattern accept only low case characters, numbers and hyphen");
        this.videoUrl = videoUrl;
        this.videoTime = videoTime;
        this.videoDescription = videoDescription;
    }

    public Video(String title,
                 String code,
                 boolean activityStatus,
                 int ordination,
                 Section section,
                 String videoUrl,
                 int videoTime,
                 String videoDescription) {
        super(title, code, activityStatus, ordination,section);
        CodePatternValidation.isValidUrl(videoUrl, "The code pattern accept only low case characters, numbers and hyphen");
        this.videoUrl = videoUrl;
        this.videoTime = videoTime;
        this.videoDescription = videoDescription;
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
                "videoUrl='" + videoUrl + '\'' +
                ", videoTime=" + videoTime +
                ", videoDescription='" + videoDescription + '\'' +
                '}';
    }
}