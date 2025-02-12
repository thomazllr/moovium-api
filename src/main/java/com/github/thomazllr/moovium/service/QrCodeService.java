package com.github.thomazllr.moovium.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.UUID;

@Service
public class QrCodeService {

    public String generateQRCode(UUID ticketId) {
        try {
            String qrContent = "https://localhost.com/tickets/" + ticketId.toString();

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(
                    qrContent,
                    BarcodeFormat.QR_CODE,
                    200,
                    200
            );

            BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(qrImage, "PNG", baos);
            byte[] imageBytes = baos.toByteArray();
            return Base64.getEncoder().encodeToString(imageBytes);

        } catch (Exception e) {
            throw new RuntimeException("Error generating QR Code", e);
        }
    }
}
