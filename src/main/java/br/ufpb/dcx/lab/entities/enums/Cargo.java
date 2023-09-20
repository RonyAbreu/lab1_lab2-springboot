package br.ufpb.dcx.lab.entities.enums;

public enum Cargo {
    ADMIN("admin"),
    USUARIO("usuario");

    private String cargo;

    Cargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
}
