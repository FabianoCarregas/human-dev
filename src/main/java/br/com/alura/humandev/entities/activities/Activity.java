package br.com.alura.humandev.entities.activities;
import br.com.alura.humandev.entities.Section;
import javax.persistence.*;


@Entity
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

    public Activity() {
    }

    public Activity(String title,
                    String code,
                    Section section) {
        this.title = title;
        this.code = code;
        this.section = section;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", activityStatus=" + status +
                ", ordination=" + ordination +
                ", section=" + section +
                '}';
    }

}