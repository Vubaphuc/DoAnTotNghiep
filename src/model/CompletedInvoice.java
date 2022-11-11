package model;

import java.time.LocalDate;

public class CompletedInvoice {
    private Invoice invoice;
    private String status;
    private LocalDate dayCompleted;

    public CompletedInvoice(Invoice invoice, String status, LocalDate dayCompleted) {
        this.invoice = invoice;
        this.status = status;
        this.dayCompleted = dayCompleted;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDayCompleted() {
        return dayCompleted;
    }

    public void setDayCompleted(LocalDate dayCompleted) {
        this.dayCompleted = dayCompleted;
    }

    @Override
    public String toString() {
        System.out.printf("Hóa Đơn: %-s \n Trạng thái: %-s \n Ngày: %-s",invoice,status,dayCompleted);
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return "";
    }
}
