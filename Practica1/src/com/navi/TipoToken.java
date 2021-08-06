package com.navi;

public enum TipoToken {
    IDENTIFICADOR("Identificador"),
    NUMEROENTERO("Número Entero"),
    DECIMAL("Decimal"),
    SIMBOLO("Símbolo"),
    ERROR("Error");
    private final String TIPO;

    private TipoToken(String tipo){
        this.TIPO = tipo;
    }
    public String getTipo() {
        return TIPO;
    }


}
