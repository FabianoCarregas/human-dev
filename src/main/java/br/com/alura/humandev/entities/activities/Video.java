package br.com.alura.humandev.entities.activities;
import br.com.alura.humandev.entities.Section;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Video extends Activity{

    private Long id;
    private String videoUrl;
    private int videoTime;
    private String videoDescription;

    public Video() {
    }

    public Video(String title,
                 String code,
                 Section section,
                 String videoUrl,
                 int videoTime) {
        super(title, code, section);
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