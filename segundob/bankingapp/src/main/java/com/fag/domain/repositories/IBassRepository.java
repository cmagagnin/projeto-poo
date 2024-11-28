package com.fag.domain.repositories;

import java.net.URISyntaxException;

import com.fag.domain.dto.BankslipDTO;

public interface IBassRepository {
    String consultarBoleto(String linhaDigitavel) throws URISyntaxException, Exception;
    String pagarBoleto(BankslipDTO dadosBoletoConsultado) throws Exception;
    String gerarQrCode(Double amount) throws Exception;
    
}