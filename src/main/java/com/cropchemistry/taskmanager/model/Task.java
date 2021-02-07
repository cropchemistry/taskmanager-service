package com.cropchemistry.taskmanager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Getter
@Setter
@NoArgsConstructor
public class Task {
    private String id;
    private String title;
    private String description;
}
