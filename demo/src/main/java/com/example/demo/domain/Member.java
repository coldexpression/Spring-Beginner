package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // JPA가 관리하는 Entity 이다.
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //@Id: Primary KEY를 설정
                                                            //@GenerationType.IDENTITY: DB가 알아서 ID를 생성해주는 것
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
