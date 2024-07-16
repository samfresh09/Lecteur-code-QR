package com.samfresh09.qrcodescanner.controller;

import com.samfresh09.qrcodescanner.service.Lecteur;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LecteurApi {
    private Lecteur lecteur;

    @GetMapping("/lire")
    public String lire() {
        return this.lecteur.lecteur();
    }
}
