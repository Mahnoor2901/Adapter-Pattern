package lab.adapter;

/**
 * Logging decorator that logs timestamps and amounts before/after payment.
 */
public class LoggingPaymentGateway implements PaymentGateway {
    private final PaymentGateway wrapped;

    public LoggingPaymentGateway(PaymentGateway wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void pay(double dollars) {
        // Log before the payment
        System.out.println("[LoggingPaymentGateway] Timestamp: " + System.currentTimeMillis()
                + " | Attempting to pay: $" + dollars);
        
        // Call the actual payment method
        wrapped.pay(dollars);

        // Log after the payment
        System.out.println("[LoggingPaymentGateway] Timestamp: " + System.currentTimeMillis()
                + " | Payment of $" + dollars + " completed.");
    }

    @Override
    public void refund(double dollars) {
        // Log before the refund
        System.out.println("[LoggingPaymentGateway] Timestamp: " + System.currentTimeMillis()
                + " | Attempting to refund: $" + dollars);
        
        // Call the actual refund method
        wrapped.refund(dollars);

        // Log after the refund
        System.out.println("[LoggingPaymentGateway] Timestamp: " + System.currentTimeMillis()
                + " | Refund of $" + dollars + " completed.");
    }
}
