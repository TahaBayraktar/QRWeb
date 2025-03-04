package com.example.prototip;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class QRCodeService {

    @Autowired
    private QRCodeRepository qrCodeRepository;

    // Bilgisayarın manuel IP adresi
    private static final String SERVER_IP = "https://qrweb-wde7.onrender.com"; // BURAYA BİLGİSAYARININ IP ADRESİNİ YAZ

    // QR Kodu oluştur ve veritabanına kaydet
    public String generateQRCode() {
        String qrText = UUID.randomUUID().toString(); // Benzersiz bir QR kod metni üret

        // QR kodun içine IP adresi ile tam URL ekleyelim
        String qrUrl = SERVER_IP +"/api/qr/scan?qrText=" + qrText;
        System.out.println("Oluşturulan QR Kodu URL: " + qrUrl); // Terminalde görmek için yazdır

        // QR kodu veritabanına kaydet
        QRCode qrCode = new QRCode();
        qrCode.setQrText(qrText);
        qrCodeRepository.save(qrCode);

        return qrUrl;
    }

    // QR Kodu doğrulama ve tek kullanımlık yapma
    public boolean validateQRCode(String qrText) {
        Optional<QRCode> qrCode = qrCodeRepository.findByQrText(qrText);
        if (qrCode.isPresent() && !qrCode.get().isUsed()) {
            qrCode.get().setUsed(true); // QR kodu kullanıldı olarak işaretle
            qrCodeRepository.save(qrCode.get());
            return true; // QR kod geçerliydi, artık kullanıldı
        }
        return false; // QR kod geçerli değil veya zaten kullanılmış
    }
}
