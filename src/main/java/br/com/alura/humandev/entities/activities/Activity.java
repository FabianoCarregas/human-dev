package br.com.alura.humandev.entities.activities;
import br.com.alura.humandev.entities.Section;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Activity {

    @Id
    private Long id;
    private String title;
    private String code;
    private boolean status;
    private int ordination;

    @ManyToOne(fetch = FetchType.LAZY)
    private Section section;

}