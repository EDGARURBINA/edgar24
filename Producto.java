class Producto{
    protected String nomProducto;
    protected int  cantidadPaquete;
    protected double precioPorUnidad, precioPorPaquete;

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }
    public void setCantidadPaquete(int cantidadPaquete) {
        this.cantidadPaquete = cantidadPaquete;
    }
    public void setPrecioPorPaquete(double precioPorPaquete) {
        this.precioPorPaquete = precioPorPaquete;
    }
    public void setPrecioPorUnidad(double precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }

    public String getNomProducto() {
        return nomProducto;
    }
    public int getCantidadPaquete() {
        return cantidadPaquete;
    }
    public double getPrecioPorPaquete() {
        return precioPorPaquete;
    }
    public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }
}