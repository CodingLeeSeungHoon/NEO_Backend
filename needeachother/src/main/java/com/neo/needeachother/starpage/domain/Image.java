package com.neo.needeachother.starpage.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {

    private String url;

    protected Image(String url){
        this.url = url;
    }

    public static Image ofDefaultProfileImage() {
        return new Image("Default Profile Image Link");
    }

    public static Image ofDefaultTopRepresentativeImage() {
        return new Image("Default Profile Image Link");
    }

    public static Image of(String url){
        return new Image(url);
    }
}
