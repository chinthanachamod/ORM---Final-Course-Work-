package org.example.BO;

import org.example.DTO.PaymentDTO;

public interface PaymentBO extends SuperBO {
    public boolean save(PaymentDTO dto) throws Exception;

    public boolean update(PaymentDTO dto) throws Exception;

    public boolean delete(String ID)throws Exception;
}
