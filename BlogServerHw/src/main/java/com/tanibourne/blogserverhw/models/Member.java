package com.tanibourne.blogserverhw.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "members")
@NoArgsConstructor
public class Member extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;
    @JsonIgnore
    @Column(nullable = false)
    private String psswordConfirm;


    public Member(String nickname,String password,String psswordConfirm ){
        this.nickname = nickname;
        this.password = password;
        this.psswordConfirm = psswordConfirm;
    }

}
