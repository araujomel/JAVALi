package javali.Modelo;
public enum FuncaoFuncionario {
    BARISTA("BARISTA"),
    CONFEITEIRO("CONFEITEIRO"),
    GERENTE("GERENTE"),
    ATENDENTE("ATENDENTE");

    
    private String cargo;


    FuncaoFuncionario(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

}
