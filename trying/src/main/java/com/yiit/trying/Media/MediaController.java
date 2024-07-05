package com.yiit.trying.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080") // Unity uygulamanızın çalıştığı port numarasını buraya yazın
@RestController
@RequestMapping("/api/v1/media")
public class MediaController { // API layer

    @Autowired
    private StudentServices studentServices;

    public MediaController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping
    public List<media> getMedias() {
        return studentServices.getMedias();
    }

    @PostMapping
    public void registerNewMedia(@RequestBody media media) {
        studentServices.addNewMedia(media);
    }

    @DeleteMapping(path = "{mediaId}")
    public void deleteMedia(@PathVariable("mediaId") Long mediaId) {
        studentServices.deleteMedia(mediaId);
    }

    @PutMapping(path = "{mediaId}")
    public void updateMedia(
            @PathVariable("mediaId") Long mediaId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) int point) {
        studentServices.updateMedia(mediaId, name, point);
    }
}





/*package com.yiit.trying.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/media")
public class MediaController {//Api layer
    @Autowired
    private StudentServices studentServices;

    public MediaController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }


    @GetMapping
    public List<media> getMedias(){
        return studentServices.getMedias();
    }
    @PostMapping
    public void registerNewMedia(@RequestBody  media media){
        studentServices.addNewMedia(media);
    }
    @DeleteMapping(path = "{mediaId}")
    public void deleteMedia(@PathVariable("mediaId") Long mediaId){
        studentServices.deleteMedia(mediaId);
    }
    @PutMapping(path="{mediaId}")
    public void updateMedia(@PathVariable("mediaId") Long mediaId,
                            @RequestParam(required=false) String name,
                            @RequestParam(required=false) int point){
        studentServices.updateMedia(mediaId, name, point);

    }
}*/
