package com.yiit.trying.Media;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class MediaConfig {
    @Bean
    CommandLineRunner commandLineRunner(MediaRepository repository){


        return args ->{
            media fallot= new media(
                    "fallout",
                    "scifi-postApoc",
                    LocalDate.of(2024, Month.JANUARY,27),
                    7);


            media poorthings= new media(
                    "poorthings",
                    "scifi",
                    LocalDate.of(2024, Month.JANUARY,10),
                    10);

            repository.saveAll(
                    List.of(fallot, poorthings)
            );

       };
    }
}
