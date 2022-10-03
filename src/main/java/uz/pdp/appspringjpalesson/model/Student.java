package uz.pdp.appspringjpalesson.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // DB da shu classni table ko'rinishida olishga harakat qiladi
public class Student {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // serial type qilib beradi
    private Integer id;
    @Column(nullable = false) // Ustun(not null) sifatida ko'radi
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true) // Ustun(not null, unique key) sifatida ko'radi
    private String phoneNumber;
}
