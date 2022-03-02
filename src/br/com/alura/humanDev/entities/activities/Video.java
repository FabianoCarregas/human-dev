package br.com.alura.humanDev.entities.activities;

import br.com.alura.humanDev.entities.Section;

import static br.com.alura.humanDev.validations.CodePatternValidation.validUrl;
import static br.com.alura.humanDev.validations.Validation.validNumberHours;

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
        validNumberHours(videoTime);
        this.videoUrl = videoUrl;
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