package controller.impl;

import model.dao.impl.AbstractGenericDaoImpl;
import model.dao.impl.PaymentTypeDaoImpl;
import model.entities.PaymentType;

public class PaymentTypeController extends AbstractGenericControllerImpl<PaymentType>{
    private final PaymentTypeDaoImpl paymentTypeDao = new PaymentTypeDaoImpl();

    @Override
    public AbstractGenericDaoImpl<PaymentType> getDao(){
        return paymentTypeDao;
    }
}
