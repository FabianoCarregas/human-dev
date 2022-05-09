package br.com.alura.humandev.entities.activities;

import br.com.alura.humandev.entities.Section;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Explanation extends Activity {

    private Long id;
    private String activityExplanation;

}
