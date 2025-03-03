package com.example.prototip;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "qr_codes")
public class QRCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String qrText; // QR kodun içeriği (benzersiz)

    @Column(nullable = false)
    private boolean used = false; // QR kodun kullanılıp kullanılmadığını takip eder

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // QR kodun oluşturulma zamanı

    // Getter - Setter metotları
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getQrText() { return qrText; }
    public void setQrText(String qrText) { this.qrText = qrText; }

    public boolean isUsed() { return used; }
    public void setUsed(boolean used) { this.used = used; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}