package com.example.appnomina;

import java.io.Serializable;
import java.util.Random;

public class Nomina implements Serializable {
    private int hrs;
    private int folio;
    private int hrsExtras;
    private float subtotal;
    private float iva;
    private float total;
    private float pago;

    private float pagoExtra;

    private int puesto;

    public Nomina(int hrs, int folio, int hrsExtras, float subtotal, float iva, float total, float pago, float pagoExtra, int puesto) {
        this.hrs = hrs;
        this.folio = folio;
        this.hrsExtras = hrsExtras;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.pago = pago;
        this.pagoExtra = pagoExtra;
        this.puesto = puesto;
    }

    public Nomina (){
        this.pagoExtra = 0;
        this.puesto = 0;
        this.pago = 0;
        this.hrs = 0;
        this.folio = 0;
        this.hrsExtras = 0;
        this.subtotal = 0f;
        this.iva = 0.16f;
        this.total = 0f;
    }

    public int getHrs() {
        return hrs;
    }

    public void setHrs(int hrs) {
        this.hrs = hrs;
    }

    public float getPagoExtra() {
        return pagoExtra;
    }

    public void setPagoExtra(float pagoExtra) {
        this.pagoExtra = pagoExtra;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public float getPago() {
        return pago;
    }

    public void setPago(float pago) {
        this.pago = pago;
    }


    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getHrsExtras() {
        return hrsExtras;
    }

    public void setHrsExtras(int hrsExtras) {
        this.hrsExtras = hrsExtras;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int genrarFolio() {
        Random r = new Random();
        int folio = r.nextInt(1000);
        return folio;
    }


    public float calcularSubTotal() {
        float sub = 0;

        switch (puesto) {
            case 1:
                this.pago = 50;
                this.pagoExtra = 100;
                sub += this.pago * this.hrs;
                sub += this.pagoExtra * this.hrsExtras;
                break;
            case 2:
                this.pago = 70;
                this.pagoExtra = 140;
                sub += this.pago * this.hrs;
                sub += this.pagoExtra * this.hrsExtras;
                break;
            case 3:
                this.pago = 100;
                this.pagoExtra = 200;
                sub += this.pago * this.hrs;
                sub += this.pagoExtra * this.hrsExtras;
                break;
        }

        return sub;
    }

    public float calcularImpuesto (){
        float impuesto = 0;

        impuesto = calcularSubTotal() * this.iva;
        return impuesto;
    }

    public float calcularTotal(){
        float total = 0;

        total = calcularSubTotal() - calcularImpuesto();
        return total;
    }


}
