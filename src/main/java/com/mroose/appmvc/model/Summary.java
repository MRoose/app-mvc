package com.mroose.appmvc.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "info")
@IdClass(com.mroose.appmvc.model.SummaryId.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Summary {
    @Id
    @Column(name = "username")
    @NonNull
    private String username;

    @Column(name = "fio")
    @NonNull
    private String fio;

    @Column(name = "city")
    @NonNull
    private String city;

    @Column(name = "position")
    @NonNull
    private String position;

    @Column(name = "salary")
    @NonNull
    private Integer salary;

    @Column(name = "age")
    @NonNull
    private Integer age;

    @Column(name = "experience")
    @NonNull
    private Integer experience;

    @Column(name = "employment_date")
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate employmentDate;
}