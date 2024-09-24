package co.musicshop.fis.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity

@Table(name = "song")

public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")

    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String artist;

    @NonNull
    private String genre;

    @NonNull
    private Integer year;

    @NonNull
    private String album;

    @Column(name = "album_cover")
    @NonNull
    private String albumCover;

    @NonNull
    private String duration;
}
