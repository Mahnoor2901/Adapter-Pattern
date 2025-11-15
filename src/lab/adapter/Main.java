package lab.adapter;
public class Main {
public static void main(String[] args) {
System.out.println("=== Adapter Pattern Demo: Payment Integration ===");
// legacy service (pretend this is from an external jar)
LegacyPaymentService legacyService = new LegacyPaymentService("MERCHANT-123");
// adapter exposes the new interface
PaymentGateway gateway = new PaymentAdapter(legacyService);
// Application code uses PaymentGateway (dollars)
gateway.pay(19.99); // sample 1
gateway.pay(5.0); // sample 2
gateway.pay(0.555); // sample to test rounding behavior (should become 56cents)
gateway.refund(9.50);
System.out.println();
System.out.println();

  System.out.println("\n\n=== Adapter Pattern Demo: Payment Integration with Logging ===");

        // Wrap the adapter with logging
        PaymentGateway loggingGateway = new LoggingPaymentGateway(gateway);

        // Application code uses PaymentGateway (dollars)
        loggingGateway.pay(19.99);  // sample 1
        loggingGateway.pay(5.0);    // sample 2
        loggingGateway.pay(0.555);  // sample to test rounding behavior (should become 56cents)
        
        // Now calling refund
        loggingGateway.refund(9.50); // Testing refund functionality
    
}
}