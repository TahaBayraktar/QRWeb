package com.example.prototip;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface QRCodeRepository extends JpaRepository<QRCode, Long> {
    Optional<QRCode> findByQrText(String qrText);
}
