package com.example.mreview.repository;

import com.example.mreview.entity.Movie;
import com.example.mreview.entity.MovieImage;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieImageRepository movieImageRepository;

    @Test
    public void insert1() {
        Movie movie = Movie.builder().title("MOVIE").build();
        movieRepository.save(movie);
    }

    @Test
    public void insert2() {
        Movie movie = Movie.builder().title("MOVIE").build();
        movieRepository.save(movie);

        MovieImage movieImage = MovieImage.builder()
                .uuid(UUID.randomUUID().toString())
                .movie(movie)
                .imgName("test" + 1 + ".jpg").build();

        movieImageRepository.save(movieImage);
    }

    @Test
    @Commit
    @Transactional
    public void insertMovies() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Movie movie = Movie.builder()
                    .title("Movie....." + i).build();

            System.out.println("--------------------------");

            movieRepository.save(movie);

            int count = (int) (Math.random() * 5) + 1; // 1, 2, 3, 4

            for (int j = 0; j < count; j++) {
                MovieImage movieImage = MovieImage.builder()
                        .uuid(UUID.randomUUID().toString())
                        .movie(movie)
                        .imgName("test" + j + ".jpg").build();

                movieImageRepository.save(movieImage);
            }

            System.out.println("--------------------------");

        });
    }
}
