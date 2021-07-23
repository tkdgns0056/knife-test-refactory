package kr.kassadin.knife.vo;

public class PayInfoDTO {
   
    private int paymentId;
    
    private int cardNumber;

    // Getter, Setter
    
    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
    
    // equals() PayInfo
    public boolean equals(Object o) {
        if(o instanceof PayInfoDTO) {
            PayInfoDTO p = (PayInfoDTO)o;
            if(paymentId == p.paymentId) {
                return true;
            }
        }        
        return false;
    }

}