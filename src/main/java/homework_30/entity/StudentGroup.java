package homework_30.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups_of_students")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer ID;

    @Column(name = "group_code")
    private String group_code;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "studentGroup")
    private List<Student> studentsInGroup;

    @Override
    public String toString() {
        return "(ID=" + ID + ", group_code='" + group_code + '\'' + ')';
    }
}
