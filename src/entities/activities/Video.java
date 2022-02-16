package entities.activities;

import entities.Section;
import validations.Validation;
import static validations.CodePatternValidation.validUrl;

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
        validUrl(videoUrl);
        this.videoUrl = videoUrl;
        Validation.validNumberHours(videoTime);
        this.videoTime = videoTime;
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