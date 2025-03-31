package com.kintado.DTO;

public class UtenteDTO {

    private Long id;
    private String email;
    private Boolean active;
    

    public UtenteDTO(Long id, String email, Boolean active) {
        this.id = id;
        this.email = email;
        this.active = active;
    }

    // Getter e Setter

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
