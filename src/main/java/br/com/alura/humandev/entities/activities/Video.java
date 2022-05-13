package br.com.alura.humandev.entities.activities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;


@Entity
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Video extends Activity{

    private Long id;
    private String videoUrl;
    private int videoTime;
    private String videoDescription;

}