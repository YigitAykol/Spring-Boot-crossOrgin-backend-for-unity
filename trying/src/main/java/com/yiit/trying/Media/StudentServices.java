package com.yiit.trying.Media;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServices {

    private final MediaRepository mediaRepository;

    @Autowired
    public StudentServices(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public List<media> getMedias(){
        return mediaRepository.findAll();
    }

    public void addNewMedia(media media) {
        Optional<media> mediaOptional = mediaRepository.findMediaByName(media.getName());
        if(mediaOptional.isPresent()){
            throw new IllegalStateException("Media previously entered");
        }
        mediaRepository.save(media);
    }

    public void deleteMedia(Long mediaId) {
        boolean exits = mediaRepository.existsById(mediaId);
        if(!exits){
            throw new IllegalStateException("media with id" + mediaId +
                                                "does not exits");
        }
        mediaRepository.deleteById(mediaId);
    }
    @Transactional
    public void updateMedia(Long mediaId, String name, int point) {
        media media = mediaRepository.findById(mediaId).orElseThrow(()->new IllegalStateException(
                            "student with id" + mediaId +"does not exits"
                            ));

        if(name != null&&  name.length()>0 &&
        !Objects.equals(media.getName(), name)){
            Optional<media> mediaOptional = mediaRepository.findMediaByName(name);
            if(mediaOptional.isPresent()){
                throw new IllegalStateException("Its allready entered");
            }
            media.setName(name);
        }

        if(!Objects.equals(media.getPoint(), point)){
            media.setPoint(point);
        }
    }
}
