package javali.Modelo;
public enum FuncaoFuncionario {
    BARISTA("barista"),
    CONFEITEIRO("confeiteiro"),
    GERENTE("gerente"),
    ATENDENTE("atendente");

    
    private String cargo;


    FuncaoFuncionario(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

}
