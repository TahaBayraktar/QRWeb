package com.example.prototip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/qr")
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;
    @Autowired
    private UserRepository UserRepository;
    
    

    // QR kod oluştur ve `qr.html` sayfasına QR kod ekle
    @GetMapping("/generate")
    public String generateQRCode(Model model) {
        String qrUrl = qrCodeService.generateQRCode();
        model.addAttribute("qrUrl", qrUrl);
        return "qr"; // QR kodu içeren sayfayı döndür
    }

    // QR kod doğrulama ve yönlendirme
    @GetMapping("/scan")
    public String scanQRCode(@RequestParam String qrText) {
        boolean isValid = qrCodeService.validateQRCode(qrText);
        if (isValid) {
        	LoginController logincontroller;
        	
        	
            return "library-map"; // QR kod geçerliyse kütüphane krokisi sayfasına yönlendir
        } else {
            return "redirect:/error"; // QR kod geçersizse hata sayfasına yönlendir
        }
    }

    @GetMapping("/library-map")
    public String showLibraryMap() {
        return "library-map";
    }

    @GetMapping("/error")
    public String showErrorPage() {
        return "error";
    }
}