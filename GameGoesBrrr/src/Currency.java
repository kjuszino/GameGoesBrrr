public class Currency {
    private double holder;
    private int single;
    private int thousands;
    private int millions;

    public Currency() {

    }

    public void addCurrency(int amount) {
        if (amount < 1000 && amount > 0) {
            this.single += amount;
        }

        if (amount < 1000000 && amount >= 1000) {
            this.thousands += amount / 1000;
        }

        if (amount < 1000000000 && amount > 999999) {
            this.millions += amount / 1000000;
        }

    }

    public void removeCurrency(int amount) {
        if (this.single > 0 && this.single >= amount) {
            this.single -= amount;
        }

        if (this.thousands > 0 && this.thousands * 1000 >= amount) {
            this.single = 1000 - amount;
            this.thousands --;
        }

        if (this.millions > 0 && this.millions * 1000000 >= amount) {
            if (amount >= 999001 && amount <= 999999) {
                this.single = 1000000 - amount;
                this.millions --;
            }

            if (amount >= 1 && amount <= 999000) {
                this.thousands = (1000000 - amount) / 1000;
                this.holder = (1000000 - amount) - this.thousands * 1000;
                this.millions --;
                this.single += this.holder;
            }
        }

    }

    public String getCurrency() {
        return "Single: " + this.single + "\nThousands: " + this.thousands + "\nMillions: " + this.millions;
    }
    @Override
    public String toString() {
        return null;
    }
}
