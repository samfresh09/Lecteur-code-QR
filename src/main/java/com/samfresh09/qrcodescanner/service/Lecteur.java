package com.samfresh09.qrcodescanner.service;

import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.qrcode.QRCodeReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
@Slf4j
public class Lecteur {
    public String lecteur() {
        Result result = null;
        try {
            // Charger l'image contenant le code QR
            BufferedImage bufferedImage = ImageIO.read(new File("C://projets/formations/objet.jpeg"));
            System.out.println("bufferedImage Text: " + bufferedImage);

            // Convertir l'image en une source de luminance
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            System.out.println("source Text: " + source);

            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            System.out.println("bitmap Text: " + bitmap);

            // Créer un lecteur de code QR
            QRCodeReader qrCodeReader = new QRCodeReader();
            result = qrCodeReader.decode(bitmap);

            // Afficher le texte contenu dans le code QR
            System.out.println("QR Code Text: " + result);
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement de l'image : " + e.getMessage());
        } catch (NotFoundException e) {
            System.err.println("Code QR non trouvé dans l'image : " + e.getMessage());
        } catch (ChecksumException e) {
            System.err.println("Erreur de somme de contrôle : " + e.getMessage());
        } catch (FormatException e) {
            System.err.println("Format du code QR non valide : " + e.getMessage());
        }


        return result.toString();
    }
}
