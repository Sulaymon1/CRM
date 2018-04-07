package com.skyforce.models;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Id;

/**
 * Created by Sulaymon on 30.03.2018.
 */
@Setter
@Getter
@Builder
@ToString
@Entity
@Table(name = "image")
@AllArgsConstructor
@NoArgsConstructor
public class ImageInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long profileId;
    @Transient
    private String originalFileName;
    private String storageFileName;
    private String url;
    @Transient
    private long size;
    private String type;
}
