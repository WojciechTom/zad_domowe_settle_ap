package zad_dom25_settle.zad_dom25_settle.model;

public enum CurrencyEnum {
    PLN("PLN"),
    USD("USD"),
    EUR("EUR"),
    GBP("GBP"),
    CZK("CZK");

    private String cur;

    CurrencyEnum(String cur) {
        this.cur = cur;
    }

    public String getCur() {
        return cur;
    }
}
