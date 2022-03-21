package br.com.alura.humanDev.entities.activities;

import br.com.alura.humanDev.entities.Section;

import javax.persistence.*;

import static br.com.alura.humanDev.validations.CodePatternValidation.validUrl;
import static br.com.alura.humanDev.validations.Validation.validNumberHours;

@Entity
@DiscriminatorValue("video")
public class Video extends Activity{

    private Long id;
    @Column(name = "video_url")
    private String videoUrl;
    @Column(columnDefinition = "SMALLINT",name = "video_time")
    private int videoTime;
    @Column(name = "video_description")
    private String videoDescription;

    public Video() {
    }

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