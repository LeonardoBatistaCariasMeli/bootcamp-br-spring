package br.com.digitalhouse.bootcampbrspring.usecase.model.response;

public class CashBoxResponse {
    private Double totalCash;

    public CashBoxResponse(Double totalCash) {
        this.totalCash = totalCash;
    }

    public Double getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(Double totalCash) {
        this.totalCash = totalCash;
    }
}
