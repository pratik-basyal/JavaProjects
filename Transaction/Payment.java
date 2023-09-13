/**
 * This abstract class represents a general payment.
 * It holds an amount which cannot be changed. It also
 * declares an abstract method to verify a given payment.
 * This function returns a PaymentVerification which is an
 * enum that informs the user of what went right or wrong
 * when verifying their payment.
 */
public abstract class Payment {
    protected final double amount;

    protected Payment(double amount) {
        this.amount = amount;
    }

    protected enum PaymentVerification {
        INVALIDCARDNUMBER("Your card number's check digit is invalid."),

        INVALIDSERIALNUMBER("Your cash's serial number is not between 1,000,000 and 10,000,000."),
        VALID("Your payment was approved.");

        private final String reason;

        PaymentVerification(String reason) {
            this.reason = reason;
        }

        @Override
        public String toString() {
            return reason;
        }
    }

    protected abstract PaymentVerification verify();
}
