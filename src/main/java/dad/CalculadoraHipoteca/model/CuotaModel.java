package dad.CalculadoraHipoteca.model;

import dad.CalculadoraHipoteca.api.Cuota;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CuotaModel {

    private final IntegerProperty año = new SimpleIntegerProperty();
    private final IntegerProperty mes = new SimpleIntegerProperty();
    private final DoubleProperty capitalInicial = new SimpleDoubleProperty();
    private final DoubleProperty intereses = new SimpleDoubleProperty();
    private final DoubleProperty capitalAmortizado = new SimpleDoubleProperty();
    private final DoubleProperty cuotas = new SimpleDoubleProperty();
    private final DoubleProperty capitalPendiente = new SimpleDoubleProperty();

    public CuotaModel(Cuota cuota) {
        año.set(cuota.getAnio());
        mes.set(cuota.getMes());
        capitalInicial.set(cuota.getCapitalInicial());
        intereses.set(cuota.getIntereses());
        capitalAmortizado.set(cuota.getCapitalAmortizado());
        cuotas.set(cuota.getCuota());
        capitalPendiente.set(cuota.getCapitalPendiente());
    }

    public int getAño() {
        return año.get();
    }

    public IntegerProperty añoProperty() {
        return año;
    }

    public void setAño(int año) {
        this.año.set(año);
    }

    public int getMes() {
        return mes.get();
    }

    public IntegerProperty mesProperty() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes.set(mes);
    }

    public double getCapitalInicial() {
        return capitalInicial.get();
    }

    public DoubleProperty capitalInicialProperty() {
        return capitalInicial;
    }

    public void setCapitalInicial(double capitalInicial) {
        this.capitalInicial.set(capitalInicial);
    }

    public double getIntereses() {
        return intereses.get();
    }

    public DoubleProperty interesesProperty() {
        return intereses;
    }

    public void setIntereses(double intereses) {
        this.intereses.set(intereses);
    }

    public double getCapitalAmortizado() {
        return capitalAmortizado.get();
    }

    public DoubleProperty capitalAmortizadoProperty() {
        return capitalAmortizado;
    }

    public void setCapitalAmortizado(double capitalAmortizado) {
        this.capitalAmortizado.set(capitalAmortizado);
    }

    public double getCuotas() {
        return cuotas.get();
    }

    public DoubleProperty cuotasProperty() {
        return cuotas;
    }

    public void setCuotas(double cuotas) {
        this.cuotas.set(cuotas);
    }

    public double getCapitalPendiente() {
        return capitalPendiente.get();
    }

    public DoubleProperty capitalPendienteProperty() {
        return capitalPendiente;
    }

    public void setCapitalPendiente(double capitalPendiente) {
        this.capitalPendiente.set(capitalPendiente);
    }
}
