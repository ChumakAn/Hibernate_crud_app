package model.dao.impl;

import model.entities.PaymentType;

public class PaymentTypeDao extends AbstractGenericDaoImpl<PaymentType>{
    public PaymentTypeDao(){
        super(PaymentType.class);
    }
}
