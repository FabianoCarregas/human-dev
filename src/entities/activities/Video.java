package entities.activities;

import entities.Section;
import validations.CodePatternValidation;
import validations.Validation;

public class Video extends Activity{

    private String videoUrl;
    private int videoTime;
    private String videoDescription;

    public Video(String title,
                 String code,
                 Section section,
                 String videoUrl,
                 int videoTime) {
        super(title, code, section);
        CodePatternValidation.validUrl(videoUrl);
        this.videoUrl = videoUrl;
        Validation.validNumberHours(videoTime);
        this.videoTime = videoTime;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public int getVideoTime() {
        return videoTime;
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