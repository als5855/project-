package com.korit.moa.moa.entity.user;

import com.korit.moa.moa.entity.recommendation.Recommendation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

@Entity
@Table(name = "Users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @Column(name = "user_id", updatable = false)
    private String userId;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Past
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @Column(name = "user_birth_date", nullable = false)
    private Date userBirthDate;

    @Column(name = "user_gender")
    @Enumerated(EnumType.STRING)
    private Gender userGender;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_nickname", nullable = false, unique = true)
    private String nickName;

    @Column(name = "hobby")
//    @ElementCollection(fetch = FetchType.EAGER)
    private String hobbies;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "region")
    @Enumerated(EnumType.STRING)
    private Region region;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Recommendation> recommendation = new ArrayList<>();
}
