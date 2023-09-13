/**
 * This class represents a credit card payment.
 * It holds the card number as an int[].
 * It verifies three properties (in this order):
 * 1. That the int[] only holds ints in the following range: [0,9]
 * 2. That the length of the int[] is exactly 6
 * 3. That the check digit is correct
 *
 * The check digit is the last digit of the card number that verifies
 * that the other 5 digits are correct. This number is computed with
 * the Luhn algorithm (https://en.wikipedia.org/wiki/Luhn_algorithm).
 */

public class CreditCard extends Payment {
    private final int[] cardNumber;

    public CreditCard(double amount, int[] cardNumber) throws IllegalArgumentException {
        super(amount);
        this.cardNumber = cardNumber;
        /** TODO: Perform the following verification:
               1. Use verifyCardDigits to check that all ints in card number
                  are in the following range: [0,9]. If not then throw an IllegalArgumentException
                  with the following String: "The card number must consist of numbers in the following range: [0,9]"
               2. Check that the card number length is exactly 6. If not then throw an IllegalArgumentException
                  with the following String: "The card number must be exactly 6 digits"
               3. Use verify to check that the check digit is correct in the card number. If it is not VALID then
                throw an IllegalArgumentException with the toString of verification.
         */

        //1.
        if (verifyCardDigits() == false) {
            throw new IllegalArgumentException("The card number must consist of numbers in the following range: [0,9]");
        }

        //2.
        else if (cardNumber.length > 6 || cardNumber.length < 6) {
            throw new IllegalArgumentException("The card number must be exactly 6 digits");
        }

        //3.
        else if (verify() != PaymentVerification.VALID) {
            throw new IllegalArgumentException(PaymentVerification.INVALIDCARDNUMBER.toString());
        }
    }


    /**
     * This function verifies that the cardNumber only has
     * ints in the following range: [0,9].
     *
     * @return True if all ints are in the above range false otherwise.
     */
    private boolean verifyCardDigits() {
        //TODO: Fill in the logic given above, replace return false with your code.
        for (int i = 0; i < cardNumber.length; i++) {
            if (cardNumber[i] >= 0 && cardNumber[i] <= 9) {
                return true;
            }
        }
        return false;
    }

    /**
     * This function sums the digits of the given int.
     * For example if given 123 it would return 6.
     *
     * @param num Int to sum the digits of
     * @return Sum of the digits of the given int
     */
    private int sumDigits(int num) {
        //TODO: Fill in the logic given above, replace return 0 with your code.
        int sum = 0;
        while (num > 0) {
            // starting from the last digit
            sum += (num % 10);
            // now declaring number by reducing one at a time
            num = num / 10;
        }
        return sum;
    }

    /**
     * This function verifies that cardNumber's check
     * digit is correct using the Luhn algorithm.
     *
     * @return VALID if the check digit is correct, INVALIDCARDNUMBER otherwise
     */
    @Override
    protected PaymentVerification verify() {
        //TODO: Fill in the logic given above, replace return null with your code.

        //3.
        // for checking the check-digit we have
        // Step : we must start from right side of the number
        // we multiply the first one with 2 and then skip one and do the same
        // if the multiplied number is greater than 9 then we add whatever the two digits are
        // we find the sum value
        // we use the formula : (10 - (sum mod 10) mod10 ) --- to find the last digit
        // then we verify if its Valid or not

        int sum = 0;
        int check = 0;
        int after_sum = 0;
        for (int j = 4; j >= 0; j = j - 2) {
            check += (cardNumber[j] * 2);
            if (check > 9) {
                sum += (check % 10) + 1;
            } else {
                sum += check;
            }
            check = 0;
            if (j == 0) {
                break;
            }
            after_sum += cardNumber[j - 1];
        }
        sum = sum + after_sum;
        int formula = ((10 - (sum % 10)) % 10);
        if (formula == cardNumber[5]) {
            return PaymentVerification.VALID;
        }
        return PaymentVerification.INVALIDCARDNUMBER;
    }

    /**
     * This function checks if the cardNumber of this matches the card
     * number of o.
     *
     * @param o Other CreditCard to check if equal to this
     * @return True if o's cardNumber is equal to this.cardNumber
     */
    @Override
    public boolean equals(Object o) {
        //TODO: Fill in the logic given above, replace return false with your code.
        if (o == cardNumber) {
            return true;
        }
        return false;
    }

    /**
     * This function converts this to a string
     *
     * @return "Valid Credit Card Number: $CARDNUMBER, amount: {@link #amount}"
     */
    @Override
    public String toString() {
        //TODO: Fill in the logic given above, replace return null with your code.
        String credit_card = " ";
        for(int elment : cardNumber){
            credit_card += String.valueOf(elment);
        }
        return "Valid Credit Card Number:" + credit_card + ", " + "amount: " + amount;
    }
}

